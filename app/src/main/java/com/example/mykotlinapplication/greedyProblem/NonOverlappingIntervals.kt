package com.example.mykotlinapplication.greedyProblem


fun eraseOverlapIntervals(intervals: Array<IntArray>): Int {
    // Sort intervals by their end time
    intervals.sortBy { it[1] }

    var end = intervals[0][1]
    var count = 0

    for (i in 1 until intervals.size) {
        if (intervals[i][0] < end) {
            count++ // overlap found
        } else {
            end = intervals[i][1]
        }
    }

    return count
}

fun main() {
    val intervals = arrayOf(
        intArrayOf(1, 2),
        intArrayOf(2, 3),
        intArrayOf(3, 4),
        intArrayOf(1, 3)
    )

    val result = eraseOverlapIntervals(intervals)
    println("Minimum number of intervals to remove: $result")
}









