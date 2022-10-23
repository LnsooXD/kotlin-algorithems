package heap

class MinHeap(capacity: Int) {

    var size = 0
        private set

    private var values = IntArray(capacity)

    fun offer(value: Int): Int {
        this.expandIfNeeded()
        this.values[this.size] = value
        this.size++
        this.ascend()
        return this.values[0]
    }

    fun peek() = if (this.size <= 0) null else this.values[0]

    fun poll(): Int? {
        if (this.size == 0) {
            return null
        }
        val min = this.values[0]
        this.values[0] = this.values[this.size - 1]
        this.size--
        this.descend()
        this.trimIfNeeded()
        return min
    }

    fun enqueue(value: Int): Int {
        if (this.size <= 0 || value < this.values[0]) {
            return this.values[0]
        }
        this.values[0] = value
        this.descend()
        return this.values[0]
    }

    private fun descend() {
        var index = 0
        do {
            index = descend(index)
        } while (index >= 0)
    }

    private fun ascend() {
        var index = this.size - 1
        do {
            index = this.ascend(index)
        } while (index >= 0)
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

    private fun ascend(index: Int): Int {
        val parentIndex = (index + 1).ushr(1) - 1
        return if (parentIndex >= 0 && this.swap(parentIndex, index)) {
            parentIndex
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

    private fun expandIfNeeded() {
        if (this.size >= values.size) {
            val newValues = IntArray(values.size shl 1)
            System.arraycopy(values, 0, newValues, 0, this.size)
            this.values = newValues
        }
    }

    private fun trimIfNeeded() {
        val targetSize = values.size ushr 1
        if (this.size <= targetSize) {
            val newValues = IntArray(targetSize)
            System.arraycopy(values, 0, newValues, 0, this.size)
            this.values = newValues
        }
    }

}