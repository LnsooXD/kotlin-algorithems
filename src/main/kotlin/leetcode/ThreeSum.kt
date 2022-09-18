package leetcode

import java.util.*

// https://leetcode.cn/problems/3sum/

class ThreeSum {

    fun threeSum(nums: IntArray): List<List<Int>> {
        val size = nums.size
        if (size <= 2) {
            return listOf()
        }

        Arrays.sort(nums)

        val res = mutableListOf<List<Int>>()

        for (i in 0 until size - 2) {

            val ni = nums[i]

            if (ni >= 0) {
                if (i + 2 < size && ni == 0 && nums[i + 1] == 0 && nums[i + 2] == 0) {
                    res.add(listOf(0, 0, 0))
                }
                break
            }

            if (i > 0 && ni == nums[i - 1]) {
                continue
            }
            var j = i + 1
            var k = size - 1

            var cj: Boolean
            var ck: Boolean

            while (j < k) {
                val nj = nums[j]
                val nk = nums[k]

                cj = false
                ck = false

                val sum = ni + nj + nk
                if (sum == 0) {
                    res.add(listOf(ni, nj, nk))
                    cj = true
                    ck = true
                } else if (sum > 0) {
                    ck = true
                } else {
                    cj = true
                }

                if (cj) {
                    while (j < k && nums[j] == nj) {
                        j++
                    }
                }
                if (ck) {
                    while (j < k && nums[k] == nk) {
                        k--
                    }
                }
            }
        }
        return res
    }
}