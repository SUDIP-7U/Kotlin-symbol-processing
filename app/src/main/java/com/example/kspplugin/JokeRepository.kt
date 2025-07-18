package com.example.kspplugin

import androidx.lifecycle.LiveData

class JokeRepository(
    private val dao: JokeDao,
    private val api: JokeApiService
) {
    val allJokes: LiveData<List<Joke>> = dao.getAllJokes()

    suspend fun insert(joke: Joke) = dao.insert(joke)

    suspend fun fetchJokeFromApi(): Joke {
        val response = api.getRandomJoke()
        return Joke(content = response.toJoke())
    }
}
