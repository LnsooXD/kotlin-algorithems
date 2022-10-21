package leetcode.kth.largest.element.`in`.a.stream

import java.util.*


class KthLargestPriorityQueue(override val k: Int, override val nums: IntArray) : KthLargestI {
    private val queue: Queue<Int>

    init {
        this.queue = PriorityQueue(k + 1)
        for (num in nums) {
            this.add(num)
        }
    }

    override fun add(`val`: Int): Int {
        this.queue.offer(`val`)
        if (this.queue.size > this.k) {
            this.queue.poll()
        }
        return this.queue.peek()
    }
}