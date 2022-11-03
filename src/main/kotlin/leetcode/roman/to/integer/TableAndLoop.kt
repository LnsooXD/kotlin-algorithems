package leetcode.roman.to.integer

import leetcode.annotation.SolvingDate

@SolvingDate(2022, 11, 3)
class TableAndLoop : RomanToInteger {

    override fun romanToInt(s: String): Int {
        var res = 0
        var index = 0
        var sStartIndex = 0

        while (sStartIndex < s.length) {
            val roman = ROMANS[index]
            val sEndIndex = sStartIndex + roman.length
            if (sEndIndex > s.length || s.substring(sStartIndex, sEndIndex) != roman) {
                index++
            } else {
                res += INTEGERS[index]
                sStartIndex = sEndIndex
            }
        }
        return res
    }

    companion object {
        val INTEGERS = intArrayOf(1000, 900, 500, 400, 100, 90, 50, 40, 10, 9, 5, 4, 1)
        val ROMANS = arrayOf("M", "CM", "D", "CD", "C", "XC", "L", "XL", "X", "IX", "V", "IV", "I")
    }

}