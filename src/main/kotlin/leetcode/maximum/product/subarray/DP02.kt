package leetcode.maximum.product.subarray

class DP02 : MaximumProductSubarray {

    override fun maxProduct(nums: IntArray): Int {
        if (nums.isEmpty()) {
            return 0
        } else if (nums.size <= 1) {
            return nums[0]
        }

        val dp = Array(2) { IntArray(2) { nums[0] } }

        var res = nums[0]

        for (i in 1 until nums.size) {
            val num = nums[i]
            val x = i.and(1)
            val y = (i - 1).and(1)
            dp[x][0] = max(num, num * if (num >= 0) dp[y][0] else dp[y][1])
            dp[x][1] = min(num, num * if (num < 0) dp[y][0] else dp[y][1])
            res = max(res, dp[x][0])
        }
        return res
    }

    companion object {
        private fun min(a: Int, b: Int) = if (a < b) a else b
        private fun max(a: Int, b: Int) = if (a > b) a else b
    }
}