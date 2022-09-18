package leetcode

// https://leetcode.cn/problems/remove-duplicates-from-sorted-array/

class RemoveDuplicatesFromSortedArray {

    fun removeDuplicates(nums: IntArray): Int {
        val size = nums.size
        if (size <= 1) {
            return size
        }
        var j = 1
        var curr = nums[0]
        for (i in 1 until size) {
            if (nums[i] != curr) {
                curr = nums[i]
                nums[j] = curr
                j++
            }
        }
        return j
    }

}