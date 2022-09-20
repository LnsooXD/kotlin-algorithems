package leetcode.validate.binary.search.tree

import leetcode.struct.TreeNode

class Inorder : ValidateBinarySearchTree {

    override fun isValidBST(root: TreeNode?) = inorderAndValidate(root, Holder(null))

    private fun inorderAndValidate(root: TreeNode?, prev: Holder): Boolean {
        if (root == null) {
            return true
        }
        if (!inorderAndValidate(root.left, prev)) { // 执行完之后，prev 会变成 left 中最后一个。
            return false
        }
        if (prev.node.let { it != null && it.`val` >= root.`val` }) {
            return false
        }

        prev.node = root
        return inorderAndValidate(root.right, prev)
    }

    private data class Holder(var node: TreeNode?)
}