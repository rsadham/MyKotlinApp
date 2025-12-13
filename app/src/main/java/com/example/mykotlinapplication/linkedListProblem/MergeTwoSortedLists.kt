package com.example.mykotlinapplication.linkedListProblem


fun mergeTwoLists(list1: ListNode?, list2: ListNode?): ListNode? {
    val dummy = ListNode(0)
    var current: ListNode? = dummy
    var l1 = list1
    var l2 = list2

    while (l1 != null && l2 != null) {
        if (l1.`val` <= l2.`val`) {
            current?.next = l1
            l1 = l1.next
        } else {
            current?.next = l2
            l2 = l2.next
        }
        current = current?.next
    }

    current?.next = l1 ?: l2
    return dummy.next
}

fun printList(head: ListNode?) {
    var curr = head
    while (curr != null) {
        print("${curr.`val`} ")
        curr = curr.next
    }
    println()
}

fun main() {
    // Create first linked list: 1 -> 2 -> 4
    val l1 = ListNode(1)
    l1.next = ListNode(2)
    l1.next!!.next = ListNode(4)

    // Create second linked list: 1 -> 3 -> 4
    val l2 = ListNode(1)
    l2.next = ListNode(3)
    l2.next!!.next = ListNode(4)

    // Merge lists
    val merged = mergeTwoLists(l1, l2)

    // Print merged list
    printList(merged)
}





