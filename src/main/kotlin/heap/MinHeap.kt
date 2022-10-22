package heap

class MinHeap(capacity: Int) {

    var size = 0
        private set

    var values = IntArray(capacity)
        private set

    fun offer(value: Int): Int {
        this.expandIfNeeded()

        var index: Int
        var parentIndex = this.size

        this.values[parentIndex] = value
        this.size++

        do {
            index = parentIndex
            parentIndex = ((index + 1) ushr 1) - 1
        } while (this.swap(index, parentIndex))

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
        this.maintain()
        return min
    }

    fun balance(value: Int): Int {
        if (this.size <= 0 || value < this.values[0]) {
            return this.values[0]
        }
        this.values[0] = value
        this.maintain()
        return this.values[0]
    }

    private fun maintain() {
        var index = 0
        do {
            index = maintain(index)
        } while (index >= 0)
    }

    private fun swap(bigger: Int, smaller: Int): Boolean {
        if (bigger >= size || smaller >= size || bigger < 0 || smaller < 0) {
            return false
        }
        val tmp = this.values[bigger]
        if (tmp >= this.values[smaller]) {
            return false
        }
        this.values[bigger] = this.values[smaller]
        this.values[smaller] = tmp
        return true
    }

    private fun maintain(parentIndex: Int): Int {
        var targetIndex = parentIndex
        val index = (parentIndex shl 1) + 1

        if (index < this.size) {
            if (this.values[index] < this.values[parentIndex]) {
                targetIndex = index
            }
            if (index + 1 < this.size && this.values[index + 1] < this.values[index]) {
                targetIndex = index + 1
            }
        }
        return if (targetIndex != parentIndex && swap(targetIndex, parentIndex)) {
            targetIndex
        } else {
            -1
        }
    }

    private fun expandIfNeeded() {
        if (this.size >= values.size) {
            val newValues = IntArray(values.size shl 1)
            System.arraycopy(values, 0, newValues, 0, this.size)
            this.values = newValues
        }
    }

}