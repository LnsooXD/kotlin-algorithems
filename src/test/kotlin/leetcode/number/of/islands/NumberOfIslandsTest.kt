package leetcode.number.of.islands

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class NumberOfIslandsTest {

    private val core = Union01()

    @Test
    fun test01() {
        val grid = arrayOf(
            charArrayOf('1', '1', '1', '1', '0'),
            charArrayOf('1', '1', '0', '1', '0'),
            charArrayOf('1', '1', '0', '0', '0'),
            charArrayOf('0', '0', '0', '0', '0')
        )

        val res = this.core.numIslands(grid)
        assertThat(res).isEqualTo(1)
    }
}