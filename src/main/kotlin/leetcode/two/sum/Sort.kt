package leetcode.two.sum

import java.util.*

class Sort : TwoSum {
    override fun twoSum(nums: IntArray, target: Int): IntArray {
        val size = nums.size
        if (size <= 1) {
            return intArrayOf()
        }

        val indexedNums = Array(size) {
            Num(nums[it], it)
        }

        Arrays.sort(indexedNums)

        var i = 0
        var j = size - 1

        while (i < j) {
            if (indexedNums[i].num + indexedNums[j].num == target) {
                return intArrayOf(indexedNums[i].index, indexedNums[j].index)
            } else if (indexedNums[i].num + indexedNums[j].num < target) {
                i++
            } else {
                j--
            }
        }

        return intArrayOf()
    }

    private class Num(val num: Int, val index: Int) : Comparable<Num> {
        override fun compareTo(other: Num) = this.num.compareTo(other.num)
    }
}