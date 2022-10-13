package leetcode.triangle

class DPFromTop2Bottom : Triangle {
    // DP[row, col] = min(DP[row - 1, col], DP[row - 1, col - 1]) + triangle[row][col]
    // res = min(DP[last row])
    override fun minimumTotal(triangle: List<List<Int>>): Int {
        val totals = IntArray(triangle.size + 2) { Int.MAX_VALUE }
        totals[1] = triangle[0][0]

        for (row in 1 until triangle.size) {
            for (col in triangle[row].indices.reversed()) {
                totals[col + 1] =
                    triangle[row][col] + if (totals[col + 1] < totals[col]) totals[col + 1] else totals[col]
            }
        }

        var min = totals[1]
        for (i in 2 until totals.size - 1) {
            if (min > totals[i]) {
                min = totals[i]
            }
        }
        return min
    }


}