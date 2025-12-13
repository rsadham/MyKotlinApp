package com.example.mykotlinapplication.greedyProblem


fun canCompleteCircuit(gas: IntArray, cost: IntArray): Int {
    var total = 0
    var curr = 0
    var start = 0

    for (i in gas.indices) {
        total += gas[i] - cost[i]
        curr += gas[i] - cost[i]

        if (curr < 0) {
            start = i + 1
            curr = 0
        }
    }
    return if (total < 0) -1 else start
}

fun main() {
    val gas = intArrayOf(1, 2, 3, 4, 5)
    val cost = intArrayOf(3, 4, 5, 1, 2)
    val result = canCompleteCircuit(gas, cost)
    println("Starting station index: $result")
}








