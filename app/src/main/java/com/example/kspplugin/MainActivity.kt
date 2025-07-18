package com.example.kspplugin

import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class MainActivity : AppCompatActivity() {

    private lateinit var viewModel: JokeViewModel
    private lateinit var adapter: JokeAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // RecyclerView setup
        val recyclerView = findViewById<RecyclerView>(R.id.jokesRecyclerView)
        adapter = JokeAdapter()
        recyclerView.layoutManager = LinearLayoutManager(this)
        recyclerView.adapter = adapter

        // Input and buttons
        val inputJoke = findViewById<EditText>(R.id.inputJoke)
        val btnAdd = findViewById<Button>(R.id.btnAddJoke)
        val btnFetch = findViewById<Button>(R.id.btnFetchJoke)

        // ViewModel
        viewModel = ViewModelProvider(this)[JokeViewModel::class.java]

        // Observe Room jokes and update RecyclerView
        viewModel.jokes.observe(this) { jokes ->
            adapter.submitList(jokes)
        }

        // Manually add joke
        btnAdd.setOnClickListener {
            val jokeText = inputJoke.text.toString().trim()
            if (jokeText.isNotEmpty()) {
                viewModel.addJoke(jokeText)
                inputJoke.setText("")
            }
        }

        // Fetch joke from API and insert into Room
        btnFetch.setOnClickListener {
            viewModel.fetchAndInsertFromApi()
        }
    }
}

