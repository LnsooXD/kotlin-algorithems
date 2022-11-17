package leetcode.longest.substring.without.repeating.characters

import org.assertj.core.api.Assertions.assertThat
import org.testng.annotations.Test

internal class LongestSubstringWithoutRepeatingCharactersITest {

    private val core = PosCache()

    @Test
    fun test1() {
        val s = ""
        val res = core.lengthOfLongestSubstring(s)
        assertThat(res).isEqualTo(0)
    }

    @Test
    fun test2() {
        val s = "a"
        val res = core.lengthOfLongestSubstring(s)
        assertThat(res).isEqualTo(1)
    }

    @Test
    fun test3() {
        val s = "abcabcbb"
        val res = core.lengthOfLongestSubstring(s)
        assertThat(res).isEqualTo(3)
    }

    @Test
    fun test4() {
        val s = "bbbbb"
        val res = core.lengthOfLongestSubstring(s)
        assertThat(res).isEqualTo(1)
    }


    @Test
    fun test5() {
        val s = "pwwkew"
        val res = core.lengthOfLongestSubstring(s)
        assertThat(res).isEqualTo(3)
    }

}