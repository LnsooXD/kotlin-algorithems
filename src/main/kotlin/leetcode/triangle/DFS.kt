package leetcode.triangle

class DFS : Triangle {

    override fun minimumTotal(triangle: List<List<Int>>): Int {
        if (triangle.isEmpty()) {
            return 0
        }
        val totals = mutableListOf<Int>()
        this.minimumTotal(triangle, 0, 0, 0, totals)

        var min = totals[0]
        for (i in 1 until totals.size) {
            if (min > totals[i]) {
                min = totals[i]
            }
        }
        return min
    }

    private fun minimumTotal(triangle: List<List<Int>>, row: Int, col: Int, total: Int, totals: MutableList<Int>) {
        val currentTotal = total + triangle[row][col]
        val nextRow = row + 1
        if (nextRow >= triangle.size) {
            totals.add(currentTotal)
            return
        }

        minimumTotal(triangle, nextRow, col, currentTotal, totals)
        minimumTotal(triangle, nextRow, col + 1, currentTotal, totals)
    }
}