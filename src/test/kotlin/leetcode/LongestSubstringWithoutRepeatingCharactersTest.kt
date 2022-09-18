package leetcode

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class LongestSubstringWithoutRepeatingCharactersTest {

    private val core = LongestSubstringWithoutRepeatingCharacters()

    @Test
    fun testLengthOfLongestSubstring1() {
        val s = "abcabcbb"
        val res = this.core.lengthOfLongestSubstring(s)
        assertThat(res).isEqualTo(3)
    }

    @Test
    fun testLengthOfLongestSubstring2() {
        val s = "bbbbb"
        val res = this.core.lengthOfLongestSubstring(s)
        assertThat(res).isEqualTo(1)
    }

    @Test
    fun testLengthOfLongestSubstring3() {
        val s = "pwwkew"
        val res = this.core.lengthOfLongestSubstring(s)
        assertThat(res).isEqualTo(3)
    }

}