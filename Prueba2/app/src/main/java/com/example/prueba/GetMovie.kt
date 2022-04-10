package com.example.prueba

import com.google.gson.annotations.SerializedName

data class GetMovie(
    @SerializedName("page") val page: Int,
    @SerializedName("results") val movies: List<Movie>,
    @SerializedName("total_pages") val pages: Int
)
