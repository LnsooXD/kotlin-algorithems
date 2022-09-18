package leetcode

import java.util.*

// https://leetcode.cn/problems/kth-largest-element-in-a-stream/

class KthLargestElementInAStream {

    class KthLargest {

        private val k: Int
        private val queue: Queue<Int>

        constructor(k: Int, nums: IntArray) {
            this.k = k
            this.queue = PriorityQueue(k)
            for (num in nums) {
                this.add(num)
            }
        }

        fun add(`val`: Int): Int {
            this.queue.offer(`val`)
            if (this.queue.size > this.k) {
                this.queue.poll()
            }
            return this.queue.peek()
        }

    }
}