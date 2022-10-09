package leetcode.struct.trie

class HashTrie : TrieI {

    private val children = HashMap<Char, HashTrie>()
    private var isEndOfWord = false

    override fun insert(word: String) {
        if (word.isEmpty()) {
            return
        }

        var node = this
        for (c in word) {
            node = node.children[c] ?: HashTrie().apply {
                node.children[c] = this
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

    private fun searchPrefix(prefix: String): HashTrie? {
        if (prefix.isEmpty()) {
            return this
        }
        var node = this
        for (c in prefix) {
            node = node.children[c] ?: return null
        }
        return node
    }
}