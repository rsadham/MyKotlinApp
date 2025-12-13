package com.example.mykotlinapplication.arrayProblem


fun maxProduct(nums: IntArray): Int {
    // Initialize maxProd, minProd and result as the first element of the array
    var maxProd = nums[0]
    var minProd = nums[0]
    var result = nums[0]

    // Traverse from the second element onwards
    for (i in 1 until nums.size) {
        val current = nums[i]
        // If current is negative, swap maxProd and minProd
        if (current < 0) {
            val temp = maxProd
            maxProd = minProd
            minProd = temp
        }
        // Calculate maxProd and minProd ending at current index
        maxProd = maxOf(current, maxProd * current)
        minProd = minOf(current, minProd * current)

        // Update result with the maximum product found so far
        result = maxOf(result, maxProd)
    }
    return result
}

fun main() {
    val arr = intArrayOf(-2, 6, -3, -10, 0, 2)
    println("Maximum Product Subarray: ${maxProduct(arr)}")
}







