package com.example.mykotlinapplication.stackQueueProblem


class MyQueue {
    private val inStack = ArrayDeque<Int>()
    private val outStack = ArrayDeque<Int>()

    fun push(x: Int) {
        inStack.addLast(x)
    }

    fun pop(): Int {
        peek()
        return outStack.removeLast()
    }

    fun peek(): Int {
        if (outStack.isEmpty()) {
            while (inStack.isNotEmpty()) {
                outStack.addLast(inStack.removeLast())
            }
        }
        return outStack.last()
    }

    fun empty(): Boolean {
        return inStack.isEmpty() && outStack.isEmpty()
    }
}

fun main() {
    val queue = MyQueue()
    queue.push(1)
    queue.push(2)
    println(queue.peek())  // Output: 1
    println(queue.pop())   // Output: 1
    println(queue.empty()) // Output: false
}




