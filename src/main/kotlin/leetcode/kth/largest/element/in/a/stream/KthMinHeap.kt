package leetcode.kth.largest.element.`in`.a.stream

import heap.MinHeap

class KthMinHeap(override val k: Int, override val nums: IntArray) : KthLargestI {
    private val heap = MinHeap(this.k)

    init {
        nums.forEach(this::add)
    }

    override fun add(`val`: Int): Int {
        return if (this.heap.size == this.k) {
            this.heap.balance(`val`)
        } else {
            this.heap.offer(`val`)
        }
    }
}
