package leetcode.counting.bits

class ClearBitOnes : CountingBitsI {

    override fun countBits(n: Int): IntArray {
        val res = IntArray(n + 1)
        for (i in 0..n) {
            res[i] = this.countBitsOfNum(i)
        }
        return res
    }

    private fun countBitsOfNum(num: Int): Int {
        var count = 0
        var tmp = num
        while (tmp > 0) {
            tmp = tmp.and(tmp - 1)
            count++
        }
        return count
    }
}