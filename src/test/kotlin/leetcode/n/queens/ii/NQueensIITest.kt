package leetcode.n.queens.ii

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class NQueensIITest {

    private val core = DFSWithBites()

    @Test
    fun test() {
        val n = 4
        val res = this.core.totalNQueens(n)
        assertThat(res).isEqualTo(2)
    }
}