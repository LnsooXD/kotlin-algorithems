package leetcode.reverse.integer

import leetcode.annotation.SolvingDate

@SolvingDate(2022, 10, 31)
class GeneralQueue : ReverseInteger {
    override fun reverse(x: Int) = this.reverseLong(x.toLong())
    private fun reverseLong(x: Long): Int {
        if (x < 0) {
            return -this.reverseLong(-x)
        }
        val queue = ArrayDeque<Long>()
        var value = x.toLong()
        while (value != 0L) {
            queue.addFirst(value % 10)
            value /= 10
        }
        while (!queue.isEmpty()) {
            value *= 10
            value += queue.removeLast()
        }
        return value.toInt().let { if (it.toLong() == value) it else 0 }
    }

}