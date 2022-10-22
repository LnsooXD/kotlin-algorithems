package leetcode.kth.largest.element.`in`.a.stream

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class KthLargestITest {

    @Test
    fun test() {
        val kthLargest = this.obtainInstance(3, intArrayOf(4, 5, 8, 2))
        val inputs = intArrayOf(3, 5, 10, 9, 4)

        val res = inputs.map { kthLargest.add(it) }

        assertThat(res).isEqualTo(listOf(4, 5, 5, 8, 8))
    }

    private fun obtainInstance(k: Int, nums: IntArray): KthLargestI {
        return KthMinHeap(k, nums)
    }
}

