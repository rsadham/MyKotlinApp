package com.example.mykotlinapplication.greedyProblem


fun merge(intervals: Array<IntArray>): Array<IntArray> {
    // Step 1: Sort intervals by start time
    intervals.sortBy { it[0] }

    val result = mutableListOf<IntArray>()
    var current = intervals[0]

    // Step 2: Merge overlapping intervals
    for (i in 1 until intervals.size) {
        if (current[1] >= intervals[i][0]) {
            current[1] = maxOf(current[1], intervals[i][1])
        } else {
            result.add(current)
            current = intervals[i]
        }
    }

    result.add(current)
    return result.toTypedArray()
}

// Main function to test
fun main() {
    val intervals = arrayOf(
        intArrayOf(1, 3),
        intArrayOf(2, 6),
        intArrayOf(8, 10),
        intArrayOf(15, 18)
    )

    val merged = merge(intervals)
    println("Merged intervals:")
    for (interval in merged) {
        println("[${interval[0]}, ${interval[1]}]")
    }
}









