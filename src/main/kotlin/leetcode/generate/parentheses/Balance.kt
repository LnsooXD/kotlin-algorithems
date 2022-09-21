package leetcode.generate.parentheses

class Balance : GenerateParentheses {

    override fun generateParenthesis(n: Int): List<String> {
        val res = mutableListOf<String>()
        generateParenthesis(res, "", n, n)
        return res
    }

    private fun generateParenthesis(results: MutableList<String>, result: String, left: Int, right: Int) {
        if (right == 0 && left == 0) {
            results.add(result)
            return
        }

        if (right < left || left < 0) {
            return
        }

        generateParenthesis(results, "$result(", left - 1, right)
        generateParenthesis(results, "$result)", left, right - 1)
    }
}