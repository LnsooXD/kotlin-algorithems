package leetcode.string.to.integer.atoi

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class StringToIntegerAtoiTest {
    private val core = Directly()


    @Test
    fun test01() {
        val s = "42"
        val res = this.core.myAtoi(s)
        assertThat(res).isEqualTo(42)
    }

    @Test
    fun test02() {
        val s = "   -42"
        val res = this.core.myAtoi(s)
        assertThat(res).isEqualTo(-42)
    }

    @Test
    fun test03() {
        val s = "4193 with words"
        val res = this.core.myAtoi(s)
        assertThat(res).isEqualTo(4193)
    }

    @Test
    fun test04() {
        val s = ""
        val res = this.core.myAtoi(s)
        assertThat(res).isEqualTo(0)
    }

    @Test
    fun test05() {
        val s = "xxx with words"
        val res = this.core.myAtoi(s)
        assertThat(res).isEqualTo(0)
    }
}