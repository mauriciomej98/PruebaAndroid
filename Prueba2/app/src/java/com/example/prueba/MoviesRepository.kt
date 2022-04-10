package com.example.prueba


import android.util.Log
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import kotlin.reflect.KFunction1

object MoviesRepository {
    private val api: CalledApi

    init {
        val retrofit = Retrofit.Builder()
            .baseUrl("https://api.themoviedb.org/3/")
            .addConverterFactory(GsonConverterFactory.create())
            .build()

        api = retrofit.create(CalledApi::class.java)
    }

    fun getPopularMovies(
        page: Int = 1,
        onSuccess: (movies: List<Movie>) -> Unit,
        onError: () -> Unit
    ) {
        api.getPopularMovies(page = page)
            .enqueue(object : Callback<GetMovie> {
                override fun onResponse(
                    call: Call<GetMovie>,
                    response: Response<GetMovie>
                ) {
                    if (response.isSuccessful) {
                        val responseBody = response.body()

                        if (responseBody != null) {
                            onSuccess.invoke(responseBody.movies)
                        } else {
                            onError.invoke()
                        }
                    } else {
                        onError.invoke()
                    }
                }

                override fun onFailure(call: Call<GetMovie>, t: Throwable) {
                    onError.invoke()
                }
            })
    }
    fun getPlayNowMovies(
        page: Int = 1,
        onSucces: (movies: List<Movie>) -> Unit,
        onError: () -> Unit
    ) {
        api.getPlayNow(page = page)
            .enqueue(object : Callback<GetMovie> {
                override fun onResponse(
                    call: Call<GetMovie>,
                    response: Response<GetMovie>
                ) {
                    if (response.isSuccessful) {
                        val responseBody = response.body()
                        if (responseBody != null) {
                          onSucces.invoke(responseBody.movies)
                        } else {
                            onError.invoke()
                        }
                    } else {
                        onError.invoke()
                    }
                }

                override fun onFailure(call: Call<GetMovie>, t: Throwable) {
                    onError.invoke()
                }
            }
            )
    }
}
