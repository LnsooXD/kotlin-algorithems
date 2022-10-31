package leetcode.reverse.integer

import leetcode.annotation.SolvingDate

@SolvingDate(2022, 10, 31)
class Directly : ReverseInteger {
    override fun reverse(x: Int) = this.reverseLong(x.toLong())

    private fun reverseLong(x: Long): Int {
        if (x < 0) {
            return -reverseLong(-x)
        }
        var value = x
        var resValue = 0L
        // 因为 这个队列进入一个就出来一个， 所以可以把队列省掉，直接让输入输出对接
        while (value != 0L) {
            resValue *= 10
            resValue += value % 10
            value /= 10
        }
        return resValue.toInt().let { if (it.toLong() == resValue) it else 0 }
    }
}