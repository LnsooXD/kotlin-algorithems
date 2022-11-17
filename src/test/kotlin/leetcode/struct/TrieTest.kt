package leetcode.struct

import leetcode.struct.trie.Trie
import org.assertj.core.api.Assertions.assertThat
import org.testng.annotations.Test

internal class TrieTest {

    @Test
    fun testInsert() {
        val root = Trie()
        root.insert("xxxx")
        root.insert("xxxxaa")

        assertThat( root.search("xxxx")).isTrue()
        assertThat( root.search("xxx")).isFalse()
        assertThat( root.startsWith("xxx")).isTrue()

        assertThat( root.search("xxxxaa")).isTrue()
        assertThat( root.search("xxxxa")).isFalse()
        assertThat( root.startsWith("xxxxa")).isTrue()
    }
}