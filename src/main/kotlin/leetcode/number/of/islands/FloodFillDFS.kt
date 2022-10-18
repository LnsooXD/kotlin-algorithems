package leetcode.number.of.islands

class FloodFillDFS : NumberOfIslands {
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
        for (di in DI.indices) {
            this.foodFill(grid, i + DI[di], j + DJ[di], m, n)
        }
        return 1
    }

    companion object {
        val DI = intArrayOf(0, 0, 1, -1)
        val DJ = intArrayOf(1, -1, 0, 0)
    }
}