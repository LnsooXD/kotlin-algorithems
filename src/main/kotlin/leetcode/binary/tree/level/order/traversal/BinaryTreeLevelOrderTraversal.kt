package leetcode.binary.tree.level.order.traversal

import leetcode.struct.TreeNode

// https://leetcode.cn/problems/binary-tree-level-order-traversal/

interface BinaryTreeLevelOrderTraversal {
    fun levelOrder(root: TreeNode?): List<List<Int>>
}