package leetcode.powx.n

class RecursiveBinDiv1 : PowXN {

    override fun myPow(x: Double, n: Int): Double {
        if (n == 0) {
            return 1.0
        }

        val tmp = myPow(x, n / 2).let { it * it }

        return if (n.and(1) == 0) {
            tmp
        } else if (n > 0) {
            x * tmp
        } else { // 负 N 最后一定会到 -1， 然后会让 x 进入到分母
            tmp / x
        }
    }
}