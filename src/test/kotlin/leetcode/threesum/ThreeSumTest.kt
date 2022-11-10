package leetcode.threesum

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class ThreeSumTest {

    private val core = HashTwoNum()

    @Test
    fun test01() {
        val nums = intArrayOf(-1, 0, 1, 2, -1, -4)
        val res = this.core.threeSum(nums)
        assertThat(res).isEqualTo(
            listOf(
                listOf(-1, 0, 1),
                listOf(-1, -1, 2)
            )
        )
    }

    @Test
    fun test02() {
        val nums = intArrayOf(0, 1, 1)
        val res = this.core.threeSum(nums)
        assertThat(res).isEqualTo(listOf<Int>())
    }

    @Test
    fun test03() {
        val nums = intArrayOf(0, 0, 0)
        val res = this.core.threeSum(nums)
        assertThat(res).isEqualTo(listOf(listOf(0, 0, 0)))
    }
}

