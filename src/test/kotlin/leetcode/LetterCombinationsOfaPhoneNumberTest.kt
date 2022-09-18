package leetcode

import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test

internal class LetterCombinationsOfaPhoneNumberTest {

    private val core = LetterCombinationsOfaPhoneNumber()

    @Test
    fun testCombine() {
        val digits = "23"
        val res = this.core.letterCombinations(digits)
        println(res)
    }
}