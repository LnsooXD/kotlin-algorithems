package leetcode.valid.sudoku

/**
 * 只用来检测填满的数独
 */
class FullBits : ValidSudoku {
    private val rows = IntArray(3) { 0 }
    private val cols = IntArray(3) { 0 }
    private val blocks = IntArray(3) { 0 }

    override fun isValidSudoku(board: Array<CharArray>): Boolean {
        for (i in board.indices) for (j in board[0].indices) {
            this.setBit(i, j, board[i][j])
        }
        return this.isValid()
    }

    private fun setBit(row: Int, col: Int, value: Char) {
        val mask = 1.shl(value - '1')
        val bitRow = row / 3
        val bitCol = col / 3

        this.rows[bitRow] = this.rows[bitRow].or(mask.shl(9 * (row % 3)))
        this.cols[bitCol] = this.cols[bitCol].or(mask.shl(9 * (col % 3)))
        this.blocks[bitRow] = this.blocks[row / 3].or(mask.shl(9 * (bitCol)))
    }

    private fun isValid(): Boolean {
        val mapLambda = { it: Int -> it == 0x07ffffff }
        val reduceLambda = { a: Boolean, b: Boolean -> a && b }

        return this.rows.map(mapLambda).reduce(reduceLambda) &&
                this.cols.map(mapLambda).reduce(reduceLambda) &&
                this.blocks.map(mapLambda).reduce(reduceLambda)
    }
}