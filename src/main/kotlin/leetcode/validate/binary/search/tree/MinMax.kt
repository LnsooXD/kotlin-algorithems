package leetcode.validate.binary.search.tree

import leetcode.struct.TreeNode

class MinMax : ValidateBinarySearchTree {

    override fun isValidBST(root: TreeNode?) = isValidBST(root, null, null)

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
}