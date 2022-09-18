package leetcode

// https://leetcode.cn/problems/find-the-index-of-the-first-occurrence-in-a-string/
// KMP: https://www.zhihu.com/question/21923021/answer/281346746

class FindTheIndexOfTheFirstOccurrenceInAString {

    fun strStr(haystack: String, needle: String): Int {
        if (haystack.length < needle.length || needle.isEmpty()) {
            return -1
        }

        for (i in 0..haystack.length - needle.length) {
            if (this.isMatch(haystack, i, needle)) {
                return i
            }
        }
        return -1
    }

    private fun isMatch(haystack: String, index: Int, needle: String): Boolean {
        for ((j, i) in (index until index + needle.length).withIndex()) {
            if (haystack[i] != needle[j]) {
                return false
            }
        }
        return true
    }

}