package com.example.mykotlinapplication.greedyProblem


fun canJump(nums: IntArray): Boolean {
    var reachable = 0
    for (i in nums.indices) {
        if (i > reachable) return false
        reachable = maxOf(reachable, i + nums[i])
    }
    return true
}

fun main() {
    val nums1 = intArrayOf(2, 3, 1, 1, 4)
    val nums2 = intArrayOf(3, 2, 1, 0, 4)

    println("Can jump (nums1): ${canJump(nums1)}") // true
    println("Can jump (nums2): ${canJump(nums2)}") // false
}







