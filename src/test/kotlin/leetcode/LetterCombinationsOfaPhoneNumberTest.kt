package leetcode

import org.testng.annotations.Test

internal class LetterCombinationsOfaPhoneNumberTest {

    private val core = LetterCombinationsOfaPhoneNumber()

    @Test
    fun testCombine() {
        val digits = "23"
        val res = this.core.letterCombinations(digits)
        println(res)
    }
}