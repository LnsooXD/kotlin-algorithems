package other.count.the.paths

import org.testng.annotations.Test

internal class CountThePathsTest {

    private val core = DP()

    @Test
    fun test() {
        val board = arrayOf(
            BooleanArray(8) { true },
            BooleanArray(8) { it != 2 && it != 6 },
            BooleanArray(8) { it != 4 },
            BooleanArray(8) { it != 0 && it != 2 && it != 5 },
            BooleanArray(8) { it != 2 },
            BooleanArray(8) { it != 3 && it != 4 && it != 6 },
            BooleanArray(8) { it != 1 && it != 5 },
            BooleanArray(8) { true }
        )

        val res = this.core.count(board)
        println(res)

    }
}