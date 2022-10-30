package leetcode.zigzag.conversion

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class ZigzagConversionTest {

    private val core = Directly()

    @Test
    fun test01() {
        val s = "A"
        val numRows = 1
        val res = this.core.convert(s, numRows)
        assertThat(res).isEqualTo("A")
    }

    @Test
    fun test02() {
        val s = "PAYPALISHIRING"
        val numRows = 3
        val res = this.core.convert(s, numRows)
        assertThat(res).isEqualTo("PAHNAPLSIIGYIR")
    }

    @Test
    fun test03() {
        val s = "PAYPALISHIRING"
        val numRows = 4
        val res = this.core.convert(s, numRows)
        assertThat(res).isEqualTo("PINALSIGYAHRPI")
    }


}