package leetcode.threesum

import leetcode.annotation.SolvingDate

@SolvingDate(2022, 11, 10)
class SortedTwoPointers : ThreeSum {
    override fun threeSum(nums: IntArray): List<List<Int>> {
        if (nums.size < 3) {
            return emptyList()
        }
        nums.sort()
        if (nums[nums.size - 1] < 0) {
            return emptyList()
        }
        val result = mutableSetOf<List<Int>>()
        for (i in 0..nums.size - 3) {
            var j = i + 1
            if (nums[i] + nums[i + 1] > 0) {
                break
            }
            var k = nums.size - 1
            while (j < k) {
                val sum = nums[i] + nums[j] + nums[k]
                if (sum == 0) {
                    result.add(listOf(nums[i], nums[j], nums[k]).sorted())
                    j++
                    k--
                } else if (sum < 0) {
                    j++
                } else {
                    k--
                }
            }
        }
        return result.toList()
    }
}