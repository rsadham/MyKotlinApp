package com.example.mykotlinapplication.arrayProblem


fun reverseBits(n: Int): Int {
    var num = n
    var result = 0

    for (i in 0 until 32) {
        result = result shl 1       // Shift result left to make space
        result = result or (num and 1) // Add last bit of num into result
        num = num ushr 1           // Shift num right (unsigned)
    }

    return result
}

fun main() {
    val input = 43261596 // Example input (decimal)

    val output = reverseBits(input)
    println("Reversed Bits: $output")
}







