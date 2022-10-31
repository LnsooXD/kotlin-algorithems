package leetcode.string.to.integer.atoi

import leetcode.annotation.SolvingDate

@SolvingDate(2022, 10, 31)
class Directly : StringToIntegerAtoi {
    override fun myAtoi(s: String): Int {
        if (s.isEmpty()) {
            return 0
        }
        var index = 0
        while (index < s.length && s[index] == ' ') {
            index++
        }

        if (index >= s.length) {
            return 0
        }
        val isNegative = s[index] == '-'
        if (isNegative || s[index] == '+') {
            index++
        }

        var value = 0L
        while (index < s.length && value < Int.MAX_VALUE && s[index] in '0'..'9') {
            val digit = s[index] - '0'
            value *= 10
            value += digit
            index++
        }

        if (isNegative) {
            value = -value
            if (value < Int.MIN_VALUE) {
                return Int.MIN_VALUE
            }
        } else if (value > Int.MAX_VALUE) {
            return Int.MAX_VALUE
        }
        return value.toInt()
    }
}