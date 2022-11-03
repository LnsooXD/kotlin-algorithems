package leetcode.roman.to.integer

import leetcode.annotation.SolvingDate

@SolvingDate(2022, 11, 3)
class TableAndLoopWithCache : RomanToInteger {

    override fun romanToInt(s: String): Int {
        var res = 0
        var index = 0
        var sStartIndex = 0

        var cache = Array(2) { "" }

        while (sStartIndex < s.length) {
            val roman = ROMANS[index]
            var substr = cache[roman.length.and(1)]
            val sEndIndex = sStartIndex + roman.length

            if (substr.isEmpty()) {
                if (sEndIndex <= s.length) {
                    substr = s.substring(sStartIndex, sEndIndex)
                    cache[roman.length.and(1)] = substr
                }
            }

            if (substr != roman) {
                index++
            } else {
                res += INTEGERS[index]
                sStartIndex = sEndIndex
                cache = Array(2) { "" }
            }
        }
        return res
    }

    companion object {
        val INTEGERS = intArrayOf(1000, 900, 500, 400, 100, 90, 50, 40, 10, 9, 5, 4, 1)
        val ROMANS = arrayOf("M", "CM", "D", "CD", "C", "XC", "L", "XL", "X", "IX", "V", "IV", "I")
    }

}