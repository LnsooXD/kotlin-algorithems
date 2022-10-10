package leetcode.n.queens.ii

class DFSWithBites : NQueensII {

    override fun totalNQueens(n: Int) = traceQueens(n, 0, 0L)

    private fun traceQueens(n: Int, row: Int, filterBites: Long): Int {
        if (row >= n) {
            return 1
        }
        var count = 0
        for (col in 0 until n) {
            val bits = 1L.shl(col).shl(19).or(
                1L.shl(col + row)
            ).shl(19).or(
                1L.shl(n + col - row)
            )
            if (bits.and(filterBites) != 0L) {
                continue
            }
            count += traceQueens(n, row + 1, filterBites.or(bits))
        }
        return count
    }

}