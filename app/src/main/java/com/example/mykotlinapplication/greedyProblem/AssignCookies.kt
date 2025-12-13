package com.example.mykotlinapplication.greedyProblem


fun findContentChildren(g: IntArray, s: IntArray): Int {
    g.sort()
    s.sort()
    var child = 0
    var cookie = 0

    while (child < g.size && cookie < s.size) {
        if (s[cookie] >= g[child]) child++
        cookie++
    }
    return child
}

fun main() {
    val g = intArrayOf(1, 2, 3) // Greed factors
    val s = intArrayOf(1, 1)    // Cookie sizes

    val result = findContentChildren(g, s)
    println("Number of content children: $result")
}









