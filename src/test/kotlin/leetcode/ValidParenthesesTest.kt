package leetcode

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class ValidParenthesesTest {
    
    private val core = ValidParentheses()
    
    @Test
    fun testValid1() {
        val s = "){"
        val res = this.core.isValid(s)
        assertThat(res).isFalse()
    }

    @Test
    fun testValid2() {
        val s = "()"
        val res = this.core.isValid(s)
        assertThat(res).isTrue()
    }

    @Test
    fun testValid3() {
        val s = "())"
        val res = this.core.isValid(s)
        assertThat(res).isFalse()
    }

    @Test
    fun testValid4() {
        val s = "{()}"
        val res = this.core.isValid(s)
        assertThat(res).isTrue()
    }

    @Test
    fun testValid5() {
        val s = "()[]{}"
        val res = this.core.isValid(s)
        assertThat(res).isTrue()
    }


}