package leetcode.n.queens.ii

class DFS : NQueensII {

    override fun totalNQueens(n: Int): Int {
        val columns = hashSetOf<Int>()
        val xyDiffs = hashSetOf<Int>()
        val xySums = hashSetOf<Int>()
        return traceQueens(n, 0, columns, xyDiffs, xySums)
    }

    private fun traceQueens(
        n: Int, row: Int,
        columns: HashSet<Int>,
        xyDiffs: HashSet<Int>,
        xySums: HashSet<Int>
    ): Int {
        if (row >= n) {
            return 1
        }

        var count = 0

        for (col in 0 until n) {
            if (col in columns) {
                continue
            }
            if (col + row in xySums) {
                continue
            }
            if (col - row in xyDiffs) {
                continue
            }

            columns.add(col)
            xyDiffs.add(col - row)
            xySums.add(col + row)

            count += traceQueens(n, row + 1, columns, xyDiffs, xySums)

            columns.remove(col)
            xyDiffs.remove(col - row)
            xySums.remove(col + row)
        }

        return count;
    }
}