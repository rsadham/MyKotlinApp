package com.example.mykotlinapplication.dynamicProgrammingProblem

//rsadham
fun rob(nums: IntArray): Int {
    // If there are no houses, nothing to rob
    if (nums.isEmpty()) return 0

    var prev1 = 0 // Max money till previous house
    var prev2 = 0 // Max money till house before previous

    // Go through each house one by one
    for (num in nums) {
        val temp = prev1        // Save old prev1
        // Either rob this house (prev2 + num) or skip it (prev1)
        prev1 = maxOf(prev2 + num, prev1)
        prev2 = temp            // Move prev1 to prev2 for next round
    }

    // Finally, prev1 has the best total money
    return prev1
}

fun main() {
    val nums = intArrayOf(2, 7, 9, 3, 1)
    println("Maximum amount robbed: ${rob(nums)}")
}






