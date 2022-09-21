package leetcode.majority.element

class BoyerMoore : MajorityElement {

    // 预设：众数一定存在
    // 分类：数组中的数字分为两类：非众数和众数。投票就是一个非众数和众数不断相互抵消的过程，直到最后众数获胜
    override fun majorityElement(nums: IntArray): Int {
        var candidate = nums[0]
        var count = 0
        for (num in nums) {
            if (count == 0) {
                candidate = num
            }
            if (candidate == num) {
                count++
            } else {
                count--
            }
        }

        return candidate
    }
}