package com.alyndroid.tabbedviews.model

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object RetrofitClient {
    private const val BASE_URL = "https://gadsapi.herokuapp.com/api/"

    private const val SUBMIT_BASE_URL = "https://docs.google.com/forms/d/e/"

    fun doRetrofitService(): RetrofitApi {
        return Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(RetrofitApi::class.java)
    }

    fun doSubmissionService(): RetrofitApi {
        return Retrofit.Builder()
            .baseUrl(SUBMIT_BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(RetrofitApi::class.java)
    }
}