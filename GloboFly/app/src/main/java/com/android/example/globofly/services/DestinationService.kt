package com.android.example.globofly.services

import com.android.example.globofly.models.Destination
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query
import retrofit2.http.QueryMap


/*
 *Created by Adithya T Raj on 13-08-2019
*/

interface DestinationService {

    /*@GET("destination")
    fun getDestinationList(@QueryMap filter: HashMap<String, String>): Call<List<Destination>>*/
    @GET("destination")
    fun getDestinationList(@Query("country") country: String?): Call<List<Destination>>

    @GET("destination/{id}")
    fun getDestination(@Path("id") id: Int): Call<Destination>
}