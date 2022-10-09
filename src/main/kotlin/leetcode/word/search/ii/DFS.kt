package leetcode.word.search.ii

class DFS : WordSearchI {
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
                    if (exists(board, word, 0, i, j, IntArray(board.size))) {
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
        usedChars: IntArray
    ): Boolean {
        val mask = 1.shl(by)
        val row = board[bx]
        if (usedChars[bx].and(mask) != 0 || word[ci] != row[by]) {
            return false
        }

        val nextCi = ci + 1
        if (nextCi >= word.size) {
            return true
        }

        usedChars[bx] = usedChars[bx].or(mask)

        val exists = (by + 1 < row.size && exists(board, word, nextCi, bx, by + 1, usedChars)) ||
                (by - 1 >= 0 && exists(board, word, nextCi, bx, by - 1, usedChars)) ||
                (bx + 1 < board.size && exists(board, word, nextCi, bx + 1, by, usedChars)) ||
                (bx - 1 >= 0 && exists(board, word, nextCi, bx - 1, by, usedChars))
        if (!exists) {
            usedChars[bx] = usedChars[bx].and(mask.inv())
        }
        return exists
    }

}