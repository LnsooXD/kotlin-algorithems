package leetcode.four.sum

import leetcode.annotation.SolvingDate

@SolvingDate(2022, 11, 12)
class AsThreeSunTwoPointers : FourSum {
    override fun fourSum(nums: IntArray, target: Int): List<List<Int>> {
        val res = mutableSetOf<List<Int>>()
        nums.sort()
        for (i in 0..nums.size - 4) {
            for (j in i + 1..nums.size - 3) {
                val subTarget = target.toLong() - nums[i] - nums[j]
                var k = j + 1
                var l = nums.size - 1
                while (k < l) {
                    val subSum = nums[k].toLong() + nums[l]
                    if (subSum == subTarget) {
                        res.add(listOf(nums[i], nums[j], nums[k], nums[l]).sorted())
                        k++
                        l--
                    } else if (subSum < subTarget) {
                        k++
                    } else {
                        l--
                    }
                }
            }
        }
        return res.toList()
    }

}