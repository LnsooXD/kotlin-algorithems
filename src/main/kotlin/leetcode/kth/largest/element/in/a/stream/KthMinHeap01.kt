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
            this.values[this.size++] = `val`
            this.ascend()
        } else if (`val` > this.values[0]) {
            this.values[0] = `val`
            this.descend()
        }
        return this.values[0]
    }

    private fun ascend() {
        var index = this.size - 1
        do {
            index = this.ascend(index)
        } while (index >= 0)
    }

    private fun descend() {
        var index = 0
        do {
            index = this.descend(index)
        } while (index >= 0)
    }

    private fun ascend(index: Int): Int {
        val parentIndex = (index + 1).ushr(1) - 1
        return if (parentIndex >= 0 && this.swap(parentIndex, index)) {
            parentIndex
        } else {
            -1
        }
    }

    private fun descend(parentIndex: Int): Int {
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