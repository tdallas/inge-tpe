package com.ingeapp.dagger.modules;

import com.google.gson.Gson;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import okhttp3.OkHttpClient;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

@Module
public class ServiceModule {
    @Provides
    @Singleton
    public Retrofit provideRetrofit(Gson gson) {
        OkHttpClient client = new OkHttpClient.Builder().build();
        return new Retrofit.Builder()
                .baseUrl("localhost:8080/")
                .addConverterFactory(GsonConverterFactory.create(gson))
                .client(client)
                .build();
    }

    /**
     *  @Provides
     @Singleton
     public AlgoService provideAlgoService(Retrofit retrofit){
     return retrofit.create(AlgoService.class);
     }

     */


}