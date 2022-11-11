package leetcode.three.sum.closest

import leetcode.annotation.SolvingDate

@SolvingDate(2022, 11, 11)
class ThreePointers : ThreeSumClosest {
    override fun threeSumClosest(nums: IntArray, target: Int): Int {
        if (nums.size <= 3) {
            return nums.reduce { acc, i -> acc + i }
        }
        nums.sort()

        var sum = nums[0] + nums[1] + nums[2]
        if (sum >= target) {
            return sum
        }

        var diff = abs(sum - target)

        for (i in 0..nums.size - 3) {
            var j = i + 1
            var k = nums.size - 1
            while (j < k) {
                val newSum = nums[i] + nums[j] + nums[k]
                if (newSum == target) {
                    return newSum
                } else if (newSum < target) {
                    j++
                } else {
                    k--
                }

                val newDiff = abs(newSum - target)
                if (newDiff < diff) {
                    diff = newDiff
                    sum = newSum
                }
            }
        }
        return sum
    }

    companion object {
        fun abs(a: Int) = if (a < 0) -a else a
    }
}