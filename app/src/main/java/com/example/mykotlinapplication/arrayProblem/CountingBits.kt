package com.example.mykotlinapplication.arrayProblem


fun countBits(n: Int): IntArray {
    val dp = IntArray(n + 1)
    var offset = 1

    for (i in 1..n) {
        if (offset * 2 == i) {
            offset = i
        }
        dp[i] = 1 + dp[i - offset]
    }

    return dp
}

fun main() {
    val n = 10
    val result = countBits(n)

    println("Input: $n")
    println("Output: ${result.joinToString(", ")}")
}








