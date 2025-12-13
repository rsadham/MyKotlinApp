package com.example.mykotlinapplication.backtrackingProblem


fun main() {
    val s = "aab"
    val result = partition(s)
    println(result)
}

fun partition(s: String): List<List<String>> {
    val res = mutableListOf<List<String>>()
    backtrack(0, s, mutableListOf(), res)
    return res
}

fun backtrack(start: Int, s: String, path: MutableList<String>, res: MutableList<List<String>>) {
    if (start == s.length) {
        res.add(ArrayList(path))
        return
    }

    for (end in start + 1..s.length) {
        val substr = s.substring(start, end)
        if (isPalindrome(substr)) {
            path.add(substr)
            backtrack(end, s, path, res)
            path.removeAt(path.size - 1)
        }
    }
}

fun isPalindrome(s: String): Boolean {
    var l = 0
    var r = s.length - 1
    while (l < r) {
        if (s[l++] != s[r--]) return false
    }
    return true
}








