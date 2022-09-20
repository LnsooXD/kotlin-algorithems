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

        // 此时， prev 已经变成 left 中的最后一个
        if (prev.node.let { it != null && it.`val` >= root.`val` }) {
            return false
        }

        prev.node = root // right 的前驱是 root 自己
        return inorderAndValidate(root.right, prev) // prev 变成 right 的最后一个，他是 root 的父节点的前驱
    }

    private data class Holder(var node: TreeNode?)
}