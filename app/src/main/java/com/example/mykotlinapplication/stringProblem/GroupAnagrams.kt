package com.example.mykotlinapplication.stringProblem


// 8. Group Anagrams
fun groupAnagrams(strs: Array<String>): List<List<String>> {
    val map = mutableMapOf<String, MutableList<String>>()

    for (str in strs) {
        val chars = str.toCharArray()
        chars.sort()
        val key = String(chars)

        val list = map.getOrPut(key) { mutableListOf() }
        list.add(str)
    }

    return map.values.toList()
}

fun main() {
    val input = arrayOf("eat", "tea", "tan", "ate", "nat", "bat")
    val result = groupAnagrams(input)

    println("Grouped Anagrams:")
    for (group in result) {
        println(group)
    }
}








