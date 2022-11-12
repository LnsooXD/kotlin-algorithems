package leetcode.four.sum

import leetcode.annotation.SolvingDate

@SolvingDate(2022, 11, 12)
class Rude : FourSum {

    override fun fourSum(nums: IntArray, target: Int): List<List<Int>> {
        if (nums.size < 4) {
            return emptyList()
        }
        val res = mutableSetOf<List<Int>>()
        for (i in 0..nums.size - 4) {
            for (j in i + 1..nums.size - 3) {
                for (k in j + 1..nums.size - 2) {
                    for (l in k + 1 until nums.size) {
                        if (nums[i] + nums[j] + nums[k] + nums[l] == target) {
                            res.add(listOf(nums[i], nums[j], nums[k], nums[l]).sorted())
                        }
                    }
                }
            }
        }
        return res.toList()
    }

}