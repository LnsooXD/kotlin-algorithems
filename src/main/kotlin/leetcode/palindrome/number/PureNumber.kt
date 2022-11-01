package leetcode.palindrome.number

import leetcode.annotation.SolvingDate

@SolvingDate(2022, 11, 1)
class PureNumbers : PalindromeNumber {
    override fun isPalindrome(x: Int): Boolean {
        if (x < 10) {
            return x >= 0
        }

        val digits = IntArray(11)

        var index = 0
        var value = x
        while (value != 0) {
            digits[index++] = value % 10
            value /= 10
        }

        index--

        for (i in 0..index.ushr(1)) {
            if (digits[i] != digits[index - i]) {
                return false
            }
        }
        return true
    }
}