package leetcode.three.sum

import leetcode.annotation.SolvingDate

@SolvingDate(2022, 11, 10)
class HashTwoNum : ThreeSum {
    override fun threeSum(nums: IntArray): List<List<Int>> {
        val result = mutableSetOf<List<Int>>()
        for (i in 0..nums.size - 3) {
            val map = hashMapOf<Int, Int>()
            val target = -nums[i]
            for (j in i + 1 until nums.size) {
                map[target - nums[j]]?.let { result.add(listOf(nums[i], nums[it], nums[j]).sorted()) }
                map[nums[j]] = j
            }
        }
        return result.toList()
    }

}