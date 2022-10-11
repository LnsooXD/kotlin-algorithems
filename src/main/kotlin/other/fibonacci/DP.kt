package other.fibonacci

class DP : FibonacciI {

    override fun calculate(n: Int): Int {
        val fibs = IntArray(n + 1) { 0 }
        fibs[1] = 1

        for (i in 2..n) {
            fibs[i] = fibs[i - 1] + fibs[i - 2]
        }
        return fibs[n]
    }

}