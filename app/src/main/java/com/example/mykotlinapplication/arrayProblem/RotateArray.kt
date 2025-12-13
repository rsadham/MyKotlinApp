package com.example.mykotlinapplication.arrayProblem


// 4. Rotate Array
fun rotate(nums: IntArray, k: Int) {
    val steps = k % nums.size
    reverse(nums, 0, nums.size - 1)
    reverse(nums, 0, steps - 1)
    reverse(nums, steps, nums.size - 1)
}

private fun reverse(nums: IntArray, startIndex: Int, endIndex: Int) {
    var start = startIndex
    var end = endIndex
    while (start < end) {
        val temp = nums[start]
        nums[start] = nums[end]
        nums[end] = temp
        start++
        end--
    }
}

fun rotateBrute(nums: IntArray, k: Int) {
    val steps = k % nums.size
    if (steps == 0) return
    val rotated = nums.takeLast(steps) + nums.dropLast(steps)
    for (i in nums.indices) {
        nums[i] = rotated[i]
    }
}

fun main() {
    val nums = intArrayOf(1, 2, 3, 4, 5, 6, 7)
    val k = 3

    println("Original Array: ${nums.joinToString(", ")}")

    // Using optimized approach
    rotate(nums, k)
    println("After rotation (optimized): ${nums.joinToString(", ")}")

    // Using brute force
    val nums2 = intArrayOf(1, 2, 3, 4, 5, 6, 7)
    rotateBrute(nums2, k)
    println("After rotation (brute): ${nums2.joinToString(", ")}")
}






