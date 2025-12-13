package com.example.mykotlinapplication.treeProblem

import com.example.mykotlinapplication.TreeNode
import java.util.LinkedList
import java.util.Queue


// Function to invert the binary tree
fun levelOrder(root: TreeNode?): List<List<Int>> {
    val result = mutableListOf<List<Int>>()
    if (root == null) return result

    val queue: Queue<TreeNode> = LinkedList()
    queue.offer(root)

    while (queue.isNotEmpty()) {
        val size = queue.size
        val level = mutableListOf<Int>()

        repeat(size) {
            val curr = queue.poll()
            if (curr != null) {
                level.add(curr.value)
                curr.left?.let { queue.offer(it) }
                curr.right?.let { queue.offer(it) }
            }
        }

        result.add(level)
    }

    return result
}

fun main() {
    // Create the tree:
    //       1
    //      / \
    //     2   3
    //    / \   \
    //   4   5   6

    val root = TreeNode(1)
    root.left = TreeNode(2)
    root.right = TreeNode(3)
    root.left?.left = TreeNode(4)
    root.left?.right = TreeNode(5)
    root.right?.right = TreeNode(6)

    val result = levelOrder(root)

    // Print result
    for (level in result) {
        println(level)
    }
}


