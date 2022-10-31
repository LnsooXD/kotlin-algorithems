package leetcode.reverse.integer

import leetcode.annotation.SolvingDate

@SolvingDate(2022, 10, 31)
class ArrayQueue : ReverseInteger {
    override fun reverse(x: Int) = this.reverseLong(x.toLong())

    private fun reverseLong(x: Long): Int {
        if (x < 0) {
            return -reverseLong(-x)
        }

        val queue = LongArray(11)
        var size = 0
        var value = x
        while (value != 0L) {
            queue[size++] = value % 10
            value /= 10
        }

        for (i in 0 until size) {
            value *= 10
            value += queue[i]
        }

        return value.toInt().let { if (it.toLong() == value) it else 0 }
    }
}