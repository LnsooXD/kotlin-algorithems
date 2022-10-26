package leetcode.triangle

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class TriangleTest {

    private val core = DFS02()

    @Test
    fun test() {
        val triangle = listOf(
            listOf(2),
            listOf(3, 4),
            listOf(6, 5, 7),
            listOf(4, 1, 8, 3)
        )

        val res = this.core.minimumTotal(triangle)
        assertThat(res).isEqualTo(11)
    }
}