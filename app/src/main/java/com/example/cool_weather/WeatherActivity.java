package com.example.cool_weather;

import android.content.Intent;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ScrollView;
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.example.cool_weather.gson.Weather;
import com.example.cool_weather.gson.heweather;
import com.example.cool_weather.service.AutoUpdateService;
import com.example.cool_weather.util.HttpUtil;
import com.example.cool_weather.util.Utility;

import java.io.IOException;
import java.util.List;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.Response;

public class WeatherActivity extends AppCompatActivity {
  private ScrollView weatherLayout;
  public DrawerLayout drawerLayout;
//  public SwipeRefreshLayout swipeRefresh;
  private Button titleButton;
  private TextView titleCity;
  private TextView titleUpdateTime;
  private TextView degreeText;
  private TextView weatherInfoText;
  private LinearLayout forecastLayout;
  private  TextView aqiText;
  private TextView pm25Text;
  private TextView comfortText;
  private TextView carWashText;
  private TextView sportText;
  private ImageView bingPicImg;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_weather);
        drawerLayout=findViewById(R.id.drawer_layout);
//        swipeRefresh=findViewById(R.id.swipe_refresh);
       titleButton=findViewById(R.id.title_button);
        bingPicImg=findViewById(R.id.bing_pic_img);
        weatherLayout = findViewById(R.id.weather_layout);
        titleCity =findViewById(R.id.title_city);
        titleUpdateTime=findViewById(R.id.title_update_time);
        degreeText=findViewById(R.id.degree_text);
        weatherInfoText=findViewById(R.id.weather_info_text);
        forecastLayout=findViewById(R.id.forecast_layout);
        aqiText=findViewById(R.id.aqi_text);
        pm25Text=findViewById(R.id.pm25_text);
        comfortText=findViewById(R.id.comfort_text);
        carWashText=findViewById(R.id.car_wash_text);
        sportText=findViewById(R.id.sport_text);
        SharedPreferences pres = PreferenceManager.getDefaultSharedPreferences(this);
        String weatherString = pres.getString("weather",null);
        if(weatherString!=null){
           heweather weather = Utility.handlerWeatherResponse(weatherString);
            weatherLayout.setVisibility(View.INVISIBLE);
            showWeatherInfo(weather);
        }else{
            String weatherId = getIntent().getStringExtra("weather_id");
            weatherLayout.setVisibility(View.INVISIBLE);
            requestWeather(weatherId);
        }
        String bing_pic = pres.getString("bing_pic",null);
        if(bing_pic!=null){
            Glide.with(this).load(bing_pic).into(bingPicImg);
        }else {
            loadBingPic();
        }
      titleButton.setOnClickListener(new View.OnClickListener() {
          @Override
          public void onClick(View v) {
              drawerLayout.openDrawer(GravityCompat.START);
              Toast.makeText(WeatherActivity.this,"加载天气失败",Toast.LENGTH_SHORT).show();
          }
      });
    }
    public void requestWeather(final String weatherId){
        String weatherUrl =" https://free-api.heweather.com/s6/weather/forecast?key=613a5123d89a4f64b9eb3a62580f0d8b&location="+weatherId;
        HttpUtil.sendOkHttpRequest(weatherUrl, new Callback() {
            @Override
            public void onFailure(Call call, IOException e) {
                             runOnUiThread(new Runnable() {
                                 @Override
                                 public void run() {
                                     Toast.makeText(WeatherActivity.this,"加载天气失败",Toast.LENGTH_SHORT).show();
                                 }
                             });
            }

            @Override
            public void onResponse(Call call, Response response) throws IOException {
                    final String responseText=response.body().string();
                    final heweather weather=Utility.handlerWeatherResponse(responseText);
                    runOnUiThread(new Runnable() {
                        @Override
                        public void run() {
                            if(weather!=null&&"ok".equals(weather.getHeWeather6().get(0).getStatus())){
                                SharedPreferences.Editor editor=PreferenceManager.getDefaultSharedPreferences(WeatherActivity.this).edit();
                                editor.putString("weather",responseText);
                                editor.apply();
                                showWeatherInfo(weather);
                            }else{
                                Toast.makeText(WeatherActivity.this,"加载天气失败",Toast.LENGTH_SHORT).show();
                            }
                        }
                    });
            }
        });
        loadBingPic();
    }
    private void showWeatherInfo(heweather weather){
        if(weather!=null&&"ok".equals(weather.getHeWeather6().get(0).getStatus())){
            Intent intent = new Intent(this, AutoUpdateService.class);
            startService(intent);
        }else {
            Toast.makeText(WeatherActivity.this,"加载天气失败",Toast.LENGTH_SHORT).show();
        }
        String cityName = weather.getHeWeather6().get(0).getBasic().getLocation();
        String updateTime = weather.getHeWeather6().get(0).getUpdate().getLoc().split("")[1];
        String degree = weather.getHeWeather6().get(0).getDaily_forecast().get(0).getTmp_max();
        String weatherInfo= weather.getHeWeather6().get(0).getDaily_forecast().get(0).getCond_code_n();
        titleCity.setText(cityName);
        titleUpdateTime.setText(updateTime);
        degreeText.setText(degree);
        weatherInfoText.setText(weatherInfo);
        forecastLayout.removeAllViews();
        for(int i=0;i<weather.getHeWeather6().get(0).getDaily_forecast().size();i++){
            View view = LayoutInflater.from(this).inflate(R.layout.forecast_item,forecastLayout,false);
             TextView dateText =  view.findViewById(R.id.date_text);
             TextView infoText =  view.findViewById(R.id.info_text);
            TextView maxText  =  view.findViewById(R.id.max_text);
            TextView minText  = view.findViewById(R.id.min_text);
            dateText.setText(weather.getHeWeather6().get(0).getDaily_forecast().get(i).getDate());
            infoText.setText(weather.getHeWeather6().get(0).getDaily_forecast().get(i).getCond_txt_n());
            maxText.setText(weather.getHeWeather6().get(0).getDaily_forecast().get(i).getTmp_max());
            minText.setText(weather.getHeWeather6().get(0).getDaily_forecast().get(i).getTmp_min());
            forecastLayout.addView(view);
        }
            aqiText.setText( weather.getHeWeather6().get(0).getDaily_forecast().get(0).getHum());
            pm25Text.setText(weather.getHeWeather6().get(0).getDaily_forecast().get(0).getPop());

        String comfort = "舒适度：";
        String carWash= "洗车指数：";
        String sport= "运动建议：";
        comfortText.setText(comfort);
        sportText.setText(sport);
         carWashText.setText(carWash);
         weatherLayout.setVisibility(View.VISIBLE);
    }
    private void loadBingPic(){
        String requestBingPic = "http://guolin.tech/api/bing_pic";
        HttpUtil.sendOkHttpRequest(requestBingPic, new Callback() {
            @Override
            public void onFailure(Call call, IOException e) {
                e.printStackTrace();
            }

            @Override
            public void onResponse(Call call, Response response) throws IOException {
                 final  String pic=response.body().string();
                 SharedPreferences.Editor editor = PreferenceManager.getDefaultSharedPreferences(WeatherActivity.this).edit();
                 editor.putString("bing_pic",pic);
                 editor.apply();
                 runOnUiThread(new Runnable() {
                     @Override
                     public void run() {
                         Glide.with(WeatherActivity.this).load(pic).into(bingPicImg);
                     }
                 });
            }
        });
    }
}
