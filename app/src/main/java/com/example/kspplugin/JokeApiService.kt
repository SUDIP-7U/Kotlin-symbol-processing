package com.example.kspplugin

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET

interface JokeApiService {
    @GET("joke/Any")
    suspend fun getRandomJoke(): JokeApiResponse

    companion object {
        fun create(): JokeApiService {
            val retrofit = Retrofit.Builder()
                .baseUrl("https://v2.jokeapi.dev/")
                .addConverterFactory(GsonConverterFactory.create())
                .build()

            return retrofit.create(JokeApiService::class.java)
        }
    }
}
