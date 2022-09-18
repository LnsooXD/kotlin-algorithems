package leetcode

// https://leetcode.cn/problems/generate-parentheses/

class GenerateParentheses {

    fun generateParenthesis(n: Int): List<String> {
        if (n <= 0) {
            return listOf("")
        }
        val res = mutableListOf<String>()
        generateParenthesis(res, "", n, n)
        return res
    }


    private fun generateParenthesis(list: MutableList<String>, curr: String, left: Int, right: Int) {
        if (left == 0 && right == 0) {
            list.add(curr)
            return
        }

        if (left > right) {
            return
        }

        if (left > 0) {
            this.generateParenthesis(list, "$curr(", left - 1, right)
        }

        if (right > 0) {
            this.generateParenthesis(list, "$curr)", left, right - 1)
        }
    }
}