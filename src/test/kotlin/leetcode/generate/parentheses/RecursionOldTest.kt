package leetcode.generate.parentheses

import org.junit.jupiter.api.Test

internal class RecursionOldTest {
    private val core = RecursionOld()

    @Test
    fun test() {
        val n = 1
        val res = this.core.generateParenthesis(n)
        println("$n => $res")
    }
}