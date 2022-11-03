package leetcode.roman.to.integer

import leetcode.annotation.SolvingDate

@SolvingDate(2022, 11, 3)
class SimpleSwitch : RomanToInteger {
    override fun romanToInt(s: String): Int {
        var prev = 0
        var res = 0
        for (i in s.length - 1 downTo 0) {
            val num = when (s[i]) {
                'I' -> 1
                'V' -> 5
                'X' -> 10
                'L' -> 50
                'C' -> 100
                'D' -> 500
                'M' -> 1000
                else -> 0
            }
            if (num < prev) {
                res -= num
            } else {
                res += num
            }
            prev = num
        }
        return res
    }
}