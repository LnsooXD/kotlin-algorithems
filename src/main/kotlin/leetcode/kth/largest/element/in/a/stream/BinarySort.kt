package leetcode.kth.largest.element.`in`.a.stream

class BinarySort(override val k: Int, override val nums: IntArray) : KthLargestI {

    private val topk = IntArray(this.k + 1)
    private var size = 0

    init {
        this.nums.forEach { this.add(it) }
    }

    override fun add(`val`: Int): Int {
        val index = this.binarySearch(`val`)
        System.arraycopy(this.topk, index, this.topk, index + 1, this.size - index)
        this.topk[index] = `val`
        this.size++

        if (this.size > this.k) {
            System.arraycopy(this.topk, this.size - this.k, this.topk, 0, this.k)
            this.size = this.k
        }

        return this.topk[0]
    }

    private fun binarySearch(value: Int): Int {
        var low = 0
        var high = this.size - 1
        while (low <= high) {
            val mid = (low + high) ushr 1
            val midValue = this.topk[mid]
            if (midValue > value) {
                high = mid - 1
            } else {
                low = mid + 1
            }
        }
        return low
    }

}