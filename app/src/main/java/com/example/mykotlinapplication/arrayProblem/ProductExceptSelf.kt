package com.example.mykotlinapplication.arrayProblem


fun productExceptSelf(nums: IntArray): IntArray {
    val n = nums.size
    val result = IntArray(n)

    // Step 1: Fill result with prefix products
    var prefix = 1
    for (i in 0 until n) {
        result[i] = prefix
        prefix *= nums[i]
    }

    // Step 2: Multiply with suffix products
    var suffix = 1
    for (i in n - 1 downTo 0) {
        result[i] *= suffix
        suffix *= nums[i]
    }

    return result
}

// Main function to run and test
fun main() {
    val nums = intArrayOf(1, 2, 3, 4)
    val output = productExceptSelf(nums)

    println("Input: ${nums.joinToString()}")
    println("Output: ${output.joinToString()}")
}







