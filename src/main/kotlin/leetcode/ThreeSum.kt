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

    fun threeSumTwoPoints(nums: IntArray): List<List<Int>> {
        if (nums.size < 3) {
            return listOf()
        }

        val res = mutableListOf<List<Int>>()
        nums.sort()

        // a + b + c = 0
        for (i in 0 until nums.size - 2) {
            if (i > 0 && nums[i] == nums[i - 1]) {
                continue
            }

            // 求 b + c = -a

            val a = nums[i]

            var j = i + 1
            var k = nums.size - 1

            while (j < k) { // b < c
                val b = nums[j]
                val c = nums[k]
                val total = a + b + c

                if (total == 0) {
                    res.add(listOf(a, b, c))
                }

                if (total <= 0) {
                    while(j < k && nums[j] == b) {
                        j++
                    }
                }

                if (total >= 0) {
                    while(j < k && nums[k] == c) {
                        k--
                    }
                }
            }
        }
        return res
    }

    fun threeSumHash(nums: IntArray): List<List<Int>> {
        if (nums.size < 3) {
            return listOf()
        }
        val res = mutableListOf<List<Int>>()
        val map = hashMapOf<Int, Boolean>()
        // 排序， 方便后面排重
        nums.sort()

        // a + b + c = 0
        for (i in 0 until nums.size - 2) {
            if (i > 0 && nums[i] == nums[i - 1]) {
                continue
            }
            val a = nums[i]
            // a 固定为常数, 令 A = a, 降维为两数之和

            // b + c = -A
            //
            // b = -A - c
            // c = -A -b

            map.clear()
            for (j in i + 1 until nums.size) {
                val count = map[nums[j]]
                if (count != null) { // nums[j] is c, b = -A - c, b < c, 多 c 情况
                    if (count == true) { // 同一个 c 只使用一次
                        res.add(listOf(a, -a - nums[j], nums[j]))
                        map[nums[j]] = false
                    }
                } else {  // nums[j] is b, c = -A - b, b < c (由顺序数组 + hashmap 保证: 因为优先入 map， 所以如 map 的一定是大数)
                    map[-a - nums[j]] = true
                }
            }
        }
        return res
    }
}