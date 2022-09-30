package leetcode.sqrtx

class BinaryDouble : Sqrtx<Double> {

    override fun mySqrt(x: Int): Double {
        if (x == 1) {
            return 1.0
        }
        var left = 0.0
        var right: Double = x.toDouble()

        while (left <= right) {
            val mid = (left + right) / 2.0
            val square = mid * mid
            if (this.abs(square - x) < 1.0E-10) {
                return mid
            } else if (square < x) {
                left = mid
            } else {
                right = mid
            }
        }
        return left
    }

    private fun abs(a: Double) = if (a >= 0.0) a else -a
}