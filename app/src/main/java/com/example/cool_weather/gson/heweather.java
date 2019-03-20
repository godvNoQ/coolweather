package com.example.cool_weather.gson;

import java.util.List;

public class heweather {
    private List<HeWeather6> HeWeather6;
    public List<HeWeather6> getHeWeather6() {
        return HeWeather6;
    }

    public void setHeWeather6(List<HeWeather6> HeWeather6) {
        this.HeWeather6 = HeWeather6;
    }

    public static class HeWeather6 {
        /**
         * basic : {"cid":"CN101340405","location":"花莲","parent_city":"花莲","admin_area":"台湾","cnty":"中国","lat":"23.9829998","lon":"121.60299683","tz":"+8.00"}
         * update : {"loc":"2019-03-14 08:55","utc":"2019-03-14 00:55"}
         * status : ok
         * daily_forecast : [{"cond_code_d":"305","cond_code_n":"305","cond_txt_d":"小雨","cond_txt_n":"小雨","date":"2019-03-14","hum":"77","mr":"11:05","ms":"00:00","pcpn":"0.5","pop":"55","pres":"967","sr":"06:02","ss":"18:02","tmp_max":"21","tmp_min":"16","uv_index":"1","vis":"24","wind_deg":"357","wind_dir":"北风","wind_sc":"1-2","wind_spd":"2"},{"cond_code_d":"305","cond_code_n":"100","cond_txt_d":"小雨","cond_txt_n":"晴","date":"2019-03-15","hum":"65","mr":"11:58","ms":"00:51","pcpn":"2.1","pop":"55","pres":"970","sr":"06:01","ss":"18:03","tmp_max":"20","tmp_min":"16","uv_index":"1","vis":"17","wind_deg":"9","wind_dir":"北风","wind_sc":"3-4","wind_spd":"12"},{"cond_code_d":"305","cond_code_n":"305","cond_txt_d":"小雨","cond_txt_n":"小雨","date":"2019-03-16","hum":"76","mr":"12:57","ms":"01:51","pcpn":"0.0","pop":"25","pres":"969","sr":"06:00","ss":"18:03","tmp_max":"22","tmp_min":"16","uv_index":"0","vis":"22","wind_deg":"109","wind_dir":"东南风","wind_sc":"1-2","wind_spd":"6"}]
         */

        private heweather.HeWeather6.basic basic;
        private heweather.HeWeather6.update update;
        private String status;
        private List<heweather.HeWeather6.daily_forecast> daily_forecast;

        public heweather.HeWeather6.basic getBasic() {
            return basic;
        }

        public void setBasic(heweather.HeWeather6.basic basic) {
            this.basic = basic;
        }

        public heweather.HeWeather6.update getUpdate() {
            return update;
        }

        public void setUpdate(heweather.HeWeather6.update update) {
            this.update = update;
        }

        public String getStatus() {
            return status;
        }

        public void setStatus(String status) {
            this.status = status;
        }

        public List<heweather.HeWeather6.daily_forecast> getDaily_forecast() {
            return daily_forecast;
        }

        public void setDaily_forecast(List<heweather.HeWeather6.daily_forecast> daily_forecast) {
            this.daily_forecast = daily_forecast;
        }

        public static class basic
        {
            /**
             * cid : CN101340405
             * location : 花莲
             * parent_city : 花莲
             * admin_area : 台湾
             * cnty : 中国
             * lat : 23.9829998
             * lon : 121.60299683
             * tz : +8.00
             */

            private String cid;
            private String location;
            private String parent_city;
            private String admin_area;
            private String cnty;
            private String lat;
            private String lon;
            private String tz;

            public String getCid() {
                return cid;
            }

            public void setCid(String cid) {
                this.cid = cid;
            }

            public String getLocation() {
                return location;
            }

            public void setLocation(String location) {
                this.location = location;
            }

            public String getParent_city() {
                return parent_city;
            }

            public void setParent_city(String parent_city) {
                this.parent_city = parent_city;
            }

            public String getAdmin_area() {
                return admin_area;
            }

            public void setAdmin_area(String admin_area) {
                this.admin_area = admin_area;
            }

            public String getCnty() {
                return cnty;
            }

            public void setCnty(String cnty) {
                this.cnty = cnty;
            }

            public String getLat() {
                return lat;
            }

            public void setLat(String lat) {
                this.lat = lat;
            }

            public String getLon() {
                return lon;
            }

            public void setLon(String lon) {
                this.lon = lon;
            }

            public String getTz() {
                return tz;
            }

