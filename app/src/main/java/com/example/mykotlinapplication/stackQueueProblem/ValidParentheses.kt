package com.example.mykotlinapplication.stackQueueProblem

import kotlin.text.iterator


fun isValid(s: String): Boolean {
    val stack = ArrayDeque<Char>()
    for (c in s) {
        when (c) {
            '(', '{', '[' -> stack.addLast(c)
            else -> {
                if (stack.isEmpty()) return false
                val top = stack.removeLast()
                if ((c == ')' && top != '(') ||
                    (c == '}' && top != '{') ||
                    (c == ']' && top != '[')
                ) return false
            }
        }
    }
    return stack.isEmpty()
}

fun main() {
    val input1 = "()[]{}"
    val input2 = "(]"
    val input3 = "{[]}"

    println("$input1 -> ${isValid(input1)}") // true
    println("$input2 -> ${isValid(input2)}") // false
    println("$input3 -> ${isValid(input3)}") // true
}




