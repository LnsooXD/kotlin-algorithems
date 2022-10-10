package leetcode.word.search

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class WordSearchTest {

    private val core = DFS()

    @Test
    fun test01() {
        val board = arrayOf(
            charArrayOf('A', 'B', 'C', 'E'),
            charArrayOf('S', 'F', 'C', 'S'),
            charArrayOf('A', 'D', 'E', 'E')
        )
        val word = "ABCCED"

        val res = this.core.exist(board, word)
        assertThat(res).isTrue()
    }
}