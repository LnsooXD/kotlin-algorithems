package leetcode.valid.sudoku

class ThreeLoops : ValidSudoku {
    override fun isValidSudoku(board: Array<CharArray>): Boolean {
        return isColumnsValid(board) && isRowsValid(board) && isBlocksValid(board)
    }

    private fun isColumnsValid(board: Array<CharArray>): Boolean {
        for (i in board.indices) { // col
            var bits = 0
            for (j in board.indices) { // row
                bits = checkAndSetBitForNumber(bits, board[j][i])
                if (bits == -1) {
                    return false
                }
            }
        }
        return true
    }

    private fun isRowsValid(board: Array<CharArray>): Boolean {
        for (row in board) {
            var bits = 0
            for (value in row) {
                bits = checkAndSetBitForNumber(bits, value)
                if (bits == -1) {
                    return false
                }
            }
        }
        return true
    }

    private fun isBlocksValid(board: Array<CharArray>): Boolean {
        for (x in 0 until 3) {
            for (y in 0 until 3) {
                if (!isBlockValid(board, x * 3, y * 3)) {
                    return false
                }
            }
        }
        return true
    }

    private fun isBlockValid(board: Array<CharArray>, x: Int, y: Int): Boolean {
        var bits = 0
        for (i in 0 until 3) {
            for (j in 0 until 3) {
                val value = board[x + i][y + j]
                bits = checkAndSetBitForNumber(bits, value)
                if (bits == -1) {
                    return false
                }
            }
        }
        return true
    }

    private fun checkAndSetBitForNumber(bits: Int, num: Char): Int {
        if (num == '.') {
            return bits
        }
        val mask = 1.shl(num - '0')
        if (bits.and(mask) != 0) {
            return -1
        }
        return bits.or(mask)
    }
}