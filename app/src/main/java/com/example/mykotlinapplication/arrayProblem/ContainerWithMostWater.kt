package com.example.mykotlinapplication.arrayProblem


fun maxArea(height: IntArray): Int {
    var left = 0
    var right = height.size - 1
    var maxArea = 0

    while (left < right) {
        val width = right - left
        val currentHeight = minOf(height[left], height[right])
        val area = width * currentHeight
        maxArea = maxOf(maxArea, area)

        // Move the smaller pointer inward
        if (height[left] < height[right]) {
            left++
        } else {
            right--
        }
    }

    return maxArea
}

fun main() {
    val heights = intArrayOf(1,8,6,2,5,4,8,3,7)
    println("Max Water Area: ${maxArea(heights)}")  // Output: 49
}








