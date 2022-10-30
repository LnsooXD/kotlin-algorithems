package leetcode.longest.palindromic.substring

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class LongestPalindromicSubstringTest {
    private val core = CenterCore()

    @Test
    fun test01() {
        val s = "babad"
        val res = this.core.longestPalindrome(s)
        assertThat(res).isIn("aba", "bab")
    }

    @Test
    fun test02() {
        val s = "cbbd"
        val res = this.core.longestPalindrome(s)
        assertThat(res).isIn("bb")
    }

    @Test
    fun test03() {
        val s = "bb"
        val res = this.core.longestPalindrome(s)
        assertThat(res).isIn("bb")
    }
}