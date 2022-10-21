package leetcode.powx.n

class PowXN01 : PowXN {
    override fun myPow(x: Double, n: Int) = pow(x, n.toLong())

    private fun pow(x: Double, n: Long): Double {
        if (n < 0) {
            return 1.0 / pow(x, -n)
        }
        return when (n) {
            0L -> 1.0
            1L -> x
            2L -> x * x
            else -> pow(pow(x, n.ushr(1)), 2) * pow(x, n.and(1))
        }
    }
}