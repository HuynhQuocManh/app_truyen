package com.huynhquocmanh.apptruyen.API;

public class APIService {
    public  static final String Base_url = "https://huynhquocmanh211.000webhostapp.com/Server/";
    public static  DataService getdata(){
        return APIRetrofitlnit.getclient(Base_url).create(DataService.class);
    }
}
