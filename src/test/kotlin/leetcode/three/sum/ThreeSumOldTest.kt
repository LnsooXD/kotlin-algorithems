package leetcode.three.sum

import org.junit.jupiter.api.Test

internal class ThreeSumOldTest {

    private val threeSum = ThreeSumOld()

    @Test
    fun testThreeSum() {
        val nums = intArrayOf(-1, 0, 1, 2, -1, -4)
        val res = this.threeSum.threeSumTwoPoints(nums)
        println(res)
    }

    @Test
    fun testThreeSumZeros() {
        val nums = intArrayOf(0, 0, 0, 0)
        val res = this.threeSum.threeSumTwoPoints(nums)
        println(res)
    }

    @Test
    fun testThreeSum2() {
        val nums = intArrayOf(-2, 0, 2, 2)
        val res = this.threeSum.threeSumTwoPoints(nums)
        println(res)
    }

    @Test
    fun testThreeSum3() {
        val nums = intArrayOf(-1,0,1,2,-1,-4)
        val res = this.threeSum.threeSumTwoPoints(nums)
        println(res) // [[-1,-1,2],[-1,0,1]]
    }


}