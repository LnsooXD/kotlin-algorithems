package leetcode.regular.expression.matching

import leetcode.annotation.SolvingDate

@SolvingDate(2022, 11, 1)
class Recursion(override var count: Int) : RegularExpressionMatching {
    override fun isMatch(s: String, p: String): Boolean {
        this.count++
        if (p.isEmpty()) {
            return s.isEmpty()
        }

        val ps = p[0]
        val isAny = ps == '.'
        val hasStar = p.length >= 2 && p[1] == '*'
        val nextP = p.substring(if (hasStar) 2 else 1)

        if (!hasStar) {
            return if (s.isEmpty() || !(isAny || ps == s[0])) {
                false
            } else {
                isMatch(s.substring(1), nextP)
            }
        }

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