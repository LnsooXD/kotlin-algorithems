package leetcode.word.search

class DFS : WordSearchI {

    override fun exist(board: Array<CharArray>, word: String): Boolean {
        if (word.isEmpty()) {
            return true
        }
        for (x in board.indices) {
            for (y in board[x].indices) {
                if (exist(board, word, x, y, 0)) {
                    return true
                }
            }
        }
        return false
    }

    private fun exist(board: Array<CharArray>, word: String, x: Int, y: Int, ci: Int): Boolean {
        if (board[x][y] != word[ci]) {
            return false
        }

        val nextCi = ci + 1
        if (nextCi >= word.length) {
            return true
        }

        val tmp = board[x][y]
        board[x][y] = '@'

        var exists = false

        for (i in 0 until 4) {
            val nextX = x + DIRECTIONS_X[i]
            val nextY = y + DIRECTIONS_Y[i]
            if (nextX >= 0 && nextX < board.size && nextY >= 0 && nextY < board[nextX].size) {
                exists = exist(board, word, nextX, nextY, nextCi)
                if (exists) {
                    break
                }
            }
        }
        board[x][y] = tmp
        return exists
    }


    companion object {
        private val DIRECTIONS_X = arrayOf(0, 0, 1, -1)
        private val DIRECTIONS_Y = arrayOf(1, -1, 0, 0)
    }

}