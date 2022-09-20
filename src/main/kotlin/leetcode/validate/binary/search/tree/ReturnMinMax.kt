package leetcode.validate.binary.search.tree

import leetcode.struct.TreeNode

class ReturnMinMax : ValidateBinarySearchTree {

    override fun isValidBST(root: TreeNode?): Boolean {
        val res = isValidBSTInternal(root)
        return res == null || res.isValidBST
    }

    private fun isValidBSTInternal(root: TreeNode?): Result? {
        if (root == null) {
            return null
        }

        val res = Result(
            root.`val`,
            root.`val`,
            true
        )

        val leftResult = isValidBSTInternal(root.left)
        if (leftResult != null) {
            if (leftResult.max >= root.`val`) {
                leftResult.isValidBST = false
            }
            if (!leftResult.isValidBST) {
                return leftResult
            }
            res.min = min(res.min, leftResult.min)
        }

        val rightResult = isValidBSTInternal(root.right)
        if (rightResult != null) {
            if (rightResult.min <= root.`val`) {
                rightResult.isValidBST = false
            }
            if (!rightResult.isValidBST) {
                return rightResult
            }
            res.max = max(res.max, rightResult.max)
        }
        return res
    }

    data class Result(var min: Int, var max: Int, var isValidBST: Boolean)

    fun min(a: Int, b: Int) = if (a < b) a else b
    fun max(a: Int, b: Int) = if (a > b) a else b


}