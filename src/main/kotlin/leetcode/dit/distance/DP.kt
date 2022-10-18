package leetcode.dit.distance

// DP[i][j] the minimum distance steps to let word1[0..i] => word2[0..j]

// https://leetcode.com/problems/coin-change/discuss/114993/four-kinds-of-solutions-dp-bfs-dfs-improved-dfs

class DP : EditDistance {
    override fun minDistance(word1: String, word2: String): Int {

        val dp = Array(word1.length + 1) { i -> IntArray(word2.length + 1) { j -> abs(i - j) } }

        for (i in 1..word1.length) {
            for (j in 1..word2.length) {
                // 关于删除增加，可以从变化的角度考虑：插入就
                dp[i][j] = min(
                    // Delete：因为 word1[0..i-1] == word2[0..j], 所以只需在 dp[i][j] 基础上删除最后一个字符word1[i-1]，
                    // 回到dp[i - 1][j] 的状态即可
                    dp[i - 1][j] + 1,
                    // Insert：因为 word1[0..i] == word2[0..j-1], 所以只需在 dp[i][j - 1] 的基础上进行一个插入匹配上 word2[j-1]
                    dp[i][j - 1] + 1,
                    dp[i - 1][j - 1] + if (word1[i - 1] == word2[j - 1]) 0 else 1 // replace or skip
                )
            }
        }
        return dp[word1.length][word2.length]
    }

    companion object {
        fun abs(a: Int) = if (a < 0) -a else a
        private fun min(a: Int, b: Int) = if (a < b) a else b
        fun min(a: Int, b: Int, c: Int) = min(min(a, b), c)
    }
}