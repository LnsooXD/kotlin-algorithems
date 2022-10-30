package leetcode.zigzag.conversion

import leetcode.annotation.SolvingDate

@SolvingDate(2022, 10, 30)
class DirectlyString : ZigzagConversion {
    override fun convert(s: String, numRows: Int): String {
        if (numRows <= 1) {
            return s
        }
        val rows = Array(numRows) { StringBuffer() }
        var row = 0
        var direction = -1 // 第一个节点也可以认为是一个转折点，从之前的 direction == -1 时转折过来
        for (i in s.indices) {
            rows[row].append(s[i])
            if (row == numRows - 1 || row == 0) {
                direction = -direction
            }
            row += direction
        }
        return rows.reduce { acc, stringBuffer -> acc.append(stringBuffer) }.toString()
    }
}