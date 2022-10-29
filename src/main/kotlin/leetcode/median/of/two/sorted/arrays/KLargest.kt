package leetcode.median.of.two.sorted.arrays

// DATE 2022-10-29
class KLargest : MedianOfTwoSortedArraysI {

    // 基本原理:
    // 1. 把求中位数转换成求第 k 大问题， 其中 k = (nums1.size + nums2.size) / 2
    // 2. 每个求第 k 大的时候，最多从两个数组中排除掉 m 个较小的数，其中 m = (k/2 - 1) + (k/2 - 1) = ceil(k/2) - 2 < k 且数组是单调递增的,
    //    因此被排除的数一定比第 k 大的数小

    override fun findMedianSortedArrays(nums1: IntArray, nums2: IntArray): Double {
        val total = nums1.size + nums2.size
        if (total <= 0) {
            return 0.0
        }

        val midLargest = findKLargest(total.ushr(1) + 1, 0, 0, nums1, nums2)
        return if (total.and(1) == 1) {
            midLargest.toDouble()
        } else {
            (findKLargest(total.ushr(1), 0, 0, nums1, nums2) + midLargest) / 2.0
        }
    }

    private fun findKLargest(k: Int, startIndex1: Int, startIndex2: Int, nums1: IntArray, nums2: IntArray): Int {
        if (startIndex1 >= nums1.size) {
            return nums2[startIndex2 + k - 1]
        } else if (startIndex2 >= nums2.size) {
            return nums1[startIndex1 + k - 1]
        } else if (k == 1) {
            return min(nums1[startIndex1], nums2[startIndex2])
        }

        val increment = k ushr 1
        val newIndex1 = min(startIndex1 + increment, nums1.size) - 1
        val newIndex2 = min(startIndex2 + increment, nums2.size) - 1


        return if (nums1[newIndex1] < nums2[newIndex2]) {
            findKLargest(
                k - (newIndex1 - startIndex1 + 1),
                newIndex1 + 1,
                startIndex2,
                nums1,
                nums2
            )
        } else {
            findKLargest(
                k - (newIndex2 - startIndex2 + 1),
                startIndex1,
                newIndex2 + 1,
                nums1,
                nums2
            )
        }

        // 相等的时候只排除一个数组里面的数据， 不然会导致最后两个数组都是空的

//        else if (nums1[newIndex1] > nums2[newIndex2]) {
//            findKLargest(
//                k - (newIndex2 - startIndex2 + 1),
//                startIndex1,
//                newIndex2 + 1,
//                nums1,
//                nums2
//            )
//        } else {
//            println("xx newIndex1: $newIndex1, startIndex1: $startIndex1")
//            findKLargest(
//                k - (newIndex1 - startIndex1 + 1) - (newIndex2 - startIndex2 + 1),
//                newIndex1 + 1,
//                newIndex2 + 1,
//                nums1,
//                nums2
//            )
//        }
    }

    companion object {
        fun min(vararg args: Int) = args.reduce { a, b -> if (a < b) a else b }
    }
}