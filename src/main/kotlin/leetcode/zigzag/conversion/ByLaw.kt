package leetcode.zigzag.conversion

import leetcode.annotation.SolvingDate

@SolvingDate(2022, 10, 30)
class ByLaw : ZigzagConversion {
    override fun convert(s: String, numRows: Int): String {
        if (numRows <= 1) {
            return s
        }

        val res = CharArray(s.length)

        var index = 0
        val steps = IntArray(2)

        for (row in 0 until numRows) {
            steps[0] = (numRows - 1 - row).shl(1)
            steps[1] = row.shl(1)

            for (i in 0..1) if (steps[i] == 0) {
                steps[i] = steps[1 - i]
                break
            }

            var stepIndex = 0
            var srcIndex = row

            while (srcIndex < s.length) {
                res[index++] = s[srcIndex]
                srcIndex += steps[stepIndex]
                stepIndex = 1 - stepIndex
            }
        }

        return String(res)
    }
}