package leetcode.sqrtx

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class BinaryTest {

    private val core = BinaryDouble()
    private val intCore = BinaryInt()

    @Test
    fun test01() {
        val x = 9.0
        val res = this.core.mySqrt(x)
        assertThat(this.square(res)).isEqualTo(x.toInt())
    }

    @Test
    fun test02() {
        val x = 5.0
        val res = this.core.mySqrt(x)
        assertThat(this.square(res)).isEqualTo(x.toInt())
    }

    @Test
    fun testInt01() {
        val x = 5
        val res = this.intCore.mySqrt(x)
        assertThat(res).isEqualTo(2)
    }

    @Test
    fun testInt02() {
        val x = 8
        val res = this.intCore.mySqrt(x)
        assertThat(res).isEqualTo(2)
    }

    @Test
    fun testInt03() {
        val x = 9
        val res = this.intCore.mySqrt(x)
        assertThat(res).isEqualTo(3)
    }

    @Test
    fun testInt04() {
        val x = 2147395599
        val res = this.intCore.mySqrt(x)
        assertThat(res).isEqualTo(46339)
    }

    private fun square(sqrt: Double) = (sqrt * sqrt + 0.5).toInt()
}