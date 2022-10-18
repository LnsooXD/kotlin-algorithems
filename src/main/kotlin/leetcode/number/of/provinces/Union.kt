package leetcode.number.of.provinces

class Union : NumberOfProvinces {

    override fun findCircleNum(isConnected: Array<IntArray>): Int {
        val n = isConnected.size
        val union = Union(n)

        var provinces = n
        for (i in 0 until n) {
            for (j in i + 1 until n) {
                if (isConnected[i][j] == 1 && union.union(i, j)) {
                    provinces--
                }
            }
        }
        return provinces
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