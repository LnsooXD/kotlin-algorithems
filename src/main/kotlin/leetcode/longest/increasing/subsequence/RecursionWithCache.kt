package leetcode.longest.increasing.subsequence

class RecursionWithCache : LongestIncreasingSubsequence {

    override fun lengthOfLIS(nums: IntArray): Int {
        var maxLength = 0
        val cache = IntArray(nums.size) { 0 }
        for (i in nums.indices) {
            val maxSubLength = this.lengthOfLIS(nums, i, cache)
            if (maxSubLength > maxLength) {
                maxLength = maxSubLength
            }
        }
        return maxLength
    }

    private fun lengthOfLIS(nums: IntArray, startIndex: Int, cache: IntArray): Int {
        if (cache[startIndex] == 0) {
            var maxLength = 0
            for (i in startIndex + 1 until nums.size) {
                if (nums[i] > nums[startIndex]) {
                    val maxSubLength = this.lengthOfLIS(nums, i, cache)
                    if (maxSubLength > maxLength) {
                        maxLength = maxSubLength
                    }
                }
            }
            cache[startIndex] = maxLength + 1
        }
        return cache[startIndex]
    }

}