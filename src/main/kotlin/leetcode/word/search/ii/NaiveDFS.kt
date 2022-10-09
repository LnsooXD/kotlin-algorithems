package leetcode.word.search.ii

class NaiveDFS : WordSearchI {

    override fun findWords(board: Array<CharArray>, words: Array<String>): List<String> {
        val res = mutableListOf<String>()
        for (word in words) {
            if (exists(board, word.toCharArray())) {
                res.add(word)
            }
        }
        return res
    }

    private fun exists(board: Array<CharArray>, word: CharArray): Boolean {
        if (word.isEmpty()) {
            return true
        }
        val head = word[0]
        for (i in board.indices) {
            for (j in board[i].indices) {
                if (board[i][j] == head) {
                    if (exists(board, word, 0, i, j)) {
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
        by: Int
    ): Boolean {
        val row = board[bx]
        if (word[ci] != row[by]) {
            return false
        }

        val nextCi = ci + 1
        if (nextCi >= word.size) {
            return true
        }

        val tmp = row[by]
        row[by] = '@'

        var res = false

        for (i in 0 until 4) {
            val x = bx + dx[i]
            val y = by + dy[i]

            if (x >= 0 && x < board.size && y >= 0 && y < board[x].size) {
                if (exists(board, word, nextCi, x, y)) {
                    res = true
                    break
                }
            }
        }
        row[by] = tmp
        return res
    }

    companion object {
        private val dx = intArrayOf(0, 0, 1, -1)
        private val dy = intArrayOf(1, -1, 0, 0)
    }
}