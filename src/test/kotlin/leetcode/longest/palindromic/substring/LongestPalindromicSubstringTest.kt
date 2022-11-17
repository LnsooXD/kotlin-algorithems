package leetcode.longest.palindromic.substring

import org.assertj.core.api.Assertions.assertThat
import org.testng.annotations.Test

internal class LongestPalindromicSubstringTest {
    private val core = CenterCore()

    @Test
    fun test00() {
        val s = ""
        val res = this.core.longestPalindrome(s)
        assertThat(res).isEmpty()
    }

    @Test
    fun test01() {
        val s = "a"
        val res = this.core.longestPalindrome(s)
        assertThat(res).isEqualTo("a")
    }

    @Test
    fun test02() {
        val s = "bb"
        val res = this.core.longestPalindrome(s)
        assertThat(res).isIn("bb")
    }

    @Test
    fun test03() {
        val s = "babad"
        val res = this.core.longestPalindrome(s)
        assertThat(res).isIn("aba", "bab")
    }

    @Test
    fun test04() {
        val s = "cbbd"
        val res = this.core.longestPalindrome(s)
        assertThat(res).isIn("bb")
    }
}