package com.example.mykotlinapplication.linkedListProblem


fun hasCycle(head: ListNode?): Boolean {
    var slow = head
    var fast = head

    while (fast != null && fast.next != null) {
        slow = slow?.next
        fast = fast.next?.next

        if (slow == fast) return true
    }
    return false
}

fun main() {
    // Create nodes
    val node1 = ListNode(3)
    val node2 = ListNode(2)
    val node3 = ListNode(0)
    val node4 = ListNode(-4)

    // Link nodes to form a cycle: 3 -> 2 -> 0 -> -4 -> 2
    node1.next = node2
    node2.next = node3
    node3.next = node4
    node4.next = node2 // Creates a cycle

    val head = node1
    println("Has cycle: ${hasCycle(head)}") // Output: true

    // Example without cycle
    val a = ListNode(1)
    val b = ListNode(2)
    a.next = b

    println("Has cycle: ${hasCycle(a)}") // Output: false
}





