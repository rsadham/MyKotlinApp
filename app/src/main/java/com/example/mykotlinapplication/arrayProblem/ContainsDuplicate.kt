package com.example.mykotlinapplication.arrayProblem


fun containsDuplicate(nums: IntArray): Boolean {
    val seen = HashSet<Int>()

    for (num in nums) {
        if (num in seen) return true
        seen.add(num)
    }
    return false
}

fun main() {
    val nums = intArrayOf(1, 2, 3, 1) // test input

    if (containsDuplicate(nums)) {
        println("Contains Duplicate")
    } else {
        println("No Duplicates Found")
    }
}







