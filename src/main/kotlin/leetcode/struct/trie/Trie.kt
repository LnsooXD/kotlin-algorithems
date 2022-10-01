package leetcode.struct.trie

// https://www.bilibili.com/cheese/play/ep32682?csource=common_hp_history_null
// https://leetcode.cn/problems/implement-trie-prefix-tree/


class Trie : TrieI {

    private val children: Array<Trie?> = Array(256) { null }
    private var isEndOfWord = false

    override fun insert(word: String) {
        if (word.isEmpty()) {
            this.isEndOfWord = true
            return
        }
        val headCharCode = word[0].toInt()
        val child = this.children[headCharCode] ?: Trie()
        this.children[headCharCode] = child
        child.insert(word.substring(1))
    }

    override fun search(word: String): Boolean {
        if (word.isEmpty()) {
            return this.isEndOfWord
        }

        val child = this.children[word[0].toInt()] ?: return false
        return child.search(word.substring(1))
    }

    override fun startsWith(prefix: String): Boolean {
        if (prefix.isEmpty()) {
            return true
        }

        val headChar = prefix[0]
        val child = this.children[headChar.toInt()] ?: return false
        return child.startsWith(prefix.substring(1))
    }

}