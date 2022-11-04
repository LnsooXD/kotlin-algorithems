package leetcode.longest.common.prefix

import leetcode.annotation.SolvingDate

@SolvingDate(2022, 11, 4)
class FirstStrAsTrie : LongestCommonPrefix {
    override fun longestCommonPrefix(strs: Array<String>): String {
        if (strs.isEmpty()) {
            return ""
        }

        val trie = strs[0]
        if (strs.size == 1) {
            return trie
        }

        var index = 0
        while (index < trie.length) {
            val c = trie[index]
            var flag = true
            for (str in strs) {
                if (str.length <= index || str[index] != c) {
                    flag = false
                    break
                }
            }
            if (!flag) {
                break
            }
            index++
        }
        return trie.substring(0, index)
    }
}

