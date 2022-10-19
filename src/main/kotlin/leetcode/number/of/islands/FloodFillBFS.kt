package leetcode.number.of.islands

import java.util.*

class FloodFillBFS : NumberOfIslands {

    override fun numIslands(grid: Array<CharArray>): Int {
        val m = grid.size
        val n = if (m > 0) grid[0].size else 0
        var count = 0
        for (i in 0 until m) {
            for (j in 0 until n) {
                if (grid[i][j] == '1') {
                    this.foodFill(grid, i, j, m, n)
                    count += 1
                }
            }
        }
        return count
    }

    private fun foodFill(grid: Array<CharArray>, i: Int, j: Int, m: Int, n: Int) {
        val queue: Queue<Node> = LinkedList()
        queue.offer(Node(i, j))
        grid[i][j] = '0'

        while (queue.isNotEmpty()) {
            for (ignored in queue.indices) {
                val node = queue.poll()
                for ((di, dj) in DIRECTIONS) {
                    val ni = node.i + di
                    val nj = node.j + dj
                    if (ni < m && nj < n && ni >= 0 && nj >= 0 && grid[ni][nj] == '1') {
                        grid[ni][nj] = '0'
                        queue.offer(Node(i = ni, j = nj))
                    }
                }
            }
        }
    }

    private data class Node(val i: Int, val j: Int)

    companion object {
        val DIRECTIONS = arrayOf(
            intArrayOf(0, 1),
            intArrayOf(0, -1),
            intArrayOf(1, 0),
            intArrayOf(-1, 0)
        )
    }
}