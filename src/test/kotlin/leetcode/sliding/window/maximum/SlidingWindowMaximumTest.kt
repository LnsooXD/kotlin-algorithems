package leetcode.sliding.window.maximum

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class SlidingWindowMaximumTest {

    private val core = SlidingWindowMaximumPriorityQueue()

    @Test
    fun testMaxSlidingWindow01() {
        val nums = intArrayOf(1, 3, -1, -3, 5, 3, 6, 7)
        val k = 3
        val res = this.core.maxSlidingWindowPriorityQueue(nums, k)
        assertThat(res).isEqualTo(intArrayOf(3, 3, 5, 5, 6, 7))
    }

    @Test
    fun testMaxSlidingWindow02() {
        val nums = intArrayOf(1, 3, -1, 2, 1, 3, 6, 7)
        val k = 3
        val res = this.core.maxSlidingWindowPriorityQueue(nums, k)
        assertThat(res).isEqualTo(intArrayOf(3, 3, 2, 3, 6, 7))
    }

    @Test
    fun testMaxSlidingWindow03() {
        val nums = intArrayOf(1, 3, -2, -1, -3, 3, 6, 7)
        val k = 3
        val res = this.core.maxSlidingWindowPriorityQueue(nums, k)
        assertThat(res).isEqualTo(intArrayOf(3, 3, -1, 3, 6, 7))
    }

}