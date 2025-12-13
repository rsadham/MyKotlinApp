package com.example.mykotlinapplication.backtrackingProblem


fun exist(board: Array<CharArray>, word: String): Boolean {
    for (i in board.indices) {
        for (j in board[0].indices) {
            if (dfs(board, word, 0, i, j)) return true
        }
    }
    return false
}

fun dfs(board: Array<CharArray>, word: String, idx: Int, i: Int, j: Int): Boolean {
    if (idx == word.length) return true
    if (i < 0 || j < 0 || i >= board.size || j >= board[0].size || board[i][j] != word[idx])
        return false

    val temp = board[i][j]
    board[i][j] = '#' // mark visited

    val found = dfs(board, word, idx + 1, i + 1, j) ||
            dfs(board, word, idx + 1, i - 1, j) ||
            dfs(board, word, idx + 1, i, j + 1) ||
            dfs(board, word, idx + 1, i, j - 1)

    board[i][j] = temp // backtrack
    return found
}

fun main() {
    val board = arrayOf(
        charArrayOf('A', 'B', 'C', 'E'),
        charArrayOf('S', 'F', 'C', 'S'),
        charArrayOf('A', 'D', 'E', 'E')
    )
    val word = "ABCCED"

    println(exist(board, word)) // Output: true
}








