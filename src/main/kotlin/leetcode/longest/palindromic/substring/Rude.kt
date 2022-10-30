package leetcode.longest.palindromic.substring

// DATE 2022-10-30
class Rude : LongestPalindromicSubstring {
    override fun longestPalindrome(s: String): String {
        if (s.length <= 1) {
            return s
        }

        var longestPalindrome = s.substring(0, 1)

        for (i in 2..s.length) {
            val pal = longestPalindromicSubstringToEnd(s.substring(0, i))
            if (pal.length > longestPalindrome.length) {
                longestPalindrome = pal
            }
        }
        return longestPalindrome
    }

    private fun longestPalindromicSubstringToEnd(s: String): String {
        for (i in 0..s.length - 2) {
            val substr = s.substring(i, s.length)
            if (isPalindromic(substr)) {
                return substr
            }
        }
        return s.substring(s.length - 1, s.length)
    }


    private fun isPalindromic(s: String): Boolean {
        val maxIndex = s.length - 1
        if (maxIndex <= 0) {
            return true
        }
        for (i in 0..maxIndex.ushr(1)) {
            if (s[i] != s[maxIndex - i]) {
                return false
            }
        }
        return true
    }

}