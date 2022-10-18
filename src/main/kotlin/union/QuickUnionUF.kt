package union

class QuickUnionUF {
    private val roots: IntArray

    constructor(N: Int) {
        this.roots = IntArray(N) { it }
    }

    fun findRoot(i: Int): Int {
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

    fun isConnected(p: Int, q: Int) = this.findRoot(p) == this.findRoot(q)

    fun union(p: Int, q: Int) {
        this.roots[this.findRoot(p)] = this.findRoot(q)
    }

}