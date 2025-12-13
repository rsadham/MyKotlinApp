package com.example.mykotlinapplication.linkedListProblem


// Definition for singly-linked list
class ListNode(var `val`: Int) {
    var next: ListNode? = null
}

// Function to reverse a linked list
fun reverseList(head: ListNode?): ListNode? {
    var prev: ListNode? = null
    var current = head

    while (current != null) {
        val nextNode = current.next
        current.next = prev
        prev = current
        current = nextNode
    }

    return prev
}

// Main function to test reverseList
fun main() {
    // Create linked list: 1 -> 2 -> 3 -> 4 -> 5
    val head = ListNode(1)
    head.next = ListNode(2)
    head.next!!.next = ListNode(3)
    head.next!!.next!!.next = ListNode(4)
    head.next!!.next!!.next!!.next = ListNode(5)

    println("Original List:")
    printListTemp(head)

    // Reverse the list
    val reversedHead = reverseList(head)

    println("Reversed List:")
    printListTemp(reversedHead)
}

// Helper function to print the linked list
fun printListTemp(node: ListNode?) {
    var current = node
    while (current != null) {
        print("${current.`val`} ")
        current = current.next
    }
    println()
}





