package com.example.mykotlinapplication.dynamicProgrammingProblem


fun minDistance(word1: String, word2: String): Int {
    val m = word1.length
    val n = word2.length
    var prev = IntArray(n + 1) { it }  // base: dp[0][j] = j
    var curr = IntArray(n + 1)

    for (i in 1..m) {
        curr[0] = i  // base: dp[i][0] = i
        for (j in 1..n) {
            curr[j] = if (word1[i - 1] == word2[j - 1]) {
                prev[j - 1]
            } else {
                1 + minOf(prev[j - 1], prev[j], curr[j - 1])
            }
        }
        prev = curr.copyOf()
    }
    return prev[n]
}

fun main() {
    val word1 = "horse"
    val word2 = "ros"
    println("Minimum Edit Distance: ${minDistance(word1, word2)}")
}





