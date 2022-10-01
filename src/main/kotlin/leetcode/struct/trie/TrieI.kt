package leetcode.struct.trie

interface TrieI {
    fun insert(word: String)
    fun search(word: String): Boolean
    fun startsWith(prefix: String): Boolean
}