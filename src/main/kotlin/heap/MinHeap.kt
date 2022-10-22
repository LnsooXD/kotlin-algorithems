package heap

class MinHeap(capacity: Int) {

    var size = 0
        private set

    private var values = IntArray(capacity)

    fun offer(value: Int): Int {
        this.expandIfNeeded()
        this.values[this.size] = value

        var index = this.size
        var parentIndex = ((index + 1) ushr 1) - 1
        while (this.swap(index, parentIndex)) {
            index = parentIndex
            parentIndex = ((index + 1) ushr 1) - 1
        }
        this.size++
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
        while (true) {
            val baseIndex = index shl 1
            val count = baseIndex.let { it + 1..it + 2 }
                .map { this.swap(it, index) }
                .map { if (it) 1 else 0 }
                .reduce { a, b -> a + b }

            if (count <= 0) {
                break
            }
            index = baseIndex + count
        }
    }

    private fun swap(smaller: Int, bigger: Int): Boolean {
        if (smaller >= size || bigger >= size || smaller < 0 || bigger < 0) {
            return false
        }
        val tmp = this.values[smaller]
        if (tmp >= this.values[bigger]) {
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

}