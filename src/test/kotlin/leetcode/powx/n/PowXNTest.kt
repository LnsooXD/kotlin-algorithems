package leetcode.powx.n

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test
import kotlin.math.pow

internal class PowXNTest {

    private val cores =
        arrayOf(
            DirectMultiply(),
            RecursiveBinDiv(),
            RecursiveBinDiv1(),
            LoopedBinDiv(),
            /*RecursiveBinDiv2(),*/
            BinaryLoop()
        )
    private val dataSet = arrayOf(
        TestData(
            x = 8.0,
            n = 1
        ),
        TestData(
            x = 2.0,
            n = 10
        ),
        TestData(
            x = 2.0,
            n = -10
        ),
        TestData(
            x = 2.0,
            n = -20
        ),
        TestData(
            x = 2.0,
            n = Int.MIN_VALUE
        ),
        TestData(
            x = 2.0,
            n = Int.MAX_VALUE
        )
    )

    @Test
    fun test() {
        for (data in dataSet) {
            this.testPowX(data)
        }
    }

    private fun testPowX(data: TestData) {
        for (core in this.cores) {
            assertThat(core.myPow(data.x, data.n))
                .describedAs("${core.javaClass.simpleName}.myPow(x: ${data.x}, n: ${data.n})")
                .isEqualTo(data.x.pow(data.n.toDouble()))
        }
    }

    private data class TestData(
        val x: Double,
        val n: Int
    )
}