package leetcode.maximum.product.subarray

class DP02 : MaximumProductSubarray {

    override fun maxProduct(nums: IntArray): Int {
        if (nums.isEmpty()) {
            return 0
        } else if (nums.size <= 1) {
            return nums[0]
        }

        val max = IntArray(2) { nums[0] }
        val min = IntArray(2) { nums[0] }

        var res = nums[0]

        for (i in 1 until nums.size) {
            val num = nums[i]
            val x = i.and(1)
            val y = (i - 1).and(1)
            max[x] = max(num, num * if (num >= 0) max[y] else min[y])
            min[x] = min(num, num * if (num < 0) max[y] else min[y])
            res = max(res, max[x])
        }
        return res
    }

    companion object {
        private fun min(a: Int, b: Int) = if (a < b) a else b
        private fun max(a: Int, b: Int) = if (a > b) a else b
    }
}