package com.example.mykotlinapplication.arrayProblem


fun missingNumber(nums: IntArray): Int {
    var n = nums.size  // Start with n

    for (i in nums.indices) {
        n = n xor i  // XOR with index
        n = n xor nums[i]  // XOR with number
    }
    return n
}

fun main() {
    val nums = intArrayOf(3, 0, 1)
    val result = missingNumber(nums)
    println("Missing Number: $result")  // Output: 2
}








