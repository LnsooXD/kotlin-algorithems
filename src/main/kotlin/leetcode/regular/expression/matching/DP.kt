package leetcode.regular.expression.matching

import leetcode.annotation.SolvingDate

// 字符串匹配问题一律使用二维 DP，因为 s 和 p 都是动态变化的， 今天这里没想通如何使用 DP 来求解，主要就是没考虑到这一点
// 只想到一维的匹配：只变化 pattern 或只变化 string
// DP[0][0] == true : isMatch("", "")
// DP[i][j] 表示 s[0..i] 和 p[0..j] 是否匹配
// if (s[i-1] == p[j-1] or p[j-1] == '.') => DP[i][j] = DP[i-1][j-1]
// if (p[j-1] == '*') =>
//      DP[i][j] = DP[i][j-1] or DP[i][j-2] || ((p[j-2] == s[i-1] or p[j-2] == '.') and (DP[i-1][j]))
//
@SolvingDate(2022, 11, 1)
class DP(override var count: Int) : RegularExpressionMatching {
    override fun isMatch(s: String, p: String): Boolean {
        val dp = Array(s.length + 1) { BooleanArray(p.length + 1) { false } }
        dp[0][0] = true // j == 0
        if (s.isNotEmpty() && p.isNotEmpty()) {
            dp[1][1] = p[0] == s[0] || p[0] == '.' // j == 1s
        }
        for (j in 2 until dp[0].size) { // i == 0
            dp[0][j] = p[j - 1] == '*' && dp[0][j - 2]
        }

        for (i in 1 until dp.size) {
            for (j in 2 until dp[i].size) {
                this.count++
                if (p[j - 1] == s[i - 1] || p[j - 1] == '.') {
                    dp[i][j] = dp[i - 1][j - 1]
                } else if (p[j - 1] == '*') {
                    dp[i][j] = dp[i][j - 2] || dp[i][j - 1] ||
                            // 特殊情况, 从 dp[i - 1][j] 到 dp[i][j] 和 * 有关，不能直接和单个匹配关联
                            ((p[j - 2] == s[i - 1] || p[j - 2] == '.') && dp[i - 1][j])
                }
            }
        }
        return dp[s.length][p.length]
    }
}