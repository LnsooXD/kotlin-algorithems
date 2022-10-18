package leetcode.number.of.islands

class FloodFill01 : NumberOfIslands {
    override fun numIslands(grid: Array<CharArray>): Int {
        val m = grid.size
        val n = if (m > 0) grid[0].size else 0
        var count = 0
        for (i in 0 until m) {
            for (j in 0 until n) {
                count += this.foodFill(grid, i, j, m, n)
            }
        }
        return count
    }

    private fun foodFill(grid: Array<CharArray>, i: Int, j: Int, m: Int, n: Int): Int {
        if (i >= m || j >= n || i < 0 || j < 0 || grid[i][j] == '0') {
            return 0
        }

        grid[i][j] = '0'

        this.foodFill(grid, i + 1, j, m, n)
        this.foodFill(grid, i, j + 1, m, n)
        this.foodFill(grid, i - 1, j, m, n)
        this.foodFill(grid, i, j - 1, m, n)

        return 1
    }
}