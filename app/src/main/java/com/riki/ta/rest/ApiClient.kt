package com.riki.ta.rest

import com.google.gson.GsonBuilder
import retrofit.GsonConverterFactory
import retrofit.Retrofit
import retrofit.RxJavaCallAdapterFactory

object ApiClient {
    private const val BASE_URL = "http://informatika.upgris.ac.id/mobile/data/index.php/api/example/"

    fun provideApi(): ApiService {
        val gson = GsonBuilder().create()
        return Retrofit.Builder()
            .addCallAdapterFactory(RxJavaCallAdapterFactory.create())
            .addConverterFactory(GsonConverterFactory.create(gson))
            .baseUrl(BASE_URL)
            .build()
            .create(ApiService::class.java)
    }
}
