package leetcode.triangle


// 2022-10-26 Wed
class DFS02 : Triangle {
    override fun minimumTotal(triangle: List<List<Int>>) = this.minimumTotal(triangle, 0, 0)

    private fun minimumTotal(triangle: List<List<Int>>, row: Int, col: Int): Int =
        if (row >= triangle.size)
            0
        else
            triangle[row][col] + min(
                this.minimumTotal(triangle, row + 1, col),
                this.minimumTotal(triangle, row + 1, col + 1)
            )

    companion object {
        fun min(x: Int, y: Int) = if (x < y) x else y
    }

}