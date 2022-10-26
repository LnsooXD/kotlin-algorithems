package leetcode.triangle

// 2022-10-26 Wed
class DP02 : Triangle {

    override fun minimumTotal(triangle: List<List<Int>>): Int {
        val results = IntArray(triangle.size + 1) { 0 }
        for (row in triangle.size - 1 downTo 0) {
            for (col in 0..row) {
                results[col] = triangle[row][col] + min(results[col], results[col + 1])
            }
        }
        return results[0]
    }

    companion object {
        fun min(x: Int, y: Int) = if (x < y) x else y
    }

}