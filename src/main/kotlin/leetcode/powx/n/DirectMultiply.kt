package leetcode.powx.n

class DirectMultiply : PowXN {

    override fun myPow(x: Double, n: Int): Double {
        var pow = 1.0
        val nn = if (n < 0) -n else n
        for (i in 0 until nn) {
            pow *= x
        }
        if (n < 0) {
            pow = 1.0 / pow
            if (pow == 1.0 && x > 1.0) {
                pow = 0.0
            }
        }
        return pow
    }

}