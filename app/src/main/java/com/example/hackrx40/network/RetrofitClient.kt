package com.example.hackrx40.network

import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object RetrofitClient {
    private val client = OkHttpClient.Builder().build()
    fun getInstance():Retrofit{
        return  Retrofit.Builder()
            .baseUrl("https://hackrx.fly.dev")
            .addConverterFactory(GsonConverterFactory.create())
            .client(client)
            .build()
    }
    fun init(): Api
    {
        return getInstance().create(Api::class.java)
    }
}