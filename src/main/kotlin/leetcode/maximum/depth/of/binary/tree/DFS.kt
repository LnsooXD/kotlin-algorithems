package leetcode.maximum.depth.of.binary.tree

import leetcode.struct.TreeNode

class DFS : MaximumDepthOfBinaryTree {

    override fun maxDepth(root: TreeNode?): Int {
        if (root == null) {
            return 0
        }
        val left = maxDepth(root.left)
        val right = maxDepth(root.right)
        return 1 + if (left > right) left else right
    }


}