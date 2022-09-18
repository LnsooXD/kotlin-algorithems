package leetcode

class LetterCombinationsOfaPhoneNumber {

    private val table = mutableMapOf<Char, List<String>>()

    init {
        this.table['2'] = listOf("a", "b", "c")
        this.table['3'] = listOf("d", "e", "f")
        this.table['4'] = listOf("g", "h", "i")
        this.table['5'] = listOf("j", "k", "l")
        this.table['6'] = listOf("m", "n", "o")
        this.table['7'] = listOf("p", "q", "r", "s")
        this.table['8'] = listOf("t", "u", "v")
        this.table['9'] = listOf("w", "x", "y", "z")
    }

    fun letterCombinations(digits: String): List<String> {
        val digitChars = digits.toCharArray()
        val size = digitChars.size
        if (size <= 0) {
            return listOf()
        } else if (size == 1) {
            return this.table[digitChars[0]] ?: listOf()
        }

        var res: List<String>? = null

        for (c in digitChars) {
            val unit = this.table[c] ?: continue

            res = if (res == null || res.isEmpty()) {
                unit
            } else {
                this.combine(res, unit)
            }
        }

        return res ?: listOf()
    }

    private fun combine(a: List<String>, b: List<String>): List<String> {
        if (a.isEmpty()) {
            return b
        } else if (b.isEmpty()) {
            return a
        }

        val res = mutableListOf<String>()

        for (av in a) {
            for (bv in b) {
                res.add(av + bv)
            }
        }

        return res
    }
}