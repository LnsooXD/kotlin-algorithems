package leetcode.minimum.depth.of.binary.tree

import leetcode.struct.TreeNode

class DFS : MinimumDepthOfBinaryTree {
    override fun minDepth(root: TreeNode?) = minLeafDepth(root, 1)
    private fun minLeafDepth(root: TreeNode?, depth: Int): Int {
        if (root == null) {
            return 0
        }
        if (root.left == null && root.right == null) {
            return depth
        }
        val left = minLeafDepth(root.left, depth + 1)
        val right = minLeafDepth(root.right, depth + 1)
        return if (right == 0 || left in 1 until right) left else right
    }
}