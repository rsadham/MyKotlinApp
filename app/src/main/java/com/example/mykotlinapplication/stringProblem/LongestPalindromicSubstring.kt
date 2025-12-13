package com.example.mykotlinapplication.stringProblem


// 7. Longest Palindromic Substring
fun longestPalindrome(s: String?): String {
    if (s.isNullOrEmpty()) return ""
    var start = 0
    var end = 0
    for (i in s.indices) {
        val len1 = expectLongestPalindrome(s, i, i)
        val len2 = expectLongestPalindrome(s, i, i + 1)
        val len = maxOf(len1, len2)
        if (len > end - start) {
            start = i - (len - 1) / 2
            end = i + len / 2
        }
    }
    return s.substring(start, end + 1)
}

fun expectLongestPalindrome(s: String, left: Int, right: Int): Int {
    var l = left
    var r = right
    while (l >= 0 && r < s.length && s[l] == s[r]) {
        l--
        r++
    }
    return r - l - 1
}

fun main() {
    val input = "babad"
    val result = longestPalindrome(input)
    println("Input: $input")
    println("Longest Palindromic Substring: $result")
}








