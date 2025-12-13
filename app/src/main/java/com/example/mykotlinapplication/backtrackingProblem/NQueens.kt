package com.example.mykotlinapplication.backtrackingProblem


fun solveNQueens(n: Int): List<List<String>> {
    val res = mutableListOf<List<String>>()
    val board = Array(n) { CharArray(n) { '.' } }
    backtrack(0, board, res)
    return res
}

fun backtrack(row: Int, board: Array<CharArray>, res: MutableList<List<String>>) {
    if (row == board.size) {
        res.add(board.map { String(it) })
        return
    }

    for (col in board.indices) {
        if (isSafe(board, row, col)) {
            board[row][col] = 'Q'
            backtrack(row + 1, board, res)
            board[row][col] = '.'
        }
    }
}

fun isSafe(board: Array<CharArray>, row: Int, col: Int): Boolean {
    for (i in 0 until row) {
        if (board[i][col] == 'Q') return false
    }

    var i = row - 1
    var j = col - 1
    while (i >= 0 && j >= 0) {
        if (board[i][j] == 'Q') return false
        i--; j--
    }

    i = row - 1
    j = col + 1
    while (i >= 0 && j < board.size) {
        if (board[i][j] == 'Q') return false
        i--; j++
    }

    return true
}

fun main() {
    val n = 4
    val result = solveNQueens(n)
    for (solution in result) {
        for (row in solution) {
            println(row)
        }
        println()
    }
}







