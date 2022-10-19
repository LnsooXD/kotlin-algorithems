package leetcode.lru.cache

class LRUCacheWithSelfLinkedList(private val capacity: Int) : LRUCacheI {

    private val nodeCache = HashMap<Int, Node>()

    override fun get(key: Int): Int {
        val node = this.find(key)
        if (node.key == key) {
            this.moveToFirst(node)
        }
        return node.value
    }

    override fun put(key: Int, value: Int) {
        val node = this.find(key)
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

    private fun find(key: Int): Node {
        return this.nodeCache[key] ?: this.tail
    }

    private fun moveToFirst(node: Node) {
        if (this.head.next != node) {
            this.remove(node)
            this.addFirst(node)
        }
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
        node.cached = true
    }

    private fun removeFromCache(node: Node) {
        this.nodeCache.remove(node.key)
        node.cached = false
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
        var cached = false
    }
}