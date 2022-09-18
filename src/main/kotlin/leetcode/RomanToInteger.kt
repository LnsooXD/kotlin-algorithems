package leetcode

import java.lang.IllegalArgumentException
import java.util.IllegalFormatException
import javax.swing.UIManager.put

// https://leetcode.cn/problems/roman-to-integer/

// I             1
// V             5
// X             10
// L             50
// C             100
// D             500
// M             1000


fun main(args: Array<String>) {
    println(RomanToInteger().romanToInt("LVIII"))
}


class RomanToInteger {

    private val table = mutableMapOf<String, Int>()


    init {
        this.table["M"] = 1000
        this.table["CM"] = 900
        this.table["D"] = 500
        this.table["CD"] = 400
        this.table["C"] = 100
        this.table["XC"] = 90
        this.table["L"] = 50
        this.table["XL"] = 40
        this.table["X"] = 10
        this.table["IX"] = 9
        this.table["V"] = 5
        this.table["IV"] = 4
        this.table["I"] = 1
    }

    fun romanToInt(s: String): Int {
        val length = s.length
        if (length <= 0) {
            return 0
        }
        var index = 0
        var res = 0

        while(index < length) {
            if (index + 1 < length) {
                val el = s.substring(index, index + 2)
                val ev = table[el]
                if (ev != null) {
                    res += ev
                    index += 2
                    continue
                }
            }

            val el =  s.substring(index, index + 1)
            val ev = table[el] ?: throw IllegalArgumentException("Unsupported element: ${el}")
            res += ev
            index += 1
        }
        return res
    }

}