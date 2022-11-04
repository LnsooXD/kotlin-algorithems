package leetcode.longest.common.prefix

import leetcode.annotation.SolvingDate

@SolvingDate(2022, 11, 4)
class SortedStrs : LongestCommonPrefix {
    override fun longestCommonPrefix(strs: Array<String>): String {
        if (strs.isEmpty()) {
            return ""
        } else if (strs.size == 1) {
            return strs[0]
        }
        strs.sort()
        var index = 0
        // 排序后，找出差距最大的两个字符串的公共前缀即可
        val first = strs.first()
        val last = strs.last()
        while (index < first.length && index < last.length && first[index] == last[index]) {
            index++
        }
        return first.substring(0, index)
    }
}