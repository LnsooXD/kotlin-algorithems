package leetcode.validate.binary.search.tree

import leetcode.struct.TreeNode

class ArrayInorder : ValidateBinarySearchTree {

    override fun isValidBST(root: TreeNode?): Boolean {
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

    private fun inorder(tree: TreeNode?): IntArray {
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