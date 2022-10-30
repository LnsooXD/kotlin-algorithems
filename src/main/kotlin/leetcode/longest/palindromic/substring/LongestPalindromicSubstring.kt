package leetcode.longest.palindromic.substring

import leetcode.annotation.ProblemSoruce

// 5. https://leetcode.com/problems/longest-palindromic-substring/
/**
 * ## [5. Longest Palindromic Substring](https://leetcode.com/problems/longest-palindromic-substring/)
 *
 * Given a string s, return the longest palindromic substring in s.
 *
 * ### Example 1:
 * ```
 * Input: s = "babad"
 * Output: "bab"
 * Explanation: "aba" is also a valid answer.
 * ```
 *
 * ### Example 2:
 * ```
 * Input: s = "cbbd"
 * Output: "bb"
 * ```
 *
 * ### Constraints:
 *
 * - 1 <= s.length <= 1000
 * - s consist of only digits and English letters.
 **/
@ProblemSoruce(5, "Longest Palindromic Substring", "https://leetcode.com/problems/longest-palindromic-substring/")
interface LongestPalindromicSubstring {
    fun longestPalindrome(s: String): String
}