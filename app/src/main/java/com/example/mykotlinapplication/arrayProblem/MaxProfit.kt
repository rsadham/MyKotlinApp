package com.example.mykotlinapplication.arrayProblem


// LeetCode 121 - Best Time to Buy and Sell Stock
// Time: O(n), Space: O(1)
fun maxProfit(prices: IntArray): Int {
    if (prices.isEmpty()) return 0

    var minPrice = prices[0]
    var maxProfit = 0

    for (i in 1 until prices.size) {
        if (prices[i] < minPrice) {
            minPrice = prices[i]  // Update the minimum price
        } else {
            val profit = prices[i] - minPrice
            if (profit > maxProfit) {
                maxProfit = profit  // Update profit only when we get better one
            }
        }
    }

    return maxProfit
}

// Example usage:
fun main() {
    val prices = intArrayOf(7, 1, 5, 3, 6, 4)
    println(maxProfit(prices)) // prints 5 (buy at 1, sell at 6)
}







