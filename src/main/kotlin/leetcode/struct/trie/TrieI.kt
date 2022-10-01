package leetcode.struct.trie

// https://www.bilibili.com/cheese/play/ep32682?csource=common_hp_history_null
// https://leetcode.cn/problems/implement-trie-prefix-tree/

interface TrieI {
    fun insert(word: String)
    fun search(word: String): Boolean
    fun startsWith(prefix: String): Boolean
}