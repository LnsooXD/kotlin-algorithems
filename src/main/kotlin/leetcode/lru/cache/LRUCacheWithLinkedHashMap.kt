package leetcode.lru.cache

class LRUCacheWithLinkedHashMap(capacity: Int) : LRUCacheI {

    private val nodes = object : LinkedHashMap<Int, Int>(capacity, 0.75f, true) {
        override fun removeEldestEntry(eldest: MutableMap.MutableEntry<Int, Int>?) = size > capacity
    }

    override fun get(key: Int) = nodes[key] ?: -1

    override fun put(key: Int, value: Int) {
        nodes[key] = value
    }

}