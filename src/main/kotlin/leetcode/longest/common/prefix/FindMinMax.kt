package leetcode.longest.common.prefix

import leetcode.annotation.SolvingDate

@SolvingDate(2022, 11, 4)
class FindMinMax : LongestCommonPrefix {
    override fun longestCommonPrefix(strs: Array<String>): String {
        if (strs.isEmpty()) {
            return ""
        } else if (strs.size == 1) {
            return strs[0]
        }

        var maxStr = strs[0]
        var minStr = strs[0]

        for (i in 1 until strs.size) {
            val str = strs[i]
            if (str > maxStr) {
                maxStr = str
            } else if (str < minStr) {
                minStr = str
            }
        }

        val length = if (maxStr.length > minStr.length) minStr.length else maxStr.length
        var index = 0
        while (index < length && maxStr[index] == minStr[index]) {
            index++
        }
        return minStr.substring(0, index)
    }
}