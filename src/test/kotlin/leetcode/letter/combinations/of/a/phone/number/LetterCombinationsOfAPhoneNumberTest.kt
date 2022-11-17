package leetcode.letter.combinations.of.a.phone.number

import org.assertj.core.api.Assertions.assertThat
import org.testng.annotations.Test

internal class LetterCombinationsOfAPhoneNumberTest {
    private val core = Rude()

    @Test
    fun test01() {
        val digits = "23"
        val res = this.core.letterCombinations(digits)
        assertThat(res).isEqualTo(listOf("ad", "ae", "af", "bd", "be", "bf", "cd", "ce", "cf"))
    }

    @Test
    fun test02() {
        val digits = ""
        val res = this.core.letterCombinations(digits)
        assertThat(res).isEqualTo(emptyList<String>())
    }

    @Test
    fun test03() {
        val digits = "2"
        val res = this.core.letterCombinations(digits)
        assertThat(res).isEqualTo(listOf("a", "b", "c"))
    }
}