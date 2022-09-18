package leetcode

// https://leetcode.cn/problems/longest-common-prefix/

fun main(args: Array<String>) {
    val strs = arrayOf("flower", "flow", "flight")
    val longestCommonPrefix = LongestCommonPrefix().longestCommonPrefix(strs)
    println("longestCommonPrefix: [${longestCommonPrefix}]")
}

class LongestCommonPrefix {

    fun longestCommonPrefix(strs: Array<String>): String {

        if (strs.isEmpty()) {
            return ""
        } else if (strs.size == 1) {
            return strs[0]
        }

        var longestCommonPrefix = ""
        var end = 1

        while (true) {
            val commonPrefix = this.findCommonPrefix(strs, end) ?: return longestCommonPrefix
            longestCommonPrefix = commonPrefix
            end++
        }
    }

    private fun findCommonPrefix(strs: Array<String>, end: Int): String? {
        var sub: String? = null
        for (i in strs.indices) {
            if (strs[i].length < end) {
                return null
            }

            val newSub = strs[i].substring(0, end)

            if (sub == null) {
                sub = newSub
            } else if (newSub != sub) {
                return null
            }
        }
        return sub
    }

}