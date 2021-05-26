package com.ericdecanini.kanyeet

import retrofit2.http.GET

interface KanyeApi {

    @GET("/")
    suspend fun getQuote(): QuoteResponse

}
