package leetcode.sudoku.solver

class NaiveDFS : SudokuSolver {

    private val values = CharArray(9) { (it + '1'.toInt()).toChar() }

    override fun solveSudoku(board: Array<CharArray>) {
        this.solve(board)
    }

    private fun solve(board: Array<CharArray>): Boolean {
        for (i in board.indices) for (j in board[0].indices) {
            if (board[i][j] == '.') {
                for (value in values) {
                    if (this.isValid(board, i, j, value)) {
                        board[i][j] = value
                        if (this.solve(board)) {
                            return true
                        } else {
                            board[i][j] = '.'
                        }
                    }
                }
                return false
            }
        }
        return true
    }

    private fun isValid(board: Array<CharArray>, row: Int, col: Int, value: Char): Boolean {
        for (i in board.indices) {
            if (board[row][i] == value) {
                return false
            }
            if (board[i][col] == value) {
                return false
            }

            if (board[3 * (row / 3) + (i / 3)][3 * (col / 3) + (i % 3)] == value) {
                return false
            }
        }
        return true
    }
}