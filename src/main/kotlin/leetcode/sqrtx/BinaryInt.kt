package leetcode.sqrtx

class BinaryInt : Sqrtx<Int> {

    override fun mySqrt(x: Int): Int {
        if (x == 1) {
            return x
        }

        val target = x.toLong()
        var left = 0L
        var right = x.toLong()

        while (left <= right) {
            val mid = (left + right) / 2L
            val square = mid * mid
            if (square == target) {
                return mid.toInt()
            } else if (square < target) {
                if (square + 1 >= target) {
                    return mid.toInt()
                }
                left = mid + 1
            } else {
                right = mid - 1
            }
        }

        return left.toInt()
    }
}