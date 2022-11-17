package leetcode

import org.testng.annotations.Test

internal class FourSumTest {
    private val fourSum = FourSum()

    // 输入：nums = [1,0,-1,0,-2,2], target = 0
    // 输出：[[-2,-1,1,2],[-2,0,0,2],[-1,0,0,1]]
    @Test
    fun testFourSum1() {
        val nums = intArrayOf(1, 0, -1, 0, -2, 2)
        val target = 0
        val res = this.fourSum.fourSum(nums, target)
        println(res)
    }

    // 输入：nums = [2,2,2,2,2], target = 8
    // 输出：[[2,2,2,2]]
    @Test
    fun testFourSum2() {
        val nums = intArrayOf(2, 2, 2, 2, 2)
        val target = 8
        val res = this.fourSum.fourSum(nums, target)
        println(res)
    }

    // 输入：nums = [0,0,0,-1000000000,-1000000000,-1000000000,-1000000000], target = -1000000000
    // 输出：[[-1000000000,0,0,0]]
    @Test
    fun testFourSum3() {
        val nums = intArrayOf(0,0,0,-1000000000,-1000000000,-1000000000,-1000000000)
        val target = -1000000000
        val res = this.fourSum.fourSum(nums, target)
        println(res)
    }

    @Test
    fun testFourSum4() {
        val nums = intArrayOf(0,0,0,0)
        val target = 0
        val res = this.fourSum.fourSum(nums, target)
        println(res)
    }
}