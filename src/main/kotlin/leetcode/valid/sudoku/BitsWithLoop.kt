package leetcode.valid.sudoku

class BitsWithLoop : ValidSudoku {

    private val rows = IntArray(3) { 0 }
    private val cols = IntArray(3) { 0 }
    private val blocks = IntArray(3) { 0 }

    override fun isValidSudoku(board: Array<CharArray>): Boolean {
        for (i in board.indices) for (j in board[0].indices) {
            if (board[i][j] == '.') {
                continue
            }
            val value = board[i][j] - '1'
            if (!this.isValid(i, j, value)) {
                return false
            }
            this.setBit(i, j, value)
        }
        return true
    }

    private fun setBit(row: Int, col: Int, value: Int) {
        val mask = 1.shl(value)
        val bitRow = row / 3
        val bitCol = col / 3

        this.rows[bitRow] = this.rows[bitRow].or(mask.shl(9 * (row % 3)))
        this.cols[bitCol] = this.cols[bitCol].or(mask.shl(9 * (col % 3)))
        this.blocks[bitRow] = this.blocks[row / 3].or(mask.shl(9 * (bitCol)))
    }

    private fun isValid(row: Int, col: Int, value: Int) = 1.shl(value).let {
        val bitRow = row / 3
        val bitCol = col / 3

        this.rows[bitRow].and(it.shl(9 * (row % 3))) == 0 &&
                this.cols[bitCol].and(it.shl(9 * (col % 3))) == 0 &&
                this.blocks[bitRow].and(it.shl(9 * (col / 3))) == 0
    }
}