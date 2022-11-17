package leetcode.regular.expression.matching

import org.assertj.core.api.Assertions.assertThat
import org.testng.annotations.Test


internal class RegularExpressionMatchingOldTest {

    private val matcher = RegularExpressionMatchingOld()

    @Test
    fun test() {
        assertThat(matcher.isMatch("a", "ab*a")).isEqualTo(false)
        assertThat(matcher.isMatch("bbbba", ".*a*a")).isEqualTo(true)
    }

}