package leetcode.climbing.stairs

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class ClimbingStairsTest {

    private val core = Recursion()

    @Test
    fun test1() {
        val n = 1
        val res = this.core.climbStairs(n)
        assertThat(res).isEqualTo(1)
    }

    @Test
    fun test2() {
        val n = 2
        val res = this.core.climbStairs(n)
        assertThat(res).isEqualTo(2)
    }

    @Test
    fun test20() {
        val n = 20
        val res = this.core.climbStairs(n)
        assertThat(res).isEqualTo(10946)
    }

}