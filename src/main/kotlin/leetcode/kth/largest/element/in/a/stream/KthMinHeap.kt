package leetcode.kth.largest.element.`in`.a.stream

import heap.MinHeap

class KthMinHeap(override val k: Int, override val nums: IntArray) : KthLargestI {
    private val heap = MinHeap(this.k + 1)

    init {
        nums.forEach(this::add)
    }

    override fun add(`val`: Int) = if (this.heap.size == this.k) {
        this.heap.offer(`val`)
        this.heap.poll()
        this.heap.peek()!!
    } else {
        this.heap.offer(`val`)
    }
}
