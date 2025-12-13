package com.example.mykotlinapplication.designProblem


import java.util.*

import java.util.*

class Codec {
    private val map = HashMap<String, String>()
    private val reverse = HashMap<String, String>()
    private val base = "http://short.ly/"
    private var id = 1

    fun encode(longUrl: String): String {
        if (reverse.containsKey(longUrl)) {
            return base + reverse[longUrl]
        }
        val code = id++.toString(36)
        map[code] = longUrl
        reverse[longUrl] = code
        return base + code
    }

    fun decode(shortUrl: String): String {
        val code = shortUrl.removePrefix(base)
        return map[code] ?: ""
    }
}

fun main() {
    val codec = Codec()
    val longUrl = "https://www.example.com/my-long-url"
    val shortUrl = codec.encode(longUrl)
    println("Encoded: $shortUrl")

    val decodedUrl = codec.decode(shortUrl)
    println("Decoded: $decodedUrl")
}










