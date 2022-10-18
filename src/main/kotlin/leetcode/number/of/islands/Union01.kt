package leetcode.number.of.islands

class Union01 : NumberOfIslands {

    override fun numIslands(grid: Array<CharArray>): Int {
        if (grid.isEmpty()) {
            return 0
        }

        val m = grid.size
        val n = grid[0].size

        val union = Union(m * n)
        var offset = 0
        var total = 0

        for (i in 0 until m) {
            for (j in 0 until n) {
                val node = offset + j
                if (grid[i][j] == '1') {
                    total++
                    if (j - 1 >= 0 && grid[i][j - 1] == '1' && union.union(node, node - 1)) {
                        total--
                    }
                    if (i - 1 >= 0 && grid[i - 1][j] == '1' && union.union(node, node - n)) {
                        total--
                    }
                }
            }
            offset += n
        }
        return total
    }

    class Union(N: Int) {
        private val roots: IntArray

        init {
            this.roots = IntArray(N) { it }
        }

        private fun findRoot(i: Int): Int {
            var root = this.roots[i]
            while (root != this.roots[root]) {
                root = this.roots[root]
            }

            var node = i
            while (node != this.roots[node]) {
                this.roots[node] = root
                node = roots[node]
            }
            return root
        }

        fun union(p: Int, q: Int): Boolean {
            val rootP = this.findRoot(p)
            val rootQ = this.findRoot(q)

            this.roots[rootP] = rootQ
            return rootP != rootQ
        }
    }

}