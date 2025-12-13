package com.example.mykotlinapplication.stringProblem


// 9. Longest Common Prefix
fun longestCommonPrefix(strs: Array<String>): String {
    // Step 1: Handle empty array case
    if (strs.isEmpty()) return ""

    // Step 2: Sort the array lexicographically
    val sortedStrs = strs.sortedArray()

    // Step 3: Take the first and last strings
    val first = sortedStrs.first()
    val last = sortedStrs.last()

    // Step 4: Find the common prefix between first and last
    var i = 0
    while (i < first.length && i < last.length && first[i] == last[i]) {
        i++
    }

    // Step 5: Return the longest common prefix
    return first.substring(0, i)
}

// Main function to test
fun main() {
    val strs = arrayOf("flower", "flow", "flight")
    val result = longestCommonPrefix(strs)
    println("Longest Common Prefix: \"$result\"")
}









