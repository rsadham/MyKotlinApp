package com.example.mykotlinapplication.arrayProblem


fun findMin(nums: IntArray): Int {
    var left = 0
    var right = nums.size - 1

    while (left < right) {
        val mid = (left + right) / 2

        // If mid element is greater than right element,
        // minimum is in the right side
        if (nums[mid] > nums[right]) {
            left = mid + 1
        } else {
            // Minimum is in the left side including mid
            right = mid
        }
    }

    return nums[left] // left == right -> minimum element
}

fun main() {
    val nums = intArrayOf(4, 5, 6, 7, 0, 1, 2)
    val result = findMin(nums)
    println("Minimum element: $result") // Output: 0
}








