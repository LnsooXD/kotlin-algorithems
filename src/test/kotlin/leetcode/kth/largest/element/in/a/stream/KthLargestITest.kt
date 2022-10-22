package leetcode.kth.largest.element.`in`.a.stream

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class KthLargestITest {

    @Test
    fun test01() {
        val kthLargest = this.obtainInstance(3, intArrayOf(4, 5, 8, 2))
        val inputs = intArrayOf(3, 5, 10, 9, 4)

        val res = inputs.map { kthLargest.add(it) }

        assertThat(res).isEqualTo(listOf(4, 5, 5, 8, 8))
    }

    @Test
    fun test02() {
        val kthLargest = this.obtainInstance(7, intArrayOf(-10, 1, 3, 1, 4, 10, 3, 9, 4, 5, 1))
        val inputs = intArrayOf(3, 2, 3, 1, 2, 4, 5, 5, 6, 7, 7, 8, 2, 3, 1, 1, 1, 10, 11, 5, 6, 2, 4, 7, 8, 5, 6)

        val res = inputs.map { kthLargest.add(it) }

        assertThat(res).isEqualTo(
            listOf(3, 3, 3, 3, 3, 3, 4, 4, 4, 5, 5, 5, 5, 5, 5, 5, 5, 6, 7, 7, 7, 7, 7, 7, 7, 7, 7)
        )
    }

    private fun obtainInstance(k: Int, nums: IntArray): KthLargestI {
        return KthMinHeap01(k, nums)
    }
}

