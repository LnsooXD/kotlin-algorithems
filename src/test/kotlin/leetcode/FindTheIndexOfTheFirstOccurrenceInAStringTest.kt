package leetcode

import org.assertj.core.api.Assertions.assertThat
import org.testng.annotations.Test

internal class FindTheIndexOfTheFirstOccurrenceInAStringTest {

    private val core = FindTheIndexOfTheFirstOccurrenceInAString()

    @Test
    fun test0() {
        val haystack = "sadbutsad"
        val needle = "sad"
        val index = this.core.strStr(haystack, needle)
        assertThat(index).isEqualTo(0)
    }

    @Test
    fun test1() {
        val haystack = "leetcode"
        val needle = "leeto"
        val index = this.core.strStr(haystack, needle)
        assertThat(index).isEqualTo(-1)
    }

    @Test
    fun test2() {
        val haystack = "qwertyuiopyuio"
        val needle = "yuio"
        val index = this.core.strStr(haystack, needle)
        assertThat(index).isEqualTo(5)
    }

}