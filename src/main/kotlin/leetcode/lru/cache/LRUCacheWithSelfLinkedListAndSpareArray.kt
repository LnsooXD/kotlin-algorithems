package leetcode.lru.cache

class LRUCacheWithSelfLinkedListAndSpareArray(private val capacity: Int) : LRUCacheI {

    private val nodeCache = NodeCache(capacity)

    override fun get(key: Int): Int {
        var node = this.head.next
        if (node.key == key) {
            return node.value
        }
        node = this.find(key)
        if (node.key == key) {
            this.moveToFirst(node)
        }
        return node.value
    }

    override fun put(key: Int, value: Int) {
        var node = this.head.next
        if (node.key == key) {
            node.value = value
            return
        }

        node = this.find(key)
        if (node.key == key) {
            node.value = value
            this.moveToFirst(node)
        } else {
            val first = Node(key, value)
            this.addFirst(first)
            this.cache(first)
        }
    }

    private val head = Node(-1, -1)
    private val tail = Node(-1, -1)
    private var size = 0

    init {
        head.prev = head
        head.next = tail

        tail.prev = head
        tail.next = tail
    }

    private fun find(key: Int) = this.nodeCache[key] ?: this.tail

    private fun moveToFirst(node: Node) {
        this.remove(node)
        this.addFirst(node)
    }

    private fun addFirst(node: Node) {
        this.removeLastIfNeeded()

        this.head.next.prev = node

        node.next = this.head.next
        node.prev = this.head

        this.head.next = node

        this.size++
    }

    private fun remove(node: Node) {
        node.prev.next = node.next
        node.next.prev = node.prev
        this.size--
    }

    private fun cache(node: Node) {
        this.nodeCache[node.key] = node
    }

    private fun removeFromCache(node: Node) {
        this.nodeCache.remove(node)
    }

    private fun removeLastIfNeeded() {
        if (this.size >= this.capacity) {
            val last = this.tail.prev
            this.remove(last)
            this.removeFromCache(last)
        }
    }

    private class Node(val key: Int, var value: Int) {
        lateinit var prev: Node
        lateinit var next: Node
    }

    private class NodeCache(capacity: Int) {
        private val keys = IntArray(capacity) { -1 }
        private val values = Array<Node?>(capacity) { null }
        private var size = 0

        operator fun set(key: Int, node: Node) {
            if (size <= 0 || key > keys[size - 1]) {
                keys[this.size] = key
                values[this.size] = node
                this.size++
                return
            }

            val index = binarySearch(keys, size, key)
            if (index >= 0) {
                values[index] = node
            } else {
                val insertIndex = index.inv()
                System.arraycopy(keys, insertIndex, keys, insertIndex + 1, size - insertIndex)
                System.arraycopy(values, insertIndex, values, insertIndex + 1, size - insertIndex)

                keys[insertIndex] = key
                values[insertIndex] = node

                this.size++
            }

        }

        operator fun get(key: Int): Node? {
            if (size <= 0 || key < keys[0] || key > keys[size - 1]) {
                return null
            }
            return binarySearch(keys, size, key).let {
                if (it >= 0) values[it] else null
            }
        }

        fun remove(node: Node) {
            val index = binarySearch(keys, size, node.key)
            if (index >= 0) {
                System.arraycopy(keys, index + 1, keys, index, size - index - 1)
                System.arraycopy(values, index + 1, values, index, size - index - 1)
                this.size--
            }
        }

        companion object {
            fun binarySearch(array: IntArray, size: Int, value: Int): Int {
                var low = 0
                var high = size - 1
                if (array[low] == value) {
                    return low
                } else if (array[high] == value) {
                    return high
                }
                while (low <= high) {
                    val mid = (low + high) ushr 1
                    val midVal = array[mid]
                    if (midVal < value) {
                        low = mid + 1
                    } else if (midVal > value) {
                        high = mid - 1
                    } else {
                        return mid // value found
                    }
                }
                return low.inv() // value not present
            }
        }
    }
}