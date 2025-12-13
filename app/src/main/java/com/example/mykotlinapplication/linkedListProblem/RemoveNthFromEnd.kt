package com.example.mykotlinapplication.linkedListProblem

fun removeNthFromEnd(head: ListNode?, n: Int): ListNode? {
    val dummy = ListNode(0)
    dummy.next = head
    var first: ListNode? = dummy
    var second: ListNode? = dummy

    // Move first n + 1 steps ahead safely
    for (i in 0..n) {
        if (first == null) return head // n is larger than list length
        first = first.next
    }

    // Move both pointers until first reaches the end
    while (first != null) {
        first = first.next
        second = second?.next
    }

    // Skip the target node
    second?.next = second?.next?.next

    return dummy.next
}

// Example usage
fun main() {
    val node5 = ListNode(5)
    val node4 = ListNode(4).apply { next = node5 }
    val node3 = ListNode(3).apply { next = node4 }
    val node2 = ListNode(2).apply { next = node3 }
    val head = ListNode(1).apply { next = node2 }

    val result = removeNthFromEnd(head, 2)

    var curr = result
    while (curr != null) {
        print("${curr.`val`} ")
        curr = curr.next
    }
    // Output: 1 2 3 5
}
