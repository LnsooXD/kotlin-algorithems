package leetcode.regular.expression.matching

import leetcode.annotation.SolvingDate

@SolvingDate(2022, 11, 1)
class Recursion : RegularExpressionMatching {
    override fun isMatch(s: String, p: String): Boolean {
        if (p.isEmpty()) {
            return s.isEmpty()
        }

        val ps = p[0]
        val isAny = ps == '.'
        val hasStar = p.length >= 2 && p[1] == '*'

        if (!hasStar) {
            return if (s.isEmpty() || !(isAny || ps == s[0])) {
                false
            } else {
                isMatch(s.substring(1), p.substring(1))
            }
        }

        val nextP = p.substring(2)
        if (isMatch(s, nextP)) {
            return true
        }

        var subStr = s
        while (subStr.isNotEmpty() && (isAny || ps == subStr[0])) {
            subStr = subStr.substring(1)
            if (isMatch(subStr, nextP)) {
                return true
            }
        }
        return false
    }
}