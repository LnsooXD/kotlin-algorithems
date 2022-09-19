package leetcode;

import java.util.*


// https://leetcode.cn/problems/two-sum/
// https://www.bilibili.com/cheese/play/ep32661?csource=common_hp_history_null

class TwoSum {

    fun twoSum(nums: IntArray, target: Int): IntArray {
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

    fun twoSum1(nums: IntArray, target: Int): IntArray {
        val size = nums.size
        if (size <= 1) {
            return intArrayOf()
        }
        for (i in 0 until size) {
            for (j in i + 1 until size) {
                if (nums[i] + nums[j] == target) {
                    return intArrayOf(i, j)
                }
            }
        }
        return intArrayOf()
    }

    fun twoSum2(nums: IntArray, target: Int): IntArray {
        val map = mutableMapOf<Int, Int>()
        nums.forEachIndexed { index, it ->
            map[target - it]?.run { return intArrayOf(this, index) }
            map[it] = index
        }
        return intArrayOf()
    }

    class Num(val num: Int, val index: Int) : Comparable<Num> {
        override fun compareTo(other: Num) = this.num.compareTo(other.num)
    }
}
