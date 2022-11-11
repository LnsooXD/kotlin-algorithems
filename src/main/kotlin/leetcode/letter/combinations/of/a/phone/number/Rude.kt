package leetcode.letter.combinations.of.a.phone.number

import leetcode.annotation.SolvingDate

@SolvingDate(2022, 11, 11)
class Rude : LetterCombinationsOfAPhoneNumber {
    override fun letterCombinations(digits: String): List<String> {
        if (digits.isEmpty()) {
            return emptyList()
        }
        val table = arrayOf("", "", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz")
        var res = table[digits[0] - '0'].toCharArray().map { "$it" }

        for (i in 1 until digits.length) {
            res = merge(res, table[digits[i] - '0'].toCharArray().map { "$it" })
        }
        return res
    }

    private fun merge(a: List<String>, b: List<String>): List<String> {
        if (a.isEmpty()) {
            return b
        } else if (b.isEmpty()) {
            return a
        }
        val res = mutableListOf<String>()
        for (i in a.indices) {
            for (j in b.indices) {
                res.add(a[i] + b[j])
            }
        }
        return res
    }

}