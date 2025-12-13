package com.example.mykotlinapplication.dynamicProgrammingProblem


fun coinChange(coins: IntArray, amount: Int): Int {
    val dp = IntArray(amount + 1) { amount + 1 } // initialize with "infinity"
    dp[0] = 0

    for (a in 1..amount) {
        for (c in coins) {
            if (a - c >= 0) {
                dp[a] = minOf(dp[a], 1 + dp[a - c])
            }
        }
    }

    return if (dp[amount] > amount) -1 else dp[amount]
}

fun main() {
    val coins = intArrayOf(1, 2, 5)
    val amount = 11
    println(coinChange(coins, amount)) // Output: 3 (5 + 5 + 1)
}





