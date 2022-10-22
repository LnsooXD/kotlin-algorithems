package leetcode.sliding.window.maximum

import java.util.*

class SlidingWindowMaximumDeque : SlidingWindowMaximumI {
    override fun maxSlidingWindow(nums: IntArray, k: Int): IntArray {
        if (nums.isEmpty()) {
            return intArrayOf()
        }

        val kk = k - 1
        val queue: Deque<Int> = ArrayDeque()
        val res = IntArray(nums.size - kk)

        for ((index, value) in nums.withIndex()) {
            while (!queue.isEmpty() && nums[queue.peekFirst()] <= value) {
                queue.pollFirst()
            }
            queue.offerFirst(index)
            if (index >= kk) {
                val last = queue.peekLast()
                res[index - kk] = nums[last]
                if (index - last >= kk) {
                    queue.pollLast()
                }
            }
        }
        return res
    }
}