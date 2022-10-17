package leetcode.two.sum

class HashMap : TwoSum {
    override fun twoSum(nums: IntArray, target: Int): IntArray {
        val map = mutableMapOf<Int, Int>()
        nums.forEachIndexed { index, it ->
            map[target - it]?.run { return intArrayOf(this, index) }
            map[it] = index
        }
        return intArrayOf()
    }
}