package com.example.mykotlinapplication.arrayProblem


fun twoSum(nums: IntArray, target: Int): IntArray {
    val map = mutableMapOf<Int, Int>()
    for (i in nums.indices) {
        val complement = target - nums[i]
        if (map.containsKey(complement)) {
            return intArrayOf(map[complement]!!, i)
        }
        map[nums[i]] = i
    }
    return intArrayOf()
}

fun twoSumBrute(nums: IntArray, target: Int): IntArray {
    for (i in nums.indices) {
        for (j in i + 1 until nums.size) {
            if (nums[i] + nums[j] == target) {
                return intArrayOf(i, j)
            }
        }
    }
    return intArrayOf(-1, -1)
}

fun main() {
    val nums = intArrayOf(2, 7, 11, 15)
    val target = 9

    val result1 = twoSum(nums, target)
    println("Optimized: [${result1.joinToString(", ")}]")

    val result2 = twoSumBrute(nums, target)
    println("Brute Force: [${result2.joinToString(", ")}]")
}







