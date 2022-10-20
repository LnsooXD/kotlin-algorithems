package leetcode.longest.increasing.subsequence

// The essence is comparing and replacing in one LIS array to keep the length.

class MaintainLISWithBinarySearch : LongestIncreasingSubsequence {

    override fun lengthOfLIS(nums: IntArray): Int {
        val lis = IntArray(nums.size) { 0 }
        var length = 0

        for (i in nums.indices) {
            val index = this.findTarget(lis, length, nums[i])
            lis[index] = nums[i]
            length += if (index >= length) 1 else 0
        }

        return length
    }

    // find the first index in the lis which value >= target
    private fun findTarget(lis: IntArray, length: Int, target: Int): Int {
        var left = 0
        var right = length - 1

        while (left <= right) {
            val mid = (left + right).ushr(1)
            if (lis[mid] > target) {
                right = mid - 1
            } else if (lis[mid] < target) {
                left = mid + 1
            } else {
                return mid
            }
        }

        // left is the first index in the lis which value > target
        // right is the last index in the lis which value < target
        return left
    }
}