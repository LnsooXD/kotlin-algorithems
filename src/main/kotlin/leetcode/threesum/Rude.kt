package leetcode.threesum

import leetcode.annotation.SolvingDate

@SolvingDate(2022, 11, 10)
class Rude : ThreeSum {
    override fun threeSum(nums: IntArray): List<List<Int>> {
        val result = mutableSetOf<List<Int>>()
        for (i in 0..nums.size - 3) {
            for (j in i + 1..nums.size - 2) {
                for (k in j + 1 until nums.size) {
                    if (nums[i] + nums[j] + nums[k] == 0) {
                        result.add(listOf(nums[i], nums[j], nums[k]).sorted())
                    }
                }
            }
        }
        return result.toList()
    }
}