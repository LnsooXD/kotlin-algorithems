package leetcode

import java.util.*

// https://leetcode.cn/problems/3sum/

class FourSum {

    fun fourSum(nums: IntArray, target: Int): List<List<Int>> {
        val size = nums.size
        if (size <= 3) {
            return listOf()
        }

        val longTarget = target.toLong()
        val longNums = nums.map { it.toLong() }.toLongArray()

        Arrays.sort(longNums)

        val res = mutableListOf<List<Int>>()

        for (i in 0 until size - 3) {

            val ni = longNums[i]

            if (i > 0 && ni == longNums[i - 1]) {
                continue
            }

            if (ni + longNums[i + 1] + longNums[i + 2] + longNums[i + 3] > longTarget) {
                break
            }

            val bj = i + 1

            for (j in bj until size - 2) {
                val nj = longNums[j]

                if (j > bj && nj == longNums[j - 1]) {
                    continue
                }

                if (ni + nj + longNums[j + 1] + longNums[i + 2] > longTarget) {
                    break
                }

                var L = j + 1
                var R = size - 1

                while (L < R) {
                    val nL = longNums[L]
                    val nR = longNums[R]

                    var cL = false
                    var cR = false

                    val sum = ni + nj + nL + nR

                    if (sum == longTarget) {
                        res.add(listOf(ni.toInt(), nj.toInt(), nL.toInt(), nR.toInt()))
                        cL = true
                        cR = true
                    } else if (sum < longTarget) {
                        cL = true
                    } else {
                        cR = true
                    }
                    if (cL) {
                        while (L < R && longNums[L] == nL) {
                            L++
                        }
                    }
                    if (cR) {
                        while (L < R && longNums[R] == nR) {
                            R--
                        }
                    }

                }
            }
        }
        return res
    }
}