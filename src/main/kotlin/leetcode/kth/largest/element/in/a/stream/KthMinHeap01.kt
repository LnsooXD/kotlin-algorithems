package leetcode.kth.largest.element.`in`.a.stream

class KthMinHeap01(override val k: Int, override val nums: IntArray) : KthLargestI {

    private var size = 0
    private val values = IntArray(k)

    init {
        nums.forEach(this::add)
    }

    override fun add(`val`: Int): Int {
        if (this.size <= 0) {
            this.values[0] = `val`
            this.size++
        } else if (this.size < this.values.size) {

            var index: Int
            var parentIndex = this.size

            this.values[parentIndex] = `val`
            this.size++

            do {
                index = parentIndex
                parentIndex = (index + 1).ushr(1) - 1
            } while (parentIndex >= 0 && swap(parentIndex, index))

        } else if (`val` > this.values[0]) {
            this.values[0] = `val`
            var index = 0
            do {
                index = this.maintain(index)
            } while (index >= 0)
        }
        return this.values[0]
    }

    private fun maintain(parentIndex: Int): Int {
        var targetIndex = parentIndex
        val index = parentIndex.shl(1) + 1
        if (index < this.size) {
            if (this.values[index] < this.values[parentIndex]) {
                targetIndex = index
            }
            if (index + 1 < this.size && this.values[index + 1] < this.values[index]) {
                targetIndex = index + 1
            }
        }
        return if (targetIndex != parentIndex && this.swap(parentIndex, targetIndex)) {
            targetIndex
        } else {
            -1
        }
    }

    private fun swap(smaller: Int, bigger: Int): Boolean {
        val tmp = this.values[smaller]
        if (tmp <= this.values[bigger]) {
            return false
        }
        this.values[smaller] = this.values[bigger]
        this.values[bigger] = tmp
        return true
    }

}