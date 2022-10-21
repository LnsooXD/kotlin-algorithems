package leetcode.powx.n

class RecursiveBinDiv2 : PowXN {
    override fun myPow(x: Double, n: Int) = pow(x, n.toLong())

    private fun pow(x: Double, n: Long): Double {
        return when {
            n < 0 -> 1.0 / pow(x, -n)
            n == 0L -> 1.0
            n == 1L -> x
            n == 2L -> x * x
            else -> pow(pow(x, n.ushr(1)), 2) * pow(x, n.and(1))
        }
    }
}