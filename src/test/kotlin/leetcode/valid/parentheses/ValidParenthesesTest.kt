package leetcode.valid.parentheses

import org.assertj.core.api.Assertions.assertThat
import org.testng.annotations.Test

class ValidParenthesesTest {

    private val core = UseStack()

    @Test(groups = ["isValid"])
    fun testIsValid01() {
        val s = "()"
        val res = this.core.isValid(s)
        assertThat(res).describedAs("s=\"$s\"").isTrue()
    }

    @Test(groups = ["isValid"])
    fun testIsValid02() {
        val s = "()[]{}"
        val res = this.core.isValid(s)
        assertThat(res).describedAs("s=\"$s\"").isTrue()
    }

    @Test(groups = ["isValid"])
    fun testIsValid03() {
        val s = "(]"
        val res = this.core.isValid(s)
        assertThat(res).describedAs("s=\"$s\"").isFalse()
    }
}