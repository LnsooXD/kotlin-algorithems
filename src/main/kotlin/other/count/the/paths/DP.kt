package other.count.the.paths

class DP : CountThePaths {

    override fun count(board: Array<BooleanArray>): Int {
        val m = board.size
        if (m <= 0) {
            return 0
        }
        val n = board[0].size
        if (n <= 0) {
            return 0
        }

        val counts =
            Array(m) { x -> IntArray(n) { y -> if (board[m - 1 - x][n - 1 - y]) 1 else 0 } }
        for (x in 1 until m) {
            for (y in 1 until n) {
                if (!board[m - 1 - x][n - 1 - y]) {
                    continue
                }
                counts[x][y] = counts[x][y - 1] + counts[x - 1][y]
            }
        }
        return counts[m - 1][n - 1]
    }

}