package leetcode.n.queens

class DFS : NQueens {

    override fun solveNQueens(n: Int): List<List<String>> {
        val queens = IntArray(n) { -1 }
        val columns = hashSetOf<Int>()
        val xyDiffs = hashSetOf<Int>()
        val xySums = hashSetOf<Int>()
        val results = ArrayList<List<String>>()
        traceQueues(n, 0, queens, columns, xyDiffs, xySums, results)
        return results
    }

    private fun traceQueues(
        n: Int,
        row: Int,
        queens: IntArray,
        columns: HashSet<Int>,
        xyDiffs: HashSet<Int>,
        xySums: HashSet<Int>,
        results: MutableList<List<String>>
    ) {
        if (row == n) {
            results.add(buildResult(queens))
            return
        }

        for (col in 0 until n) {
            if (col in columns) {
                continue
            }
            if (col - row in xyDiffs) {
                continue
            }
            if (col + row in xySums) {
                continue
            }

            xyDiffs.add(col - row)
            xySums.add(col + row)
            columns.add(col)

            queens[row] = col

            traceQueues(n, row + 1, queens, columns, xyDiffs, xySums, results)

            xyDiffs.remove(col - row)
            xySums.remove(col + row)
            columns.remove(col)
        }

    }

    private fun buildResult(queens: IntArray): List<String> {
        val n = queens.size

        val result = ArrayList<String>()
        for (i in 0 until n) {
            val rowData = CharArray(n) { '.' }
            rowData[queens[i]] = 'Q'
            result.add(String(rowData))
        }
        return result
    }


}