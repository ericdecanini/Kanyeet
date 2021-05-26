package com.ericdecanini.kanyeet

import com.squareup.moshi.Moshi
import com.squareup.moshi.kotlin.reflect.KotlinJsonAdapterFactory
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory

class KanyeRepository {

    private val moshi = Moshi.Builder()
        .add(KotlinJsonAdapterFactory())
        .build()

    private val kanyeApi = Retrofit.Builder()
        .addConverterFactory(MoshiConverterFactory.create(moshi))
        .baseUrl("https://api.kanye.rest/")
        .build()
        .create(KanyeApi::class.java)

    suspend fun getQuote() = kanyeApi
        .getQuote()
        .quote

}
