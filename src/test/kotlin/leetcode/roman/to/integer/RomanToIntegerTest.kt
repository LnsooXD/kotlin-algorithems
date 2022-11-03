package leetcode.roman.to.integer

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class RomanToIntegerTest {
    private val core = TableAndLoop()

    @Test
    fun test01() {
        val s = "III"
        val res = this.core.romanToInt(s)
        assertThat(res).describedAs("s=$s").isEqualTo(3)
    }

    @Test
    fun test02() {
        val s = "LVIII"
        val res = this.core.romanToInt(s)
        assertThat(res).describedAs("s=$s").isEqualTo(58)
    }

    @Test
    fun test03() {
        val s = "MCMXCIV"
        val res = this.core.romanToInt(s)
        assertThat(res).describedAs("s=$s").isEqualTo(1994)
    }
}