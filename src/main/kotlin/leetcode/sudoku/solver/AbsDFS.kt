package leetcode.sudoku.solver

abstract class AbsDFS : SudokuSolver {

    final override fun solveSudoku(board: Array<CharArray>) {
        this.setExistsBits(board)
        this.solveSudoku(board, 0, 0)
    }

    private fun setExistsBits(board: Array<CharArray>) {
        for (i in 0..8) {
            for (j in 0..8) {
                val valueChar = board[i][j]
                if (valueChar != '.') {
                    val value: Int = valueChar - '0'
                    this.acceptValue(board, i, j, value)
                }
            }
        }
    }

    private fun solveSudoku(
        board: Array<CharArray>,
        i: Int,
        j: Int
    ): Boolean {
        val valueChar = board[i][j]
        if (valueChar != '.') {
            return solveNextSudoku(board, i, j)
        }

        for (value in 1..9) {
            if (!this.checkValid(i, j, value)) {
                continue
            }
            this.acceptValue(board, i, j, value)
            if (this.solveNextSudoku(board, i, j)) {
                return true
            }
            this.rejectValue(board, i, j, value)
        }
        return false
    }

    protected abstract fun acceptValue(board: Array<CharArray>, i: Int, j: Int, value: Int)
    protected abstract fun rejectValue(board: Array<CharArray>, i: Int, j: Int, value: Int)
    protected abstract fun checkValid(i: Int, j: Int, value: Int): Boolean

    private fun solveNextSudoku(
        board: Array<CharArray>,
        i: Int,
        j: Int
    ) = if (i == 8) {
        if (j == 8) {
            true
        } else {
            solveSudoku(board, 0, j + 1)
        }
    } else {
        solveSudoku(board, i + 1, j)
    }


}