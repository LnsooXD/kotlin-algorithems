package leetcode

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class MedianOfTwoSortedArraysTest {

    private val core = MedianOfTwoSortedArrays()

    @Test
    fun testFindMedianSortedArrays01() {
        val nums1 = intArrayOf(1, 2, 3)
        val nums2 = intArrayOf(3, 6)
        val res = this.core.findMedianSortedArrays(nums1, nums2)
        assertThat(res).isEqualTo(3.0)
    }

    @Test
    fun testFindMedianSortedArrays02() {
        val nums1 = intArrayOf(1)
        val nums2 = intArrayOf(1)
        val res = this.core.findMedianSortedArrays(nums1, nums2)
        assertThat(res).isEqualTo(1.0)
    }

    @Test
    fun testFindMedianSortedArrays03() {
        val nums1 = intArrayOf(1, 2)
        val nums2 = intArrayOf(3, 4)
        val res = this.core.findMedianSortedArrays(nums1, nums2)
        assertThat(res).isEqualTo(2.5)
    }

    @Test
    fun testFindMedianSortedArrays04() {
        val nums1 = intArrayOf(1, 2, 345, 676, 2453)
        val nums2 = intArrayOf(3, 4)
        val res = this.core.findMedianSortedArrays(nums1, nums2)
        assertThat(res).isEqualTo(4.0)
    }
}
