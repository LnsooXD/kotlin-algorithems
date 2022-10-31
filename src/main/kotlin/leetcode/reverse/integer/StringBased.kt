package leetcode.reverse.integer

import leetcode.annotation.SolvingDate

@SolvingDate(2022, 10, 31)
class StringBased : ReverseInteger {
    override fun reverse(x: Int) = this.reverseLong(x.toLong())

    private fun reverseLong(x: Long): Int = if (x < 0) {
        -reverseLong(-x)
    } else {
        val value = x.toString().reversed().toLong()
        value.toInt().let { if (it.toLong() == value) it else 0 }
    }
}