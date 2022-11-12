package leetcode.four.sum

import leetcode.annotation.SolvingDate

// size = 5:
// 0,1  0,2  0,3  0,4   // level = 4
// 1,2  1,3  1,4        // level = 3
// 2,3  2,4             // level = 2
// 3,4                  // level = 1

@SolvingDate(2022, 11, 12)
class AsTwoSumHashMap : FourSum {
    override fun fourSum(nums: IntArray, target: Int): List<List<Int>> {
        if (nums.size < 4) {
            return emptyList()
        }

        val twoSumsSize = (nums.size * (nums.size - 1)).ushr(1)
        val cache = HashMap<Long, HashMap<Int, IntArray>>(twoSumsSize)
        val res = mutableSetOf<List<Int>>()

        var level = nums.size - 1
        var offset = 0

        for (m in 0 until twoSumsSize) {
            val i = nums.size - (level + 1)
            val j = i + 1 + (m - offset)
            if (j + 1 == nums.size) {
                offset += level
                level--
            }
            val sum = nums[i].toLong() + nums[j]
            cache[target - sum]?.let {
                for (item in it.values) {
                    if (!(i in item || j in item)) {
                        res.add(listOf(nums[i], nums[j], nums[item[0]], nums[item[1]]).sorted())
                    }
                }
            }

            val items = cache[sum]
            if (items == null) {
                cache[sum] = hashMapOf(
                    Pair(
                        nums[i],
                        intArrayOf(i, j)
                    )
                )
            } else {
                items[nums[i]] = intArrayOf(i, j)
            }
        }
        return res.toList()
    }
}