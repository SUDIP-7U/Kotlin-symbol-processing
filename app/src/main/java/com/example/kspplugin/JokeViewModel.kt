package com.example.kspplugin

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.launch

class JokeViewModel(application: Application) : AndroidViewModel(application) {

    private val repo: JokeRepository
    val jokes: LiveData<List<Joke>>

    init {
        val dao = JokeDatabase.getDatabase(application).jokeDao()
        val api = JokeApiService.create()
        repo = JokeRepository(dao, api)
        jokes = repo.allJokes
    }

    fun addJoke(joke: String) {
        viewModelScope.launch {
            repo.insert(Joke(content = joke))
        }
    }

    fun fetchAndInsertFromApi() {
        viewModelScope.launch {
            val joke = repo.fetchJokeFromApi()
            repo.insert(joke)
        }
    }
}
