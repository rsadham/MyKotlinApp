package com.example.mykotlinapplication.designProblem


import java.util.*

class HitCounter {
    private val queue: Queue<Int> = LinkedList()

    fun hit(timestamp: Int) {
        queue.offer(timestamp)
    }

    fun getHits(timestamp: Int): Int {
        while (queue.isNotEmpty() && timestamp - queue.peek() >= 300) {
            queue.poll()
        }
        return queue.size
    }
}

fun main() {
    val counter = HitCounter()

    counter.hit(1)
    counter.hit(2)
    counter.hit(300)
    println(counter.getHits(300)) // Output: 3

    counter.hit(301)
    println(counter.getHits(301)) // Output: 3 (timestamp 1 removed)
}







