package com.example.mykotlinapplication.designProblem


class LRUCache(private val capacity: Int) {

    inner class Node(var key: Int, var value: Int) {
        var prev: Node? = null
        var next: Node? = null
    }

    private val map = HashMap<Int, Node>()
    private val head = Node(0, 0)
    private val tail = Node(0, 0)

    init {
        head.next = tail
        tail.prev = head
    }

    fun get(key: Int): Int {
        val node = map[key] ?: return -1
        remove(node)
        insertToFront(node)
        return node.value
    }

    fun put(key: Int, value: Int) {
        if (map.containsKey(key)) {
            remove(map[key]!!)
        }
        if (map.size == capacity) {
            remove(tail.prev!!)
        }
        insertToFront(Node(key, value))
    }

    private fun remove(node: Node) {
        map.remove(node.key)
        node.prev?.next = node.next
        node.next?.prev = node.prev
    }

    private fun insertToFront(node: Node) {
        map[node.key] = node
        node.next = head.next
        node.prev = head
        head.next?.prev = node
        head.next = node
    }
}

// Test the LRUCache
fun main() {
    val cache = LRUCache(2)
    cache.put(1, 1)
    cache.put(2, 2)
    println(cache.get(1)) // Output: 1
    cache.put(3, 3)       // Evicts key 2
    println(cache.get(2)) // Output: -1 (not found)
    cache.put(4, 4)       // Evicts key 1
    println(cache.get(1)) // Output: -1
    println(cache.get(3)) // Output: 3
    println(cache.get(4)) // Output: 4
}






