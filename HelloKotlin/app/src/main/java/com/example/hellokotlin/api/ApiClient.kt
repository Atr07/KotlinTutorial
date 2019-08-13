package com.example.hellokotlin.api

import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory


/*
 *Created by Adithya T Raj on 08-08-2019
*/

object ApiClient {
    private const val BASE_URL = "https://api.scoreexams.com/"

    val okHttpClient = OkHttpClient().newBuilder()
        .addInterceptor(AuthenticationInterceptor("SE20180001", "ASCDER\$G%1"))
        .build()

    val retrofit = Retrofit.Builder()
        .client(okHttpClient)
        .baseUrl(BASE_URL)
        .addConverterFactory(GsonConverterFactory.create())
        .build()
}