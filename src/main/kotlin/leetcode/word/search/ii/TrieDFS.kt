package leetcode.word.search.ii

class TrieDFS : WordSearchI {

    override fun findWords(board: Array<CharArray>, words: Array<String>): List<String> {
        val root = Trie()
        for (word in words) {
            root.add(word)
        }

        val res = mutableListOf<String>()

        for (i in board.indices) {
            for (j in board[i].indices) {
                val child = root.getChild(board[i][j]) ?: continue
                findWords(board, i, j, child, res)
            }
        }
        return res
    }

    private fun findWords(board: Array<CharArray>, bx: Int, by: Int, node: Trie, res: MutableList<String>) {
        node.word?.let {
            res.add(it)
            node.word = null
        }
        val tmp = board[bx][by]
        board[bx][by] = 'z' + 1
        for (i in 0 until 4) {
            val x = bx + dx[i]
            val y = by + dy[i]
            if (x >= 0 && x < board.size && y >= 0 && y < board[x].size) {
                val child = node.getChild(board[x][y]) ?: continue
                findWords(board, x, y, child, res)
            }
        }
        board[bx][by] = tmp
    }

    private class Trie {
        private val children = Array<Trie?>(27) { null }
        var word: String? = null

        fun add(word: String) {
            var node = this
            for (c in word) {
                node = node.getAndSetChildDefault(c)
            }
            node.word = word
        }

        fun getChild(c: Char) = this.children[c - 'a']

        private fun getAndSetChildDefault(c: Char): Trie {
            val key = c - 'a'
            val child = this.children[key] ?: Trie().also {
                this.children[key] = it
            }
            return child
        }
    }

    companion object {
        private val dx = intArrayOf(0, 0, 1, -1)
        private val dy = intArrayOf(1, -1, 0, 0)
    }
}