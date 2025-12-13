package com.example.mykotlinapplication.backtrackingProblem


fun subsets(nums: IntArray): List<List<Int>> {
    val res = mutableListOf<List<Int>>()
    backtrack(0, nums, mutableListOf(), res)
    return res
}

fun backtrack(start: Int, nums: IntArray, path: MutableList<Int>, res: MutableList<List<Int>>) {
    res.add(ArrayList(path))
    for (i in start until nums.size) {
        path.add(nums[i])
        backtrack(i + 1, nums, path, res)
        path.removeAt(path.size - 1)
    }
}

fun main() {
    val nums = intArrayOf(1, 2, 3)
    val result = subsets(nums)
    println(result)
}






