package leetcode.lru.cache

import java.util.*

class LRUCache(val capacity: Int) : LRUCacheI {

    private val cache = LinkedList<Node>()

    override fun get(key: Int): Int {
        val node = this.cache.peekFirst()
        if (node != null && key == node.key) {
            return node.value
        }

        var resNode: Node? = null
        var index = -1

        for (n in this.cache) {
            index++
            if (n.key == key) {
                resNode = n
                break
            }
        }

        if (resNode == null) {
            return -1
        }

        this.cache.removeAt(index)
        this.cache.offerFirst(resNode)
        return resNode.value
    }

    override fun put(key: Int, value: Int) {
        val node = this.cache.peekFirst()
        if (node != null && key == node.key) {
            node.value = value
            return
        }

        var resNode: Node? = null
        var index = -1

        for (n in this.cache) {
            index++
            if (n.key == key) {
                resNode = n
                break
            }
        }

        if (resNode != null) {
            resNode.value = value
            this.cache.removeAt(index)
        } else {
            resNode = Node(key, value)
        }
        this.cache.offerFirst(resNode)

        if (this.cache.size > this.capacity) {
            this.cache.pollLast()
        }
    }

    private data class Node(val key: Int, var value: Int)
}