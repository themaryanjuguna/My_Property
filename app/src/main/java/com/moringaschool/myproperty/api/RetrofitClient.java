package com.moringaschool.myproperty.api;

import com.moringaschool.myproperty.models.Constants;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class RetrofitClient {
    private static Retrofit retrofit = null;

    public static ApiCalls getClient(){
        if (retrofit == null){
            retrofit = new Retrofit.Builder().baseUrl(Constants.BASEURL).addConverterFactory(GsonConverterFactory.create()).build();
        }
        return retrofit.create(ApiCalls.class);
    }

}
