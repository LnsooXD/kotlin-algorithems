package leetcode.longest.common.prefix

import leetcode.annotation.ProblemSoruce

// 14. https://leetcode.com/problems/longest-common-prefix/
/**
 * ## [14. Longest Common Prefix](https://leetcode.com/problems/longest-common-prefix/)
 * Write a function to find the longest common prefix string amongst an array of strings.
 *
 * If there is no common prefix, return an empty string "".
 *
 *
 * ### Example 1:
 * ```
 * Input: strs = ["flower","flow","flight"]
 * Output: "fl"
 * ```
 *
 * ### Example 2:
 * ```
 * Input: strs = ["dog","racecar","car"]
 * Output: ""
 * Explanation: There is no common prefix among the input strings.
 * ```
 *
 * ### Constraints:
 *
 * - 1 <= strs.length <= 200
 * - 0 <= strs[i].length <= 200
 * - strs```[i]``` consists of only lowercase English letters.
 **/
@ProblemSoruce(14, "Longest Common Prefix", "https://leetcode.com/problems/longest-common-prefix/")
interface LongestCommonPrefix {
    fun longestCommonPrefix(strs: Array<String>): String
}
