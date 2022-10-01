package leetcode.struct.trie

class Trie : TrieI {

    private val children: Array<Trie?> = Array(256) { null }
    private var isEndOfWord = false

    override fun insert(word: String) {
        if (word.isEmpty()) {
            return
        }

        var node = this
        for (c in word) {
            val key = c.toInt()
            node = node.children[key] ?: Trie().apply {
                node.children[key] = this
            }
        }
        node.isEndOfWord = true
    }

    override fun search(word: String): Boolean {
        if (word.isEmpty()) {
            return true
        }
        return searchPrefix(word)?.isEndOfWord ?: false
    }

    override fun startsWith(prefix: String): Boolean {
        if (prefix.isEmpty()) {
            return true
        }
        return searchPrefix(prefix) != null
    }

    private fun searchPrefix(prefix: String): Trie? {
        if (prefix.isEmpty()) {
            return this
        }
        var node = this
        for (c in prefix) {
            node = node.children[c.toInt()] ?: return null
        }
        return node
    }
}