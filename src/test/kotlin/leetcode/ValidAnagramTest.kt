package leetcode

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class ValidAnagramTest {

    private val core = ValidAnagram()

    @Test
    fun testAnagram0() {
        val s = "anagram"
        val t = "nagaram"
        val res = this.core.isAnagram(s, t)
        assertThat(res).isTrue()
    }
}