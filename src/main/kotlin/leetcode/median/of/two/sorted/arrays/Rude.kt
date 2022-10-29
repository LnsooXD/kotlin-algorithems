package leetcode.median.of.two.sorted.arrays

// DATE 2022-10-29
class Rude : MedianOfTwoSortedArraysI {
    override fun findMedianSortedArrays(nums1: IntArray, nums2: IntArray): Double {
        val totalSize = nums1.size + nums2.size
        if (totalSize == 0) {
            return 0.0
        }
        val halfIndex = ((nums1.size + nums2.size) ushr 1)
        val values = IntArray(halfIndex + 1)
        var index1 = 0
        var index2 = 0

        for (i in 0..halfIndex) {
            if (index1 < nums1.size && index2 < nums2.size) {
                if (nums1[index1] < nums2[index2]) {
                    values[i] = nums1[index1]
                    index1++
                } else {
                    values[i] = nums2[index2]
                    index2++
                }
            } else if (index2 >= nums2.size) {
                values[i] = nums1[index1]
                index1++
            } else {
                values[i] = nums2[index2]
                index2++
            }
        }

        return if (totalSize.and(1) == 1) {
            values[halfIndex].toDouble()
        } else {
            (values[halfIndex - 1] + values[halfIndex]) / 2.0
        }
    }
}