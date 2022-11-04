package leetcode.longest.common.prefix

import leetcode.annotation.SolvingDate

@SolvingDate(2022, 11, 4)
class Rude : LongestCommonPrefix {
    override fun longestCommonPrefix(strs: Array<String>): String {
        if (strs.isEmpty()) {
            return ""
        } else if (strs.size == 1) {
            return strs[0]
        }
        val length = strs.map { it.length }.reduce { acc, i -> if (acc < i) acc else i }
        var prefix = ""
        for (i in 0 until length) {
            val res = strs.map { it[i].toShort() }.reduce { acc, c -> if (acc != c) -1 else acc }
            if (res <= 0) {
                break
            } else {
                prefix += res.toChar()
            }
        }
        return prefix
    }
}