package com.example.mykotlinapplication.treeProblem

import com.example.mykotlinapplication.TreeNode


// Function to invert the binary tree
fun invertTree(root: TreeNode?): TreeNode? {
    if (root == null) return null

    val left = invertTree(root.left)
    val right = invertTree(root.right)

    root.left = right
    root.right = left

    return root
}

// Helper function to print the tree (In-order traversal)
fun printTree(root: TreeNode?) {
    if (root == null) return
    printTree(root.left)
    print("${root.value} ")  //
    printTree(root.right)
}

fun main() {
    // Construct the binary tree
    val root = TreeNode(4)
    root.left = TreeNode(2)
    root.right = TreeNode(7)
    root.left?.left = TreeNode(1)
    root.left?.right = TreeNode(3)
    root.right?.left = TreeNode(6)
    root.right?.right = TreeNode(9)

    println("Before inversion:")
    printTree(root)
    println()

    invertTree(root)

    println("After inversion:")
    printTree(root)
    println()
}


