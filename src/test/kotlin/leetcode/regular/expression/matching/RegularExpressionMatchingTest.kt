package leetcode.regular.expression.matching

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class RegularExpressionMatchingTest {
    private val core = Recursion()

    @Test
    fun test01() {
        val s = "aa"
        val p = "a"
        val res = this.core.isMatch(s, p)
        assertThat(res).describedAs("s = \"$s\", p = \"$p\"").isFalse()
    }


    @Test
    fun test02() {
        val s = "aa"
        val p = "a*"
        val res = this.core.isMatch(s, p)
        assertThat(res).describedAs("s = \"$s\", p = \"$p\"").isTrue()
    }

    @Test
    fun test03() {
        val s = "ab"
        val p = ".*"
        val res = this.core.isMatch(s, p)
        assertThat(res).describedAs("s = \"$s\", p = \"$p\"").isTrue()
    }

    @Test
    fun test04() {
        val s = "ab"
        val p = ".*c"
        val res = this.core.isMatch(s, p)
        assertThat(res).describedAs("s = \"$s\", p = \"$p\"").isFalse()
    }

    @Test
    fun test05() {
        val s = "a"
        val p = "ab*"
        val res = this.core.isMatch(s, p)
        assertThat(res).describedAs("s = \"$s\", p = \"$p\"").isTrue()
    }

    @Test
    fun test06() {
        val s = "a"
        val p = "ab*a"
        val res = this.core.isMatch(s, p)
        assertThat(res).describedAs("s = \"$s\", p = \"$p\"").isFalse()
    }

    @Test
    fun test07() {
        val s = "mississippi"
        val p = "mis*is*p*."
        val res = this.core.isMatch(s, p)
        assertThat(res).describedAs("s = \"$s\", p = \"$p\"").isFalse()
    }

    @Test
    fun test08() {
        val s = "aa"
        val p = "."
        val res = this.core.isMatch(s, p)
        assertThat(res).describedAs("s = \"$s\", p = \"$p\"").isFalse()
    }

    @Test
    fun test09() {
        val s = "abcaaaaaaabaabcabac"
        val p = ".*ab.a.*a*a*.*b*b*"
        val res = this.core.isMatch(s, p)
        assertThat(res).describedAs("s = \"$s\", p = \"$p\"").isTrue()
    }

}