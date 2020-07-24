package com.app.qartechnician.retrofit.retrofit_helper;

import com.google.gson.GsonBuilder;

import java.io.IOException;
import java.util.HashMap;
import java.util.Iterator;
import java.util.concurrent.TimeUnit;

import okhttp3.Interceptor;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;


public class RetrofitClient {
    private static Retrofit retrofit = null;

    public static Retrofit getAPIClient(String baseUrl) {
        if (retrofit == null){
            retrofit = new Retrofit.Builder()
                    .baseUrl(baseUrl)
                    .addConverterFactory(GsonConverterFactory.create(new GsonBuilder()
                    .setLenient().create()))
                    .client(getOkHttpClient()).build();
        }
        return retrofit;
    }

    public static OkHttpClient getOkHttpClient() {
        HttpLoggingInterceptor httpLoggingInterceptor = new HttpLoggingInterceptor();
        httpLoggingInterceptor.setLevel(HttpLoggingInterceptor.Level.BODY);

        OkHttpClient okHttpClient = new OkHttpClient.Builder()
                .connectTimeout(100, TimeUnit.SECONDS)
                .addInterceptor(httpLoggingInterceptor)
                .addNetworkInterceptor(new Interceptor() {
                    @Override
                    public Response intercept(Chain chain) throws IOException {
                        Request.Builder request = chain.request().newBuilder();
                        HashMap<String, String> headers = APIServiceGenerator.getHeaders();
                        Iterator iterator = headers.keySet().iterator();

                        while(iterator.hasNext()) {
                            String key=(String)iterator.next();
                            String value=(String)headers.get(key);
                            request.addHeader(key, value);
                        }
                        request.method(chain.request().method(), chain.request().body());
                        request.addHeader("Content-Type", "application/json");
                        request.build();

                        return chain.proceed(request.build());
                    }
                })
                .readTimeout(100, TimeUnit.SECONDS)
                .build();

        return okHttpClient;
    }
}

