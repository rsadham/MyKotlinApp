package com.example.mykotlinapplication.stackQueueProblem


fun evalRPN(tokens: Array<String>): Int {
    val stack = ArrayDeque<Int>()
    for (token in tokens) {
        if (token in listOf("+", "-", "*", "/")) {
            val b = stack.removeLast()
            val a = stack.removeLast()
            when (token) {
                "+" -> stack.addLast(a + b)
                "-" -> stack.addLast(a - b)
                "*" -> stack.addLast(a * b)
                "/" -> stack.addLast(a / b)
            }
        } else {
            stack.addLast(token.toInt())
        }
    }
    return stack.removeLast()
}

fun main() {
    val tokens = arrayOf("2", "1", "+", "3", "*") // Example: (2 + 1) * 3 = 9
    val result = evalRPN(tokens)
    println("Result: $result")
}




