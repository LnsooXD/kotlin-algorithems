package leetcode.sliding.window.maximum

import java.util.*

class SlidingWindowMaximumPriorityQueue : SlidingWindowMaximumI {

    override fun maxSlidingWindow(nums: IntArray, k: Int): IntArray {
        if (nums.isEmpty()) {
            return intArrayOf()
        }

        val kk = k - 1
        val res = IntArray(nums.size - kk)
        val queue = PriorityQueue<IndexedValue<Int>>(k) { a, b -> b.value - a.value }

        for (item in nums.withIndex()) {
            queue.offer(item)
            if (item.index >= kk) {
                val minIndex = item.index - kk
                while (queue.peek().index < minIndex) {
                    // 从队列中移除不属于滑动窗口中对最大值，那么剩下的最大值一定是窗口内对
                    queue.poll()
                }
                res[item.index - kk] = queue.peek().value
            }
        }
        return res
    }

}