package leetcode.triangle

class DFS01 : Triangle {

    override fun minimumTotal(triangle: List<List<Int>>): Int {
        if (triangle.isEmpty()) {
            return 0
        }
        return this.minimumTotal(triangle, 0, 0, 0)
    }

    private fun minimumTotal(triangle: List<List<Int>>, row: Int, col: Int, total: Int): Int {
        val currentTotal = total + triangle[row][col]
        val nextRow = row + 1
        if (nextRow >= triangle.size) {
            return currentTotal
        }

        val total0 = minimumTotal(triangle, nextRow, col, currentTotal)
        val total1 = minimumTotal(triangle, nextRow, col + 1, currentTotal)

        return if (total0 < total1) total0 else total1
    }
}