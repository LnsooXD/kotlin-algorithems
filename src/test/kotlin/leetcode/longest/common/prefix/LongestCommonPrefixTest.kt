package leetcode.longest.common.prefix

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class LongestCommonPrefixTest {
    private val core = Rude()

    @Test
    fun test01() {
        val strs = arrayOf("flower","flow","flight")
        val res = this.core.longestCommonPrefix(strs)
        assertThat(res).isEqualTo("fl")
    }

    @Test
    fun test02() {
        val strs = arrayOf("dog","racecar","car")
        val res = this.core.longestCommonPrefix(strs)
        assertThat(res).isEqualTo("")
    }
}