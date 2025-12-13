package com.example.mykotlinapplication.arrayProblem


fun hammingWeight(n: Int): Int {
    var count = 0
    var num = n

    while (num != 0) {
        num = num and (num - 1)  // Remove the rightmost 1 bit
        count++
    }
    return count
}

fun main() {
    println(hammingWeight(11))  // 11 in binary: 1011 -> Output: 3
    println(hammingWeight(128)) // 128 in binary: 10000000 -> Output: 1
    println(hammingWeight(0))   // Output: 0
}







