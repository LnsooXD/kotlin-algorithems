package other.fibonacci

class DPSmall : FibonacciI {

    override fun calculate(n: Int): Int {
        val fibs = IntArray(4) { 0 }
        fibs[1] = 1

        for (i in 2..n) {
            fibs[i.and(3)] = fibs[(i).and(3) - 1] + fibs[(i).and(3) - 2]
        }
        return fibs[n % 3]
    }

}