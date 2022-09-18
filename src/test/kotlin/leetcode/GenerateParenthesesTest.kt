package leetcode

import org.junit.jupiter.api.Test

internal class GenerateParenthesesTest {

    private val core = GenerateParentheses()

    @Test
    fun test() {
        val n = 1
        val res = this.core.generateParenthesis(n)
        println("$n => $res")
    }
}