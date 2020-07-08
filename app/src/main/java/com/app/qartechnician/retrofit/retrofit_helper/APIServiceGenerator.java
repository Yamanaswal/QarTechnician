package com.app.qartechnician.retrofit.retrofit_helper;

import java.util.HashMap;


public class APIServiceGenerator {

    private static String BASE_URL = "http://3.12.253.202:4242/";
    private static HashMap<String, String> headers = new HashMap<>();

    public static <S> S createService(Class<S> serviceClass) {
        return RetrofitClient.getAPIClient(BASE_URL).create(serviceClass);
    }

    public static void setBaseUrl(String url){
        BASE_URL = url;
    }

    public static void addHeader(String key, String value){
        headers.put(key, value);
    }

    protected static HashMap<String, String> getHeaders(){
        return headers;
    }
}