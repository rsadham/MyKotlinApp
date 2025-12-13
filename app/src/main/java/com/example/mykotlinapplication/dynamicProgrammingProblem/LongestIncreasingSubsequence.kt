package com.example.mykotlinapplication.dynamicProgrammingProblem


fun lengthOfLIS(nums: IntArray): Int {
    val sub = mutableListOf<Int>()
    for (num in nums) {
        var i = sub.binarySearch(num)
        if (i < 0) i = -(i + 1)
        if (i == sub.size) sub.add(num)
        else sub[i] = num
    }
    return sub.size
}

fun main() {
    val nums = intArrayOf(10, 9, 2, 5, 3, 7, 101, 18)
    val result = lengthOfLIS(nums)
    println("Length of Longest Increasing Subsequence: $result")
}





