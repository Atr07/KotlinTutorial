package com.example.hellokotlin.api

import android.util.Base64
import okhttp3.Credentials
import okhttp3.Interceptor
import okhttp3.Response


/*
 *Created by Adithya T Raj on 08-08-2019
*/

class AuthenticationInterceptor(user: String, password: String) : Interceptor {
    private val credentials: String = Credentials.basic(user, password)

    override fun intercept(chain: Interceptor.Chain): Response {
        //val AUTH = "Basic " + Base64.encodeToString(credentials.toByteArray(), Base64.NO_WRAP)
        val request = chain.request()
        val authenticatedRequest = request.newBuilder()
            .header("Authorization", credentials)
            .build()
        return chain.proceed(authenticatedRequest)
    }
}