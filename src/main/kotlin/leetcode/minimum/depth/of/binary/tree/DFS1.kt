package leetcode.minimum.depth.of.binary.tree

import leetcode.struct.TreeNode

class DFS1 : MinimumDepthOfBinaryTree {
    override fun minDepth(root: TreeNode?): Int {
        if (root == null) {
            return 0
        } else if (root.left == null) {
            return 1 + minDepth(root.right)
        } else if (root.right == null) {
            return 1 + minDepth(root.left)
        }

        val leftMinDepth = minDepth(root.left)
        val rightMinDepth = minDepth(root.right)

        return 1 + if (leftMinDepth < rightMinDepth) leftMinDepth else rightMinDepth
    }

}