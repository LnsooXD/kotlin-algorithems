package leetcode.two.sum

class DoubleLoop : TwoSum {

    override fun twoSum(nums: IntArray, target: Int): IntArray {
        val size = nums.size
        if (size <= 1) {
            return intArrayOf()
        }
        for (i in 0 until size) {
            for (j in i + 1 until size) {
                if (nums[i] + nums[j] == target) {
                    return intArrayOf(i, j)
                }
            }
        }
        return intArrayOf()
    }


}