package leetcode.lru.cache

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class LRUCacheITest {

    @Test
    fun test01() {
        val lRUCache = this.newCache(2)
        lRUCache.put(1, 1)                           // cache is {1=1}
        lRUCache.put(2, 2)                           // cache is {1=1, 2=2}
        assertThat(lRUCache.get(1)).isEqualTo(1)     // return 1
        lRUCache.put(3, 3)                           // LRU key was 2, evicts key 2, cache is {1=1, 3=3}
        assertThat(lRUCache.get(2)).isEqualTo(-1)    // returns -1 (not found)
        lRUCache.put(4, 4)                           // LRU key was 1, evicts key 1, cache is {4=4, 3=3}
        assertThat(lRUCache.get(1)).isEqualTo(-1)    // return -1 (not found)
        assertThat(lRUCache.get(3)).isEqualTo(3)     // return 3
        assertThat(lRUCache.get(4)).isEqualTo(4)     // return 4
    }

    @Test
    fun test02() {
        val lRUCache = this.newCache(2)
        lRUCache.put(2, 1)
        lRUCache.put(2, 2)
        assertThat(lRUCache.get(2)).isEqualTo(2)
        lRUCache.put(1, 1)
        lRUCache.put(4, 1)
        assertThat(lRUCache.get(2)).isEqualTo(-1)
    }

    @Test
    fun test03() {
        val lRUCache = this.newCache(3)
        lRUCache.put(2, 1)
        lRUCache.put(2, 2)
        assertThat(lRUCache.get(2)).isEqualTo(2)
        lRUCache.put(1, 1)
        lRUCache.put(4, 1)
        lRUCache.put(5, 1)
        assertThat(lRUCache.get(2)).isEqualTo(-1)
    }

    private fun newCache(capacity: Int): LRUCacheI {
        return LRUCacheWithLinkedHashMap(capacity)
    }
}