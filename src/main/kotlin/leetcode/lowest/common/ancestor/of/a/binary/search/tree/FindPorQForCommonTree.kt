package leetcode.lowest.common.ancestor.of.a.binary.search.tree

import leetcode.struct.TreeNode

class FindPorQForCommonTree : LowestCommonAncestor {
    override fun lowestCommonAncestor(root: TreeNode?, p: TreeNode?, q: TreeNode?): TreeNode? {
        if (root == null || root == p || root == q) {
            return root
        }
        val ancestorIsLeft = lowestCommonAncestor(root.left, p, q)
        val ancestorIsRight = lowestCommonAncestor(root.right, p, q)
        return if (ancestorIsLeft == null) ancestorIsRight else if (ancestorIsRight == null) ancestorIsLeft else root
    }

}