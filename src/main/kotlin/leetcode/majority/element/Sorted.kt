package leetcode.majority.element

class Sorted : MajorityElement {
    override fun majorityElement(nums: IntArray): Int {
        nums.sort()
        return nums[nums.size.shr(1)]
    }
}