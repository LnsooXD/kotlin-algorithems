package leetcode

import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test
import org.assertj.core.api.Assertions.assertThat


internal class RegularExpressionMatchingTest {

    private val matcher = RegularExpressionMatching()

    @Test
    fun test() {
        assertThat(matcher.isMatch("a", "ab*a")).isEqualTo(false)
        assertThat(matcher.isMatch("bbbba", ".*a*a")).isEqualTo(true)
    }

}