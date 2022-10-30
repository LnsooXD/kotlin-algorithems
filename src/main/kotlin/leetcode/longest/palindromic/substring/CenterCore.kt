package leetcode.longest.palindromic.substring

import leetcode.annotation.SolvingDate

@SolvingDate(2022, 10, 30)
class CenterCore : LongestPalindromicSubstring {
    override fun longestPalindrome(s: String): String {
        var longestPalindrome = ""

        for (i in s.indices) {
            val s1 = longestPalindrome(s, i, i)
            if (longestPalindrome.length < s1.length) {
                longestPalindrome = s1
            }
            if (i + 1 < s.length && s[i] == s[i + 1]) {
                val s2 = longestPalindrome(s, i, i + 1)
                if (longestPalindrome.length < s2.length) {
                    longestPalindrome = s2
                }
            }
        }
        return longestPalindrome
    }

    private fun longestPalindrome(s: String, coreIndex1: Int, coreIndex2: Int): String {
        val maxGap = min(coreIndex1 - 0, s.length - 1 - coreIndex2)
        for (j in 0..maxGap) {
            if (s[coreIndex1 - j] != s[coreIndex2 + j]) {
                return s.substring(coreIndex1 - j + 1, coreIndex2 + j)
            }
        }
        return s.substring(coreIndex1 - maxGap, coreIndex2 + maxGap + 1)
    }


    companion object {
        fun min(vararg args: Int) = args.reduce { acc, i -> if (acc < i) acc else i }
    }
}