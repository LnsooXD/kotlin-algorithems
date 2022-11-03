package leetcode.integer.to.roman

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class IntegerToRomanTest {
    private val core = Table()

    @Test
    fun test01() {
        val num = 3
        val res = this.core.intToRoman(num)
        assertThat(res).describedAs("num: $num").isEqualTo("III")
    }

    @Test
    fun test02() {
        val num = 58
        val res = this.core.intToRoman(num)
        assertThat(res).describedAs("num: $num").isEqualTo("LVIII")
    }

    @Test
    fun test03() {
        val num = 1994
        val res = this.core.intToRoman(num)
        assertThat(res).describedAs("num: $num").isEqualTo("MCMXCIV")
    }
}