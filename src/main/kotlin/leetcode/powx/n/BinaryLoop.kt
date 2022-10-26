package leetcode.powx.n

class BinaryLoop : PowXN {

    override fun myPow(x: Double, n: Int): Double {
        var res = 1.0
        var bits = if (n < 0) -n else n
        var tmp = if (n < 0) 1.0 / x else x // x^(2^0)
        // var m = 1, tmp = x^(2^m) = x^(2^1)

        // -Int.MIN_VALUE == Int.MIN_VALUE 可以认为 Int.MIN_VALUE 就是 Int.MAX_VALUE + 1, 只是把符号位置也用上了。
        // 这样的话，逻辑就变成把所有的 1 清零

        // 二进制展开
        // since n = 1*2^0 + 0*2^1 + 1*2^2 + ...
        // x^n = x^(1*2^0 + 0*2^1 + 1*2^2 + ...) = x^(1*2^0) * x^(0*2^1) * x^(1*2^2) * ...
        while (bits != 0) {
            if (bits.and(1) == 1) {
                res *= tmp // x^(1*2^0 + 1*2^1 + ... 0*2^(m-1)) * x^(1*2^m) = x^(1*2^0 + 1*2^1 + ... 0*2^(m-1) + 1*2^m)
            }


            tmp *= tmp // tmp = x^(2^(m+1)) = x^(2^(m)) * x^(2^(m))
            // m ++

            bits = bits ushr 1
        }
        return res
    }
}