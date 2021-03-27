package com.android.savyourlibrary.networking;

import java.util.concurrent.TimeUnit;

import okhttp3.OkHttpClient;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class WebClient
{
    private static Retrofit INSTANCE;


    public static Retrofit getInstance() {
        if (INSTANCE == null) {
            setupRestClient();
        }
        return INSTANCE;
    }

    public static void setupRestClient() {

        OkHttpClient httpClient = new OkHttpClient.Builder()
                .addInterceptor(new LoggingInterceptor())
                .connectTimeout(30, TimeUnit.SECONDS)
                .writeTimeout(50, TimeUnit.SECONDS)
                .readTimeout(50, TimeUnit.SECONDS)
                .build();

        INSTANCE = new Retrofit.Builder()
                .baseUrl("https://api-staging.savyour.com.pk/v3/")
                .addConverterFactory(GsonConverterFactory.create())
                .client(httpClient)
                .build();
    }
}
