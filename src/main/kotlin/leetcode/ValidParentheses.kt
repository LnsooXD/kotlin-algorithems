package leetcode

import java.util.*

// https://leetcode.cn/problems/valid-parentheses/

class ValidParentheses {

    fun isValid(s: String): Boolean {
        val stack = Stack<Char>()
        for (c in s) {
            if (isEnding(c)) {
                if (stack.isEmpty() || stack.pop() != fastMap(c)) {
                    return false
                }
            } else {
                stack.push(c)
            }
        }
        return stack.isEmpty()
    }

    private fun fastMap(c: Char) = when (c) {
        ')' -> '('
        '}' -> '{'
        else -> '['
    }

    private fun isEnding(c: Char) = c == ')' || c == ']' || c == '}'

    fun isValidMap(s: String): Boolean {
        val map = hashMapOf(')' to '(', ']' to '[', '}' to '{')
        val stack = Stack<Char>()
        for (c in s) {
            if (c in map) {
                if (stack.isEmpty() || stack.pop() != map[c]) {
                    return false
                }
            } else {
                stack.push(c)
            }
        }
        return stack.isEmpty()
    }

}