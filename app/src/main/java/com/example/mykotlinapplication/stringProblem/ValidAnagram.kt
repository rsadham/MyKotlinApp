package com.example.mykotlinapplication.stringProblem


// 6. Valid Anagram
fun isAnagram(s: String, t: String): Boolean {
    if (s.length != t.length) return false
    val count = IntArray(26)
    for (i in s.indices) {
        count[s[i] - 'a']++
        count[t[i] - 'a']--
    }
    for (c in count) {
        if (c != 0) return false
    }
    return true
}

fun isAnagramBrute(s: String, t: String): Boolean {
    if (s.length != t.length) return false
    val a = s.toCharArray()
    val b = t.toCharArray()
    a.sort()
    b.sort()
    return a.contentEquals(b)
}

fun main() {
    val s = "anagram"
    val t = "nagaram"

    println("Optimized approach: ${isAnagram(s, t)}")   // true
    println("Brute force approach: ${isAnagramBrute(s, t)}")  // true
}







