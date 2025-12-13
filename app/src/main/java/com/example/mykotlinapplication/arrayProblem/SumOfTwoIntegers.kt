package com.example.mykotlinapplication.arrayProblem


fun getSum(a: Int, b: Int): Int {
    var x = a
    var y = b

    while (y != 0) {
        val carry = (x and y) shl 1   // Calculate carry
        x = x xor y                   // Add without carry
        y = carry                     // Move carry to next iteration
    }

    return x
}

fun main() {
    val a = 5
    val b = -3
    val result = getSum(a, b)
    println("Sum of $a and $b is: $result")
}








