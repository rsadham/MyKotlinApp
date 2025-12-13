package com.example.mykotlinapplication.backtrackingProblem


fun permute(nums: IntArray): List<List<Int>> {
    val res = mutableListOf<List<Int>>()
    backtrack(nums, mutableListOf(), res)
    return res
}

fun backtrack(nums: IntArray, path: MutableList<Int>, res: MutableList<List<Int>>) {
    if (path.size == nums.size) {
        res.add(ArrayList(path))
        return
    }

    for (num in nums) {
        if (path.contains(num)) continue
        path.add(num)
        backtrack(nums, path, res)
        path.removeAt(path.size - 1)
    }
}

fun main() {
    val nums = intArrayOf(1, 2, 3)
    val result = permute(nums)
    println(result)
}







