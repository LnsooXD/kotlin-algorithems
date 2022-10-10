package leetcode.n.queens.ii

class DFSWithBites : NQueensII {

    override fun totalNQueens(n: Int) = traceQueens(n, 0, IntArray(3) { 0 })

    private fun traceQueens(n: Int, row: Int, filterBites: IntArray): Int {
        if (row >= n) {
            return 1
        }

        var count = 0

        for (col in 0 until n) {
            val bcol = 1.shl(col)
            if (filterBites[0].and(bcol) != 0) {
                continue
            }
            val bsum = 1.shl(col + row)
            if (filterBites[1].and(bsum) != 0) {
                continue
            }
            val bdiff = 1.shl(n + col - row)
            if (filterBites[2].and(bdiff) != 0) {
                continue
            }

            filterBites[0] = filterBites[0].or(bcol)
            filterBites[1] = filterBites[1].or(bsum)
            filterBites[2] = filterBites[2].or(bdiff)

            count += traceQueens(n, row + 1, filterBites)

            filterBites[0] = filterBites[0].xor(bcol)
            filterBites[1] = filterBites[1].xor(bsum)
            filterBites[2] = filterBites[2].xor(bdiff)
        }
        return count
    }

}