package leetcode

// https://leetcode.cn/problems/remove-element/

class RemoveElement {

    fun removeElement(nums: IntArray, `val`: Int): Int {
        if (nums.isEmpty()) {
            return 0
        }
        var size = nums.size
        var j = 0
        for (i in nums.indices) {
            if (nums[i] != `val`) {
                nums[j] = nums[i]
                j++
            } else {
                size--
            }
        }

        return size
    }
}