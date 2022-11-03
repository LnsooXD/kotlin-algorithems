package leetcode.integer.to.roman

import leetcode.annotation.SolvingDate

@SolvingDate(2022, 11, 3)
class Table : IntegerToRoman {

    override fun intToRoman(num: Int): String {
        var numIndex = NUMS.size - 1
        var value = num
        var res = ""

        while (value > 0) {
            val digit = NUMS[numIndex]
            val sign = SIGNS[numIndex]
            while (value >= digit) {
                value -= digit
                res += sign
            }
            numIndex--
        }
        return res
    }

    companion object {
        val NUMS = intArrayOf(1, 4, 5, 9, 10, 40, 50, 90, 100, 400, 500, 900, 1000)
        val SIGNS = arrayOf("I", "IV", "V", "IX", "X", "XL", "L", "XC", "C", "CD", "D", "CM", "M")
    }
}