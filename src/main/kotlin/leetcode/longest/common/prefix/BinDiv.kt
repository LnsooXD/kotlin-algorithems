package leetcode.longest.common.prefix

import leetcode.annotation.SolvingDate

@SolvingDate(2022, 11, 4)
class BinDiv : LongestCommonPrefix {
    override fun longestCommonPrefix(strs: Array<String>) = longestCommonPrefix(strs, 0, strs.size)

    private fun longestCommonPrefix(strs: Array<String>, begin: Int, end: Int): String {
        val len = end - begin
        if (len == 0) {
            return ""
        } else if (len == 1) {
            return strs[begin]
        }

        val mid = (begin + end).ushr(1)
        val l1 = longestCommonPrefix(strs, begin, mid)
        val l2 = longestCommonPrefix(strs, mid, end)

        val minLen = if (l1.length < l2.length) l1.length else l2.length
        var index = 0
        while (index < minLen && l1[index] == l2[index]) {
            index++
        }
        return l1.substring(0, index)
    }

}