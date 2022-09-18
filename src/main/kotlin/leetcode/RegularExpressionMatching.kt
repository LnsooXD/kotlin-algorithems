package leetcode

// https://leetcode.cn/problems/regular-expression-matching/

fun main(args: Array<String>) {

}


class RegularExpressionMatching {

    fun isMatch(s: String, p: String): Boolean {

        if (s.isNotEmpty() && p.isEmpty()) {
            return false
        } else if (s.isEmpty() && p.isEmpty()) {
            return true
        } else if (s.isEmpty() && p.isNotEmpty()) {
            return if (p.length != 2) {
                false
            } else {
                p[1] == '*'
            }
        }

        var si = 0
        var pi = 0

        var hasStar = false

        val sp = p[pi++]
        val ss = s[si++]

        if (pi < p.length && p[pi] == '*') {
            hasStar = true
            pi++
        }

        return if (sp == '.') {
            if (hasStar) {
                if (pi >= p.length) {
                    true
                } else if (si >= s.length) {
                    false
                } else {
                    while (si < s.length && s[si] != p[pi]) {
                        si++
                    }
                    isMatch(s.substring(si), p.substring(pi)) || isMatch(s.substring(si - 1), p.substring(pi))
                }
            } else {
                isMatch(s.substring(si), p.substring(pi))
            }
        } else if (sp == ss) {
            if (hasStar) {
                if (pi >= p.length) {
                    true
                } else if (si >= s.length) {
                    false
                } else {
                    while (si < s.length && s[si] == ss) {
                        si++
                    }
                    isMatch(s.substring(si), p.substring(pi)) || isMatch(s.substring(si - 1), p.substring(pi))
                }
            } else {
                isMatch(s.substring(si), p.substring(pi))
            }
        } else if (hasStar) {
            if (pi >= p.length) {
                false
            } else {
                isMatch(s, p.substring(pi))
            }
        } else {
            false
        }
    }
}