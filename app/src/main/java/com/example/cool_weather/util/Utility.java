package com.example.cool_weather.util;

import android.text.TextUtils;

import com.example.cool_weather.db.City;
import com.example.cool_weather.db.County;
import com.example.cool_weather.db.Province;
import com.example.cool_weather.gson.Weather;

import com.example.cool_weather.gson.heweather;
import com.google.gson.Gson;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.List;

public class Utility {
    /**
     * 解析和处理服务器返回的省级数据
     */
      public static boolean handlerProvinceResponse(String response) throws JSONException {
          if(!TextUtils.isEmpty(response)){
              JSONArray allProvince = new JSONArray(response);
              for (int i = 0;i<allProvince.length();i++){
                  JSONObject provinceObject = allProvince.getJSONObject(i);
                  Province province = new Province();
                  province.setProvinceName(provinceObject.getString("name"));
                  province.setProvinceCode(provinceObject.getInt("id"));
                  province.save();
              }
              return true;
          }
          return false;
      }

    /**
     *解析和处理服务器返回的市级数据
     */
      public static boolean handlerCityResponse(String response,int provinceId) throws JSONException{
          if(!TextUtils.isEmpty(response)){
                  JSONArray allCities = new JSONArray(response);
                  for (int i = 0; i < allCities.length(); i++) {
                      JSONObject cityObject = allCities.getJSONObject(i);
                      City city = new City();
                      city.setCityName(cityObject.getString("name"));
                      city.setCityCode(cityObject.getInt("id"));
                      city.setProvinceId(provinceId);
                      city.save();
                  }
                  return true;

              }
          return false;
      }
      public static boolean handlerCountyResponse(String response,int cityId) throws JSONException{
          if(!TextUtils.isEmpty(response)){
              JSONArray allCounties = new JSONArray(response);
                  for (int i = 0;i<allCounties.length();i++){
                      JSONObject jsonObject = allCounties.getJSONObject(i);
                      County county = new County();
                      county.setCountyName(jsonObject.getString("name"));
                      county.setCityId(jsonObject.getInt("id"));
                      county.setWeatherId(jsonObject.getString("weather_id"));
                      county.setCityId(cityId);
                      county.save();
                  }
                  return true;
          }
          return false;
      }
      public static heweather handlerWeatherResponse(String response){
              heweather h = new Gson().fromJson(response,heweather.class);
              List<heweather.HeWeather6> tmp =h.getHeWeather6();
             return h;


      }
}
