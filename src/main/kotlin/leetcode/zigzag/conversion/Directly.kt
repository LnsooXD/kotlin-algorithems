package leetcode.zigzag.conversion

import leetcode.annotation.SolvingDate

@SolvingDate(2022, 10, 30)
class Directly : ZigzagConversion {
    override fun convert(s: String, numRows: Int): String {
        if (numRows <= 1) {
            return s
        }
        val rows = Array(numRows) { CharArray(s.length) }
        val cols = IntArray(numRows) { 0 }

        var row = 0
        var direction = -1 // 第一个节点也可以认为是一个转折点，从之前的 direction == -1 时转折过来

        for (i in s.indices) {
            rows[row][cols[row]++] = s[i]
            if (row == numRows - 1 || row == 0) {
                direction = -direction
            }
            row += direction
        }

        val res = CharArray(s.length)
        var index = 0
        for (i in rows.indices) {
            for (j in 0 until cols[i]) {
                res[index++] = rows[i][j]
            }
        }
        return String(res)
    }
}