package leetcode

import leetcode.struct.TreeNode


// https://leetcode.cn/problems/validate-binary-search-tree/

class ValidateBinarySearchTree {

    fun isValidBSTInorder(root: TreeNode?): Boolean {
        if (root == null || (root.left != null && root.right == null)) {
            return true
        }
        val inorder = this.inorder(root)
        var v = inorder[0]
        for (i in 1 until inorder.size) {
            val nextValue = inorder[i]
            if (nextValue < v) {
                return false
            }
            v = nextValue
        }
        return true
    }

    fun isValidBST(root: TreeNode?) = isValidBST(root, null, null)

    fun isValidBST(root: TreeNode?, min: Int?, max: Int?): Boolean {
        if (root == null) {
            return true
        }
        if (min != null && min >= root.`val`) {
            return false
        }

        if (max != null && max <= root.`val`) {
            return false
        }

        return isValidBST(root.left, min, root.`val`) &&
                isValidBST(root.right, root.`val`, max)
    }

    fun isValidBST1(root: TreeNode?): Boolean {
        val res = isValidBSTInternal(root)
        return res == null || res.isValidBST
    }

    fun isValidBSTInternal(root: TreeNode?): Result? {
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

//    fun max(a: Int?, b: Int?) = if (a == null) b else if (b == null) a else if (a > b) a else b
//    fun min(a: Int?, b: Int?) = if (a == null) b else if (b == null) a else if (a < b) a else b

    fun inorder(tree: TreeNode?): IntArray {
        if (tree == null) {
            return intArrayOf()
        }

        val left = inorder(tree.left)
        val right = inorder(tree.right)

        val size = left.size + 1 + right.size
        val res = IntArray(size)

        System.arraycopy(left, 0, res, 0, left.size)
        res[left.size] = tree.`val`
        System.arraycopy(right, 0, res, left.size + 1, right.size)

        return res
    }

}