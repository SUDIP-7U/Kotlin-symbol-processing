package com.example.kspplugin

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class JokeAdapter : RecyclerView.Adapter<JokeAdapter.JokeViewHolder>() {

    private val jokes = mutableListOf<Joke>()

    fun submitList(newList: List<Joke>) {
        jokes.clear()
        jokes.addAll(newList)
        notifyDataSetChanged()
    }

    inner class JokeViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val tvJoke: TextView = itemView.findViewById(R.id.tvJoke)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): JokeViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_joke, parent, false)
        return JokeViewHolder(view)
    }

    override fun getItemCount(): Int = jokes.size

    override fun onBindViewHolder(holder: JokeViewHolder, position: Int) {
        holder.tvJoke.text = jokes[position].content
    }
}
