package leetcode.valid.sudoku

class Loop : ValidSudoku {

    override fun isValidSudoku(board: Array<CharArray>): Boolean {
        for (i in board.indices) for (j in board[0].indices) {
            val value = board[i][j]
            if (value == '.') {
                continue
            }
            board[i][j] = '.'
            val res = this.isValid(board, i, j, value)
            board[i][j] = value
            if (!res) {
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