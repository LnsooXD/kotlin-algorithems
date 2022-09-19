package leetcode

import java.util.*


// https://leetcode.cn/problems/sliding-window-maximum/

class SlidingWindowMaximum {

    fun maxSlidingWindow(nums: IntArray, k: Int): IntArray {
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

    fun maxSlidingWindowPriorityQueue(nums: IntArray, k: Int): IntArray {
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
                while(queue.peek().index < minIndex) {
                    // 从队列中移除不属于滑动窗口中对最大值，那么剩下的最大值一定是窗口内对
                    queue.poll()
                }
                res[item.index - kk] = queue.peek().value
            }
        }
        return res
    }

}