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

    private fun findTarget(lis: IntArray, length: Int, target: Int): Int {
        if (length <= 0 || lis[length - 1] < target) {
            return length
        } else if (lis[0] >= target) {
            return 0
        }

        var left = 0
        var right = length - 1
        var mid = right.ushr(1)

        while (mid != left && mid != right) {
            if (lis[mid] > target) {
                right = mid
            } else {
                left = mid
            }
            mid = (left + right).ushr(1)
        }
        // there are only two situations:
        // - lis[mid - 1] < target <= lis[mid]
        // - lis[mid] < target <= lis[mid + 1]
        // because: lis[0] < target <= lis[length - 1]
        return if (target > lis[mid]) mid + 1 else mid
    }
}