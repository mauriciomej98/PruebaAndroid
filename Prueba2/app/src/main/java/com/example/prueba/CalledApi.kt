package com.example.prueba

import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

interface CalledApi {
    @GET("movie/popular")
    fun getPopularMovies(
        @Query("api_key") apiKey: String = "82070cca92999529080d9a1fe3ca22f2",
        @Query("page") page: Int
    ): Call<GetMovie>

    @GET("movie/top_rated")
    fun getPlayNow(
        @Query("api_key") apiKey: String = "82070cca92999529080d9a1fe3ca22f2",
        @Query("page") page: Int
    ): Call<GetMovie>
}
