package leetcode.longest.increasing.subsequence

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class LongestIncreasingSubsequenceTest {

    private val core = DP()

    @Test
    fun test01() {
        val nums = intArrayOf(10, 9, 2, 5, 3, 7, 101, 18)
        val res = this.core.lengthOfLIS(nums)
        assertThat(res).isEqualTo(4)
    }

    @Test
    fun test02() {
        val nums = intArrayOf(0, 1, 0, 3, 2, 3)
        val res = this.core.lengthOfLIS(nums)
        assertThat(res).isEqualTo(4)
    }

    @Test
    fun test03() {
        val nums = intArrayOf(7, 7, 7, 7, 7, 7, 7)
        val res = this.core.lengthOfLIS(nums)
        assertThat(res).isEqualTo(1)
    }

}