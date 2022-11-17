package leetcode.median.of.two.sorted.arrays

import org.assertj.core.api.Assertions.assertThat
import org.testng.annotations.Test

internal class MedianOfTwoSortedArraysTest {

    private val core = KLargest()

    @Test
    fun test01() {
        val nums1 = intArrayOf(1, 3)
        val nums2 = intArrayOf(2)
        val res = this.core.findMedianSortedArrays(nums1, nums2)
        assertThat(res).isEqualTo(2.0)
    }

    @Test
    fun test02() {
        val nums1 = intArrayOf()
        val nums2 = intArrayOf()
        val res = this.core.findMedianSortedArrays(nums1, nums2)
        assertThat(res).isEqualTo(0.0)
    }

    @Test
    fun test03() {
        val nums1 = intArrayOf()
        val nums2 = intArrayOf(1)
        val res = this.core.findMedianSortedArrays(nums1, nums2)
        assertThat(res).isEqualTo(1.0)
    }

    @Test
    fun test04() {
        val nums1 = intArrayOf(2)
        val nums2 = intArrayOf()
        val res = this.core.findMedianSortedArrays(nums1, nums2)
        assertThat(res).isEqualTo(2.0)
    }

    @Test
    fun test05() {
        val nums1 = intArrayOf(1, 2)
        val nums2 = intArrayOf(3, 4)
        val res = this.core.findMedianSortedArrays(nums1, nums2)
        assertThat(res).isEqualTo(2.5)
    }

    @Test
    fun test06() {
        val nums1 = intArrayOf(0, 0)
        val nums2 = intArrayOf(0, 0)
        val res = this.core.findMedianSortedArrays(nums1, nums2)
        assertThat(res).isEqualTo(0.0)
    }
}

internal class MedianOfTwoSortedArraysOldTest {

    private val core = MedianOfTwoSortedArraysOld()

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