package leetcode.integer.to.roman

import leetcode.annotation.SolvingDate

@SolvingDate(2022, 11, 3)
class Table : IntegerToRoman {

    override fun intToRoman(num: Int) = buildString {
        var value = num
        var index = 0
        while (value > 0) {
            val integer = INTEGERS[index]
            val roman = ROMANS[index]
            while (value >= integer) {
                value -= integer
                this.append(roman)
            }
            index++
        }
    }

    companion object {
        val INTEGERS = intArrayOf(1000, 900, 500, 400, 100, 90, 50, 40, 10, 9, 5, 4, 1)
        val ROMANS = arrayOf("M", "CM", "D", "CD", "C", "XC", "L", "XL", "X", "IX", "V", "IV", "I")
    }
}