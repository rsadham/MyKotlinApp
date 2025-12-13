package com.example.mykotlinapplication.treeProblem

import com.example.mykotlinapplication.TreeNode


var maxDiameter = 0

fun diameterOfBinaryTree(root: TreeNode?): Int {
    maxDepth(root)
    return maxDiameter
}

fun maxDepth(node: TreeNode?): Int {
    if (node == null) return 0

    val left = maxDepth(node.left)
    val right = maxDepth(node.right)

    // Update global max diameter
    maxDiameter = maxOf(maxDiameter, left + right)

    return 1 + maxOf(left, right)
}

fun main() {
    // Create sample tree
    val root = TreeNode(1)
    root.left = TreeNode(2)
    root.right = TreeNode(3)
    root.left?.left = TreeNode(4)
    root.left?.right = TreeNode(5)

    println("Diameter of binary tree: ${diameterOfBinaryTree(root)}")
}



