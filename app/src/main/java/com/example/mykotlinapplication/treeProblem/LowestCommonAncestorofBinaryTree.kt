package com.example.mykotlinapplication.treeProblem

import com.example.mykotlinapplication.TreeNode


fun main() {
    // Creating a sample binary tree
    //        3
    //       / \
    //      5   1
    //     / \ / \
    //    6  2 0  8
    //      / \
    //     7   4

    val root = TreeNode(3)
    val node5 = TreeNode(5)
    val node1 = TreeNode(1)
    val node6 = TreeNode(6)
    val node2 = TreeNode(2)
    val node0 = TreeNode(0)
    val node8 = TreeNode(8)
    val node7 = TreeNode(7)
    val node4 = TreeNode(4)

    root.left = node5
    root.right = node1
    node5.left = node6
    node5.right = node2
    node2.left = node7
    node2.right = node4
    node1.left = node0
    node1.right = node8

    // Test 1: LCA of 5 and 1
    val lca1 = lowestCommonAncestor(root, node5, node1)
    println("LCA of 5 and 1 is: ${lca1?.value}") // Expected: 3

    // Test 2: LCA of 6 and 4
    val lca2 = lowestCommonAncestor(root, node6, node4)
    println("LCA of 6 and 4 is: ${lca2?.value}") // Expected: 5

    // Test 3: LCA of 7 and 8
    val lca3 = lowestCommonAncestor(root, node7, node8)
    println("LCA of 7 and 8 is: ${lca3?.value}") // Expected: 3
}

fun lowestCommonAncestor(root: TreeNode?, p: TreeNode, q: TreeNode): TreeNode? {
    // Base case: if root is null, or root is one of the nodes (p or q)
    if (root == null || root == p || root == q) return root

    // Recursively search for LCA in left subtree
    val left = lowestCommonAncestor(root.left, p, q)

    // Recursively search for LCA in right subtree
    val right = lowestCommonAncestor(root.right, p, q)

    // If both left and right are not null, root is the LCA
    if (left != null && right != null) return root

    // Otherwise, return the non-null child (either left or right)
    return left ?: right
}


