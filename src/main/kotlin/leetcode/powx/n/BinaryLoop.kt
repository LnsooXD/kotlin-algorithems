package leetcode.powx.n

class BinaryLoop : PowXN {

    override fun myPow(x: Double, n: Int): Double {
        var res = 1.0
        var bits = if (n < 0) -n else n
        var tmp = if (n < 0) 1.0 / x else x
        // -Int.MIN_VALUE == Int.MIN_VALUE 可以认为 Int.MIN_VALUE 就是 Int.MAX_VALUE + 1, 只是把符号位置也用上了。
        // 这样的话，逻辑就变成把所有的 1 清零
        while (bits != 0) {
            if (bits.and(1) == 1) {
                res *= tmp
            }
            tmp *= tmp
            bits = bits ushr 1
        }
        return res
    }
}