package leetcode.maximum.product.subarray

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class MaximumProductSubarrayTest {

    private val core = DP02()

    @Test
    fun test() {
        val nums = intArrayOf(2, 3, -2, 4)
        val res = this.core.maxProduct(nums)
        assertThat(res).isEqualTo(6)
    }
}