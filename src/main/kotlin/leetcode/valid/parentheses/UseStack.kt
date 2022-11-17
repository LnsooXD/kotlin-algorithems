package leetcode.valid.parentheses

import leetcode.annotation.SolvingDate
import java.util.*

@SolvingDate(2022, 11, 17)
class UseStack : ValidParentheses {
    override fun isValid(s: String): Boolean {
        val stack = Stack<Char>()
        val heads = charArrayOf('(', '[', '{')

        for (c in s) {
            if (c in heads) {
                stack.push(c)
            } else if (stack.isEmpty() || (c - stack.pop()) !in 1..2) {
                return false
            }
        }
        return stack.isEmpty()
    }
}