package leetcode.triangle

class DPBottom2Top : Triangle {

    // DP[row, col] = min(DP[row + 1, col], DP[row + 1, col + 1]) + triangle[row][col]
    // res = DP[0, 0]
    override fun minimumTotal(triangle: List<List<Int>>): Int {
        if (triangle.isEmpty()) {
            return 0
        }
        val totals = triangle[triangle.size - 1].toIntArray()
        for (row in (0..triangle.size - 2).reversed()) {
            for (col in 0..row) {
                totals[col] = triangle[row][col] + if (totals[col] < totals[col + 1]) totals[col] else totals[col + 1]
            }
        }
        return totals[0]
    }

}