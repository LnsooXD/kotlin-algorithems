package leetcode.n.queens.ii

class DFSWithBytes2 : NQueensII {
    override fun totalNQueens(n: Int) = totalNQueens(1.shl(n) - 1, 1, 0, 0, 0)

    private fun totalNQueens(allCols: Int, row: Int, midCols: Int, leftCols: Int, rightCols: Int): Int {
        if (row > allCols) {
            return 1
        }

        var count = 0
        var bits = midCols.or(leftCols).or(rightCols).inv().and(allCols)

        while (bits > 0) {
            val col = bits.and(-bits) // 取出最左边的1
            count += totalNQueens(
                allCols,
                row.shl(1),
                midCols.or(col),
                leftCols.or(col).shl(1),
                rightCols.or(col).ushr(1)
            )

            bits = bits.and(col.inv())
        }
        return count
    }
}