package leetcode.longest.increasing.subsequence

// DP[i] the longest increasing subsequence with the end number of nums[i]

// Solve a problem by solving sub-problems and get the result from the results collection.

class DP : LongestIncreasingSubsequence {
    override fun lengthOfLIS(nums: IntArray): Int {
        if (nums.isEmpty()) {
            return 0
        }
        val dp = IntArray(nums.size) { 1 }

        var res = 1

        for (i in 1 until nums.size) {
            var max = 0
            for (j in 0 until i) {
                if (nums[i] > nums[j]) {
                    if (dp[j] > max) {
                        max = dp[j]
                    }
                }
            }

            dp[i] = max + 1

            if (dp[i] > res) {
                res = dp[i]
            }
        }

        return res
    }
}