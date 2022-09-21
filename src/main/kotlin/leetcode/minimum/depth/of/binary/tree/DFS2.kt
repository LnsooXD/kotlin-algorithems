package leetcode.minimum.depth.of.binary.tree

import leetcode.struct.TreeNode

class DFS2 : MinimumDepthOfBinaryTree {
    override fun minDepth(root: TreeNode?): Int {
        if (root == null) {
            return 0
        }
        val leftMinDepth = minDepth(root.left)
        val rightMinDepth = minDepth(root.right)

        return 1 + if (leftMinDepth == 0 || rightMinDepth == 0)
            leftMinDepth + rightMinDepth
        else if (leftMinDepth < rightMinDepth)
            leftMinDepth
        else
            rightMinDepth
    }

}