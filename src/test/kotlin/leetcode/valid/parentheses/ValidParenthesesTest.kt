package leetcode.valid.parentheses

import org.testng.annotations.AfterMethod
import org.testng.annotations.BeforeMethod
import org.testng.annotations.Test


class ValidParenthesesTest {

    private val core = UseStack()

    @BeforeMethod
    fun setUp() {
    }

    @AfterMethod
    fun tearDown() {
    }

    @Test(groups = ["valid"])
    fun testIsValid01() {
        val s = "()"
        val res = this.core.isValid(s)
    }
}