            public void setTz(String tz) {
                this.tz = tz;
            }
        }

        public static class update {
            /**
             * loc : 2019-03-14 08:55
             * utc : 2019-03-14 00:55
             */

            private String loc;
            private String utc;

            public String getLoc() {
                return loc;
            }

            public void setLoc(String loc) {
                this.loc = loc;
            }

            public String getUtc() {
                return utc;
            }

            public void setUtc(String utc) {
                this.utc = utc;
            }
        }

        public static class daily_forecast {
            /**
             * cond_code_d : 305
             * cond_code_n : 305
             * cond_txt_d : 小雨
             * cond_txt_n : 小雨
             * date : 2019-03-14
             * hum : 77
             * mr : 11:05
             * ms : 00:00
             * pcpn : 0.5
             * pop : 55
             * pres : 967
             * sr : 06:02
             * ss : 18:02
             * tmp_max : 21
             * tmp_min : 16
             * uv_index : 1
             * vis : 24
             * wind_deg : 357
             * wind_dir : 北风
             * wind_sc : 1-2
             * wind_spd : 2
             */

            private String cond_code_d;
            private String cond_code_n;
            private String cond_txt_d;
            private String cond_txt_n;
            private String date;
            private String hum;
            private String mr;
            private String ms;
            private String pcpn;
            private String pop;
            private String pres;
            private String sr;
            private String ss;
            private String tmp_max;
            private String tmp_min;
            private String uv_index;
            private String vis;
            private String wind_deg;
            private String wind_dir;
            private String wind_sc;
            private String wind_spd;

            public String getCond_code_d() {
                return cond_code_d;
            }

            public void setCond_code_d(String cond_code_d) {
                this.cond_code_d = cond_code_d;
            }

            public String getCond_code_n() {
                return cond_code_n;
            }

            public void setCond_code_n(String cond_code_n) {
                this.cond_code_n = cond_code_n;
            }

            public String getCond_txt_d() {
                return cond_txt_d;
            }

            public void setCond_txt_d(String cond_txt_d) {
                this.cond_txt_d = cond_txt_d;
            }

            public String getCond_txt_n() {
                return cond_txt_n;
            }

            public void setCond_txt_n(String cond_txt_n) {
                this.cond_txt_n = cond_txt_n;
            }

            public String getDate() {
                return date;
            }

            public void setDate(String date) {
                this.date = date;
            }

            public String getHum() {
                return hum;
            }

            public void setHum(String hum) {
                this.hum = hum;
            }

            public String getMr() {
                return mr;
            }

            public void setMr(String mr) {
                this.mr = mr;
            }

            public String getMs() {
                return ms;
            }

            public void setMs(String ms) {
                this.ms = ms;
            }

            public String getPcpn() {
                return pcpn;
            }

            public void setPcpn(String pcpn) {
                this.pcpn = pcpn;
            }

            public String getPop() {
                return pop;
            }

            public void setPop(String pop) {
                this.pop = pop;
            }

            public String getPres() {
                return pres;
            }

            public void setPres(String pres) {
                this.pres = pres;
            }

            public String getSr() {
                return sr;
            }

            public void setSr(String sr) {
                this.sr = sr;
            }

            public String getSs() {
                return ss;
            }

            public void setSs(String ss) {
                this.ss = ss;
            }

            public String getTmp_max() {
                return tmp_max;
            }

            public void setTmp_max(String tmp_max) {
                this.tmp_max = tmp_max;
            }

            public String getTmp_min() {
                return tmp_min;
            }

            public void setTmp_min(String tmp_min) {
                this.tmp_min = tmp_min;
            }

            public String getUv_index() {
                return uv_index;
            }

            public void setUv_index(String uv_index) {
                this.uv_index = uv_index;
            }

            public String getVis() {
                return vis;
            }

            public void setVis(String vis) {
                this.vis = vis;
            }

            public String getWind_deg() {
                return wind_deg;
            }

            public void setWind_deg(String wind_deg) {
                this.wind_deg = wind_deg;
            }

            public String getWind_dir() {
                return wind_dir;
            }

            public void setWind_dir(String wind_dir) {
                this.wind_dir = wind_dir;
            }

            public String getWind_sc() {
                return wind_sc;
            }

            public void setWind_sc(String wind_sc) {
                this.wind_sc = wind_sc;
            }

            public String getWind_spd() {
                return wind_spd;
            }

            public void setWind_spd(String wind_spd) {
                this.wind_spd = wind_spd;
            }
        }
    }
}
