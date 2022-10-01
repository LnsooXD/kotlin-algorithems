package leetcode.struct

import leetcode.struct.trie.Trie
import org.junit.jupiter.api.Test

internal class TrieTest {

    @Test
    fun testInsert() {
        val root = Trie()
        root.insert("xxxx")
        root.insert("xxxxaa")

        var res = root.search("xxxx")
        println("res: $res")
    }
}