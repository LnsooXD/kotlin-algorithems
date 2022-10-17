package leetcode.longest.increasing.subsequence

// DP[i] the longest increasing subsequence with the start number of nums[i]

// Solve a problem by solving sub-problems and get the result from the results' collection.

class DP01 : LongestIncreasingSubsequence {
    override fun lengthOfLIS(nums: IntArray): Int {
        val dp = IntArray(nums.size) { 1 }
        var res = 0

        for (i in nums.indices.reversed()) {
            var max = 0
            for (j in i + 1 until nums.size) {
                if (nums[j] > nums[i]) {
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