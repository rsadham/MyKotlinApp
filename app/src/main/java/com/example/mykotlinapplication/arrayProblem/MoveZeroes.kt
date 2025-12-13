package com.example.mykotlinapplication.arrayProblem


// 3. Move Zeroes
fun moveZeroes(nums: IntArray) {
    var insertPos = 0
    for (num in nums) {
        if (num != 0) {
            nums[insertPos++] = num
        }
    }
    while (insertPos < nums.size) {
        nums[insertPos++] = 0
    }
}

fun moveZeroesBrute(nums: IntArray) {
    var index = 0
    for (n in nums) {
        if (n != 0) {
            nums[index] = n
            index++
        }
    }
    for (n in index until nums.size) {
        nums[n] = 0
    }
}

fun main() {
    val nums1 = intArrayOf(0, 1, 0, 3, 12)
    moveZeroes(nums1)
    println("Optimized result: ${nums1.joinToString()}")

    val nums2 = intArrayOf(0, 1, 0, 3, 12)
    moveZeroesBrute(nums2)
    println("Brute result: ${nums2.joinToString()}")
}






