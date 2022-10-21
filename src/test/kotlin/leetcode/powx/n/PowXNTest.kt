package leetcode.powx.n

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test
import kotlin.math.pow

internal class PowXNTest {

    private val cores = arrayOf(DirectMultiply(), RecursiveBinDiv(), RecursiveBinDiv1(), LoopedBinDiv(), PowXN01())
    private val dataSet = arrayOf(
        TestData(
            x = 2.0,
            n = 10,
            expected = 1024.0
        ),
        TestData(
            x = 2.0,
            n = -10,
            expected = 2.0.pow(-10)
        ),
        TestData(
            x = 2.0,
            n = -20,
            expected = 2.0.pow(-20)
        ),
        TestData(
            x = 2.0,
            n = -2147483648,
            expected = 0.0
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
                .isEqualTo(data.expected)
        }
    }

    private data class TestData(
        val x: Double,
        val n: Int,
        val expected: Double
    )
}