package leetcode.number.of.one.bits

// https://leetcode.com/problems/number-of-1-bits/

class HammingWeight {

    fun hammingWeight(n: Int): Int {
        var tmp = n
        var count = 0
        while (tmp != 0) {
            if (tmp.and(1) != 0) {
                count ++
            }
            tmp = tmp.ushr(1)
        }
        return count
    }

    fun hammingWeightOld(n: Int): Int {
        var tmp = if (n >= 0) n else n.xor(1.shl(31))
        var count = if (n >= 0) 0 else 1
        while (tmp > 0) {
            tmp = tmp.and(tmp - 1)
            count++
        }
        return count
    }
}