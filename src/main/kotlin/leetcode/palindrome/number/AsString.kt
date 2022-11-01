package leetcode.palindrome.number

import leetcode.annotation.SolvingDate

@SolvingDate(2022, 11, 1)
class AsString : PalindromeNumber {
    override fun isPalindrome(x: Int): Boolean {
        if (x < 10) {
            return x >= 0
        }
        val xs = x.toString()
        for (i in 0..((xs.length - 1).ushr(1))) {
            if (xs[i] != xs[xs.length - 1 - i]) {
                return false
            }
        }
        return true
    }
}