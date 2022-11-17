package leetcode.reverse.integer

import org.assertj.core.api.Assertions.assertThat
import org.testng.annotations.Test

internal class ReverseIntegerTest {
    private val core = StringBased()

    @Test
    fun test01() {
        val x = 123
        val res = this.core.reverse(x)
        assertThat(res).isEqualTo(321)
    }

    @Test
    fun test02() {
        val x = -123
        val res = this.core.reverse(x)
        assertThat(res).isEqualTo(-321)
    }

    @Test
    fun test03() {
        val x = 120
        val res = this.core.reverse(x)
        assertThat(res).isEqualTo(21)
    }

    @Test
    fun test04() {
        val x = 1534236469
        val res = this.core.reverse(x)
        assertThat(res).isEqualTo(0)
    }

    @Test
    fun test05() {
        val x = Int.MIN_VALUE
        val res = this.core.reverse(x)
        assertThat(res).isEqualTo(0)
    }
}