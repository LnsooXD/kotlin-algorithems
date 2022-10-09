package leetcode.word.search.ii

class DFS : WordSearchI {
    override fun findWords(board: Array<CharArray>, words: Array<String>) =
        words.map { it.toCharArray() }.filter { exists(board, it) }.map { String(it) }

    private fun exists(board: Array<CharArray>, word: CharArray): Boolean {
        if (word.isEmpty()) {
            return true
        }
        val head = word[0]
        for (i in board.indices) {
            for (j in board[i].indices) {
                if (board[i][j] == head) {
                    if (exists(board, word, 0, i, j, mutableSetOf())) {
                        return true
                    }
                }
            }
        }
        return false
    }

    private fun exists(
        board: Array<CharArray>,
        word: CharArray,
        ci: Int,
        bx: Int,
        by: Int,
        usedChars: MutableSet<String>
    ): Boolean {
        if (ci >= word.size) {
            return true
        }
        if (bx < 0 || by < 0 || bx >= board.size || by >= board[bx].size) {
            return false
        }

        val key = "$bx-$by"

        if (usedChars.contains(key) || word[ci] != board[bx][by]) {
            return false
        }
        usedChars.add(key)

        val exists = exists(board, word, ci + 1, bx, by + 1, usedChars) ||
                exists(board, word, ci + 1, bx, by - 1, usedChars) ||
                exists(board, word, ci + 1, bx + 1, by, usedChars) ||
                exists(board, word, ci + 1, bx - 1, by, usedChars)

        if (!exists) {
            usedChars.remove(key)
        }
        return exists
    }

}