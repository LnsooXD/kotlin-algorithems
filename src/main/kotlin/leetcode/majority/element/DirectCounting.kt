package leetcode.majority.element

class DirectCounting : MajorityElement {

    override fun majorityElement(nums: IntArray): Int {
        val map = hashMapOf<Int, Int>()
        val half = nums.size / 2
        for (num in nums) {
            val count = (map[num] ?: 0) + 1
            if (count > half) {
                return num
            }
            map[num] = count
        }
        return nums[0]
    }

}