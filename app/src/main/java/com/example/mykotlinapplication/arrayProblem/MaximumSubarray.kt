package com.example.mykotlinapplication.arrayProblem


// 2. Maximum Subarray (Kadane’s Algorithm)
fun maxSubArray(nums: IntArray): Int {
    var maxSum = nums[0]
    var currSum = nums[0]

    for (i in 1 until nums.size) {
        currSum = maxOf(nums[i], currSum + nums[i])
        maxSum = maxOf(maxSum, currSum)
    }

    return maxSum
}

// Brute force approach
fun maxSubArrayBrute(nums: IntArray): Int {
    var max = Int.MIN_VALUE
    for (i in nums.indices) {
        var sum = 0
        for (j in i until nums.size) {
            sum += nums[j]
            max = maxOf(max, sum)
        }
    }
    return max
}

// Main function
fun main() {
    val nums = intArrayOf(-2, 1, -3, 4, -1, 2, 1, -5, 4)

    val kadaneResult = maxSubArray(nums)
    val bruteResult = maxSubArrayBrute(nums)

    println("Maximum Subarray Sum (Kadane’s): $kadaneResult")
    println("Maximum Subarray Sum (Brute Force): $bruteResult")
}






