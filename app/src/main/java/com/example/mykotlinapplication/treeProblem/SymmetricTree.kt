package com.example.mykotlinapplication.treeProblem

import com.example.mykotlinapplication.TreeNode


fun isSymmetric(root: TreeNode?): Boolean {
    if (root == null) return true
    return isMirror(root.left, root.right)
}

fun isMirror(t1: TreeNode?, t2: TreeNode?): Boolean {
    if (t1 == null && t2 == null) return true
    if (t1 == null || t2 == null) return false

    return (t1.value == t2.value) &&
            isMirror(t1.left, t2.right) &&
            isMirror(t1.right, t2.left)
}

fun main() {
    // Create a symmetric binary tree
    val root = TreeNode(1)
    root.left = TreeNode(2)
    root.right = TreeNode(2)
    root.left?.left = TreeNode(3)
    root.left?.right = TreeNode(4)
    root.right?.left = TreeNode(4)
    root.right?.right = TreeNode(3)

    // Check if the tree is symmetric
    println("Is tree symmetric? ${isSymmetric(root)}")
}




