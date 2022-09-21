package leetcode.powx.n

class RecursiveBinDiv : PowXN {

    override fun myPow(x: Double, n: Int): Double =
        if (n == 0) {
            1.0
        } else if (n == 1) {
            x
        } else if (n < 0) {
            val newN = -n
            if (newN == n) {
                if (x == 1.0 || x == -1.0) {
                    1.0
                } else {
                    0.0
                }
            } else {
                1.0 / myPow(x, newN)
            }
        } else if (n.and(1) == 1) {
            x * myPow(x, n - 1)
        } else {
            myPow(x, n / 2).let { it * it }
        }
}