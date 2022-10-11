package other.fibonacci

class CachedLoop : FibonacciI {
    override fun calculate(n: Int) = this.calculate(n, IntArray(n + 1) { 0 })

    private fun calculate(n: Int, cache: IntArray): Int {
        if (n <= 1) {
            return n
        } else if (cache[n] == 0) {
            cache[n] = this.calculate(n - 1, cache) + this.calculate(n - 2, cache)
        }
        return cache[n]
    }
}