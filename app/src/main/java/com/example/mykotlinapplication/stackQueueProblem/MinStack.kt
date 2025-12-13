package com.example.mykotlinapplication.stackQueueProblem


class MinStack {
    private val stack = ArrayDeque<Int>()
    private val minStack = ArrayDeque<Int>()

    fun push(`val`: Int) {
        stack.addLast(`val`)
        if (minStack.isEmpty() || `val` <= minStack.last()) {
            minStack.addLast(`val`)
        }
    }

    fun pop() {
        val removed = stack.removeLast()
        if (removed == minStack.last()) {
            minStack.removeLast()
        }
    }

    fun top(): Int = stack.last()

    fun getMin(): Int = minStack.last()
}

fun main() {
    val minStack = MinStack()
    minStack.push(-2)
    minStack.push(0)
    minStack.push(-3)
    println("Minimum: ${minStack.getMin()}") // Output: -3

    minStack.pop()
    println("Top: ${minStack.top()}")        // Output: 0
    println("Minimum: ${minStack.getMin()}") // Output: -2
}




