package com.example.kspplugin

data class JokeApiResponse(
    val joke: String?,             // For single joke type
    val setup: String?,            // For two-part
    val delivery: String?,
    val type: String
) {
    fun toJoke(): String {
        return if (type == "twopart") {
            "$setup\n$delivery"
        } else {
            joke ?: ""
        }
    }
}
