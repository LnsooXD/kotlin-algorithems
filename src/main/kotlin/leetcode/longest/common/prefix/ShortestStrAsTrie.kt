package leetcode.longest.common.prefix

import leetcode.annotation.SolvingDate

@SolvingDate(2022, 11, 4)
class ShortestStrAsTrie : LongestCommonPrefix {
    override fun longestCommonPrefix(strs: Array<String>): String {
        if (strs.isEmpty()) {
            return ""
        }
        val shortest = strs.reduce { acc, s -> if (acc.length < s.length) acc else s }
        var index = 0
        while (index < shortest.length) {
            val c = shortest[index]
            var flag = true
            for (str in strs) {
                if (str[index] != c) {
                    flag = false
                    break
                }
            }
            if (!flag) {
                break
            }
            index++
        }

        return shortest.substring(0, index)
    }
}

