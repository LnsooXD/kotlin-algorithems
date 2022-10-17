package leetcode.two.sum

import org.assertj.core.api.Assertions
import org.junit.jupiter.api.Test

internal class TwoSumTest {

    private val twoSum = HashMap()

    @Test
    fun testTwoSum() {
        val nums = intArrayOf(2, 7, 11, 15)
        val target = 9
        val res = this.twoSum.twoSum(nums, target)
        Assertions.assertThat(res).isEqualTo(intArrayOf(0, 1))
    }

    @Test
    fun testTwoSum1() {
        val nums = intArrayOf(2, 7, 11, 15)
        val target = 9
        val res = this.twoSum.twoSum(nums, target)
        Assertions.assertThat(res).isEqualTo(intArrayOf(0, 1))
    }
}