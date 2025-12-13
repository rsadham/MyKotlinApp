package com.example.mykotlinapplication.arrayProblem


fun threeSum(nums: IntArray): List<List<Int>> {
    val result = mutableListOf<List<Int>>()
    nums.sort()

    for (i in nums.indices) {
        // Skip duplicate values for i
        if (i > 0 && nums[i] == nums[i - 1]) continue

        var left = i + 1
        var right = nums.size - 1

        while (left < right) {
            val sum = nums[i] + nums[left] + nums[right]

            when {
                sum == 0 -> {
                    result.add(listOf(nums[i], nums[left], nums[right]))

                    // Move both pointers and avoid duplicates
                    left++
                    right--

                    while (left < right && nums[left] == nums[left - 1]) left++
                    while (left < right && nums[right] == nums[right + 1]) right--
                }

                sum < 0 -> left++
                else -> right--
            }
        }
    }

    return result
}

fun main() {
    val nums = intArrayOf(-1, 0, 1, 2, -1, -4)
    val result = threeSum(nums)
    println("Output: $result")
}







