package leetcode.palindrome.number

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class PalindromeNumberTest {
    private val core = PureNumbers()

    @Test
    fun test00() {
        val x = 0
        val res = this.core.isPalindrome(x)
        assertThat(res).isTrue()
    }

    @Test
    fun test01() {
        val x = 121
        val res = this.core.isPalindrome(x)
        assertThat(res).isTrue()
    }

    @Test
    fun test02() {
        val x = -121
        val res = this.core.isPalindrome(x)
        assertThat(res).isFalse()
    }

    @Test
    fun test03() {
        val x = 10
        val res = this.core.isPalindrome(x)
        assertThat(res).isFalse()
    }

    @Test
    fun test04() {
        val x = 11
        val res = this.core.isPalindrome(x)
        assertThat(res).isTrue()
    }
}
