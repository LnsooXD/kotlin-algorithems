package leetcode.zigzag.conversion

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class ZigzagConversionTest {

    private val core = DirectlyString()

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

    @Test
    fun test04() {
        val s = "AB"
        val numRows = 1
        val res = this.core.convert(s, numRows)
        assertThat(res).isEqualTo("AB")
    }

    @Test
    fun test05() {
        val s = "ABCDEFGH"
        val numRows = 2
        val res = this.core.convert(s, numRows)
        assertThat(res).isEqualTo("ACEGBDFH")
    }




}