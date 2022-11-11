package leetcode.three.sum.closest

import leetcode.annotation.SolvingDate

@SolvingDate(2022, 11, 11)
class Rude : ThreeSumClosest {
    override fun threeSumClosest(nums: IntArray, target: Int): Int {
        if (nums.size <= 3) {
            return nums.reduce { acc, i -> acc + i }
        }

        var sum = nums[0] + nums[1] + nums[2]
        var diff = abs(sum - target)
        for (i in 0..nums.size - 3) {
            for (j in i + 1..nums.size - 2) {
                for (k in j + 1 until nums.size) {
                    val newSum = nums[i] + nums[j] + nums[k]
                    val newDiff = abs(newSum - target)
                    if (newDiff < diff) {
                        sum = newSum
                        diff = newDiff
                    }
                }
            }
        }
        return sum
    }

    companion object {
        fun abs(a: Int) = if (a < 0) -a else a
    }
}