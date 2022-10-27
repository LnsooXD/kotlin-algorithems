package leetcode.sliding.window.maximum

// DATE 2022-10-27
class RudeDoublePointers : SlidingWindowMaximumI {

    override fun maxSlidingWindow(nums: IntArray, k: Int): IntArray {
        var hind = 0

        val kk = k - 1
        val res = IntArray(nums.size - kk)
        for (fore in nums.indices) {
            val key = fore - kk
            if (key > hind) {
                hind++
                for (i in hind + 1..fore) {
                    if (nums[i] > nums[hind]) {
                        hind = i
                    }
                }
            } else if (nums[fore] > nums[hind]) {
                hind = fore
            }
            if (key >= 0) {
                res[key] = nums[hind]
            }
        }
        return res
    }

}