package com.example.mykotlinapplication.linkedListProblem

// PalindromeLinkedList
fun main() {
    val node3 = ListNode(1)
    val node2 = ListNode(2)
    node2.next = node3
    val node1 = ListNode(2)
    node1.next = node2
    val head = ListNode(1)
    node1.next = node1

    println(isPalindrome(head)) // Output: true
}

fun isPalindrome(head: ListNode?): Boolean {
    if (head?.next == null) return true

    var slow = head
    var fast = head
    while (fast?.next != null && fast.next?.next != null) {
        slow = slow?.next
        fast = fast.next?.next
    }

    var secondHalf = PalindromeReverseList(slow?.next)
    var firstHalf = head

    while (secondHalf != null) {
        if (firstHalf?.`val` != secondHalf.`val`) return false
        firstHalf = firstHalf?.next
        secondHalf = secondHalf.next
    }
    return true
}

private fun PalindromeReverseList(head: ListNode?): ListNode? {
    var prev: ListNode? = null
    var curr = head
    while (curr != null) {
        val next = curr.next
        curr.next = prev
        prev = curr
        curr = next
    }
    return prev
}