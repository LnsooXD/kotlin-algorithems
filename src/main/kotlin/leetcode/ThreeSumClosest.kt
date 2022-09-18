package leetcode

import java.util.*

// https://leetcode.cn/problems/3sum-closest/

class ThreeSumClosest {

    fun threeSumClosest(nums: IntArray, target: Int): Int {
        val size = nums.size
        if (size <= 3) {
            return nums.reduce { acc, v -> acc + v }
        }

        Arrays.sort(nums)

        var closest = nums[0] + nums[1] + nums[size - 1]
        var closestDiff = abs(closest - target)

        for (i in 0 until size - 2) {

            val ni = nums[i]

            var j = i + 1
            var k = size - 1

            while (j < k) {
                val nj = nums[j]
                val nk = nums[k]

                val sum = ni + nj + nk
                val diff = sum - target

                if (abs(diff) <= closestDiff) {
                    closestDiff = abs(diff)
                    closest = sum
                }

                if (diff == 0) {
                    return target
                } else if (diff > 0) {
                    k--
                } else {
                    j++
                }
            }
        }
        return closest
    }

    private fun abs(a: Int) = if (a > 0) a else -a
}