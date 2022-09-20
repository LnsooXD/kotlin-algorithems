package leetcode.lowest.common.ancestor.of.a.binary.search.tree

import leetcode.struct.TreeNode

class FindPorQ : LowestCommonAncestor {

    override fun lowestCommonAncestor(root: TreeNode?, p: TreeNode?, q: TreeNode?): TreeNode? {
        val pv = p?.`val` ?: return q
        val qv = q?.`val` ?: return p
        return lowestCommonAncestor(root, pv, qv)
    }

    private fun lowestCommonAncestor(root: TreeNode?, pv: Int, qv: Int): TreeNode? {
        if (root == null) {
            return null
        }
        return if (pv < root.`val` && qv < root.`val`) {
            lowestCommonAncestor(root.left, pv, qv)
        } else if (pv > root.`val` && qv > root.`val`) {
            lowestCommonAncestor(root.right, pv, qv)
        } else {
            root
        }
    }
}