package leetcode

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class LongestPalindromicSubstringTest {

    private val core = LongestPalindromicSubstring()

    @Test
    fun testLongestPalindrome() {
        val s = "babad"
        val res = this.core.longestPalindrome(s)
        assertThat(res).isIn("aba", "bab")
    }

}