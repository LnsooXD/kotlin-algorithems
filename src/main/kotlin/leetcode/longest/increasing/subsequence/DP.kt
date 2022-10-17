package leetcode.longest.increasing.subsequence

// DP[i] the longest increasing subsequence with the end number of nums[i]

// Solve a problem by solving sub-problems and get the result from the results' collection.

class DP : LongestIncreasingSubsequence {
    override fun lengthOfLIS(nums: IntArray): Int {
        val dp = IntArray(nums.size) { 1 }
        var res = 0

        for (i in 1 until nums.size) {
            for (j in 0 until i) {
                if (nums[i] > nums[j]) {
                    val dpj = dp[j] + 1
                    if (dpj > dp[i]) {
                        dp[i] = dpj
                    }
                }
            }
            if (dp[i] > res) {
                res = dp[i]
            }
        }

        return res
    }
}