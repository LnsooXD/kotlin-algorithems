package leetcode

// https://leetcode.cn/problems/integer-to-roman/

// I             1
// V             5
// X             10
// L             50
// C             100
// D             500
// M             1000


fun main(args: Array<String>) {
    println(IntegerToRoman().intToRoman(1994))
}

class IntegerToRoman {
    fun intToRoman(num: Int): String =
        if (num >= 1000) {
            "M" + intToRoman(num - 1000)
        } else if (num >= 900) {
            "CM" + intToRoman(num - 900)
        } else if (num >= 500) {
            "D" + intToRoman(num - 500)
        } else if (num >= 400) {
            "CD" + intToRoman(num - 400)
        } else if (num >= 100) {
            "C" + intToRoman(num - 100)
        } else if (num >= 90) {
            "XC" + intToRoman(num - 90)
        } else if (num >= 50) {
            "L" + intToRoman(num - 50)
        } else if (num >= 40) {
            "XL" + intToRoman(num - 40)
        } else if (num >= 10) {
            "X" + intToRoman(num - 10)
        } else if (num == 9) {
            "IX"
        } else if (num >= 5) {
            "V" + intToRoman(num - 5)
        } else if (num == 4) {
            "IV"
        } else {
            var res = ""
            for (i in 0 until num) {
                res += "I"
            }
            res
        }
}