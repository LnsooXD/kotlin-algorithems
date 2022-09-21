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
        // 如果 left 还有， 就可以加， 同时也避免了 left < 0 的情况
        if (left > 0) {
            generateParenthesis(results, "$result(", left - 1, right)
        }

        // 如果 right 比 left 多，就可以加。同时因为 left 一定是 >= 0 的， 所以 right 一定大于0
        if (right > left) {
            generateParenthesis(results, "$result)", left, right - 1)
        }
    }
}