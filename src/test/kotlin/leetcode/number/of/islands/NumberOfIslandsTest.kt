package leetcode.number.of.islands

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertTimeoutPreemptively
import java.time.Duration

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

    @Test
    fun test02() {
        val grid = arrayOf(
            charArrayOf('1', '1', '0', '0', '0'),
            charArrayOf('1', '1', '0', '0', '0'),
            charArrayOf('0', '0', '1', '0', '0'),
            charArrayOf('0', '0', '0', '1', '1')
        )

        val res = this.core.numIslands(grid)
        assertThat(res).isEqualTo(3)
    }

    @Test
    fun test03() {
        assertTimeoutPreemptively(Duration.ofSeconds(10)) {
            val grid = arrayOf(
                charArrayOf('1','1','1','1','1','0','1','1','1','1','1','1','1','1','1','0','1','0','1','1'),
                charArrayOf('0','1','1','1','1','1','1','1','1','1','1','1','1','0','1','1','1','1','1','0'),
                charArrayOf('1','0','1','1','1','0','0','1','1','0','1','1','1','1','1','1','1','1','1','1'),
                charArrayOf('1','1','1','1','0','1','1','1','1','1','1','1','1','1','1','1','1','1','1','1'),
                charArrayOf('1','0','0','1','1','1','1','1','1','1','1','1','1','1','1','1','1','1','1','1'),
                charArrayOf('1','0','1','1','1','1','1','1','0','1','1','1','0','1','1','1','0','1','1','1'),
                charArrayOf('0','1','1','1','1','1','1','1','1','1','1','1','0','1','1','0','1','1','1','1'),
                charArrayOf('1','1','1','1','1','1','1','1','1','1','1','1','0','1','1','1','1','0','1','1'),
                charArrayOf('1','1','1','1','1','1','1','1','1','1','0','1','1','1','1','1','1','1','1','1'),
                charArrayOf('1','1','1','1','1','1','1','1','1','1','1','1','1','1','1','1','1','1','1','1'),
                charArrayOf('0','1','1','1','1','1','1','1','0','1','1','1','1','1','1','1','1','1','1','1'),
                charArrayOf('1','1','1','1','1','1','1','1','1','1','1','1','1','1','1','1','1','1','1','1'),
                charArrayOf('1','1','1','1','1','1','1','1','1','1','1','1','1','1','1','1','1','1','1','1'),
                charArrayOf('1','1','1','1','1','0','1','1','1','1','1','1','1','0','1','1','1','1','1','1'),
                charArrayOf('1','0','1','1','1','1','1','0','1','1','1','0','1','1','1','1','0','1','1','1'),
                charArrayOf('1','1','1','1','1','1','1','1','1','1','1','1','0','1','1','1','1','1','1','0'),
                charArrayOf('1','1','1','1','1','1','1','1','1','1','1','1','1','0','1','1','1','1','0','0'),
                charArrayOf('1','1','1','1','1','1','1','1','1','1','1','1','1','1','1','1','1','1','1','1'),
                charArrayOf('1','1','1','1','1','1','1','1','1','1','1','1','1','1','1','1','1','1','1','1'),
                charArrayOf('1','1','1','1','1','1','1','1','1','1','1','1','1','1','1','1','1','1','1','1')
            )
            val res = this.core.numIslands(grid)
            assertThat(res).isEqualTo(1)
        }
    }

}