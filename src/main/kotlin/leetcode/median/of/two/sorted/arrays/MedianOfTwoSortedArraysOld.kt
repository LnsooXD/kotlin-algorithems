package leetcode.median.of.two.sorted.arrays

// 4. https://leetcode.cn/problems/median-of-two-sorted-arrays/

// DATE 2022-09-18
class MedianOfTwoSortedArraysOld {

    private fun findKLargeNum(nums1: IntArray, nums2: IntArray, k: Int): Int {
        val length1 = nums1.size
        val length2 = nums2.size

        var index1 = 0
        var index2 = 0
        var rankK = k

        while (true) {
            if (index1 >= length1) {
                return nums2[index2 + rankK - 1]
            }

            if (index2 >= length2) {
                return nums1[index1 + rankK - 1]
            }

            if (rankK == 1) {
                return this.min(nums1[index1], nums2[index2])
            }

            val half = rankK / 2

            val newIndex1 = this.min(index1 + half, length1) - 1
            val newIndex2 = this.min(index2 + half, length2) - 1

            if (nums1[newIndex1] > nums2[newIndex2]) {
                rankK -= (newIndex2 - index2 + 1)
                index2 = newIndex2 + 1
            } else {
                rankK -= (newIndex1 - index1 + 1)
                index1 = newIndex1 + 1
            }
        }
    }

    fun findMedianSortedArrays(nums1: IntArray, nums2: IntArray): Double {
        val total = nums1.size + nums2.size
        return if (total % 2 == 1) {
            this.findKLargeNum(nums1, nums2, (total + 1) / 2).toDouble()
        } else {
            (this.findKLargeNum(nums1, nums2, total / 2 + 1) + this.findKLargeNum(nums1, nums2, total / 2)) / 2.0
        }
    }

    fun min(a: Int, b: Int): Int {
        return if (a < b) a else b
    }

    fun max(a: Int, b: Int): Int {
        return if (a > b) a else b
    }
}