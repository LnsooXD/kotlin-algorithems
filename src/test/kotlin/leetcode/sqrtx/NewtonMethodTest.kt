package leetcode.sqrtx

import org.assertj.core.api.Assertions
import org.testng.annotations.Test

internal class NewtonMethodTest {
    private val core = NewtonMethod()

    @Test
    fun test01() {
        val x = 9.0
        val res = this.core.mySqrt(x)
        Assertions.assertThat(this.square(res)).isEqualTo(x.toInt())
    }

    @Test
    fun test02() {
        val x = 5.0
        val res = this.core.mySqrt(x)
        Assertions.assertThat(this.square(res)).isEqualTo(x.toInt())
    }

    private fun square(sqrt: Double) = (sqrt * sqrt + 0.5).toInt()
}