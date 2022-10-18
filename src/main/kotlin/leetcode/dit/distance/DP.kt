package leetcode.dit.distance

// DP[i][j] the minimum distance steps to let word1[0..i] => word[0..j]

// https://leetcode.com/problems/coin-change/discuss/114993/four-kinds-of-solutions-dp-bfs-dfs-improved-dfs

class DP : EditDistance {
    override fun minDistance(word1: String, word2: String): Int {

        val dp = Array(word1.length + 1) { i -> IntArray(word2.length + 1) { j -> abs(i - j) } }

        for (i in 1..word1.length) {
            for (j in 1..word2.length) {
                dp[i][j] = min(
                    dp[i - 1][j] + 1, // Insert
                    dp[i][j - 1] + 1, // Delete
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