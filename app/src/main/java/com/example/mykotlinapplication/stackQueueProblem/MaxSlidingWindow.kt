package com.example.mykotlinapplication.stackQueueProblem


fun maxSlidingWindow(nums: IntArray, k: Int): IntArray {
    if (nums.isEmpty() || k == 0) return intArrayOf()

    val n = nums.size
    val res = IntArray(n - k + 1)
    val dq = ArrayDeque<Int>() // stores indices

    for (i in nums.indices) {
        // Remove indices out of current window
        if (dq.isNotEmpty() && dq.first() <= i - k) {
            dq.removeFirst()
        }

        // Remove smaller elements from the end
        while (dq.isNotEmpty() && nums[dq.last()] < nums[i]) {
            dq.removeLast()
        }

        dq.addLast(i) // add current index

        // Store max for current window
        if (i >= k - 1) {
            res[i - k + 1] = nums[dq.first()]
        }
    }

    return res
}

fun main() {
    val nums = intArrayOf(1, 3, -1, -3, 5, 3, 6, 7)
    val k = 3
    val result = maxSlidingWindow(nums, k)
    println(result.joinToString(", "))  // Output: 3, 3, 5, 5, 6, 7
}




