package com.example.gadsleaderboardapp.network;

import com.google.gson.Gson;

import okhttp3.OkHttpClient;

import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.converter.gson.GsonConverterFactory;

public class RetrofitClient {
    private OkHttpClient getInterceptor(){
        HttpLoggingInterceptor interceptor = new HttpLoggingInterceptor();
        interceptor.level(HttpLoggingInterceptor.Level.BODY);
        OkHttpClient client = new OkHttpClient.Builder().addInterceptor(interceptor).build();
        return client;
    }

    retrofit2.Retrofit.Builder mRetrofitBuilder = new retrofit2.Retrofit.Builder().baseUrl("https://gadsapi.herokuapp.com").client(getInterceptor()).addConverterFactory(GsonConverterFactory.create());
    retrofit2.Retrofit mRetrofit = mRetrofitBuilder.build();

    public retrofit2.Retrofit getmRetrofit(){
        return mRetrofit;
    }
}
