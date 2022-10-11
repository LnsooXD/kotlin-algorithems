package other.fibonacci

class DPSmall : FibonacciI {

    override fun calculate(n: Int): Int {
        val fibs = IntArray(3) { 0 }
        fibs[1] = 1

        for (i in 2..n) {
            fibs[i % 3] = fibs[(i - 1) % 3] + fibs[(i - 2) % 3]
        }

        return fibs[n % 3]
    }

}