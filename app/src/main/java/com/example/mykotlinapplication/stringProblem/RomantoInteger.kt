package com.example.mykotlinapplication.stringProblem


fun romanToInt(s: String): Int {
    val map = mapOf(
        'I' to 1, 'V' to 5, 'X' to 10,
        'L' to 50, 'C' to 100, 'D' to 500, 'M' to 1000
    )

    var sum = 0
    for (n in s.indices) {
        val current = map[s[n]]!!
        if (n + 1 < s.length && current < map[s[n + 1]]!!) {
            sum -= current
        } else {
            sum += current
        }
    }
    return sum
}

fun main() {
    val roman1 = "III"
    val roman2 = "LVIII"
    val roman3 = "MCMXCIV"

    println("$roman1 -> ${romanToInt(roman1)}")   // Output: 3
    println("$roman2 -> ${romanToInt(roman2)}")   // Output: 58
    println("$roman3 -> ${romanToInt(roman3)}")   // Output: 1994
}









