package leetcode.lowest.common.ancestor.of.a.binary.search.tree

import leetcode.struct.TreeNode

class SameSide : LowestCommonAncestor {
    override fun lowestCommonAncestor(root: TreeNode?, p: TreeNode?, q: TreeNode?): TreeNode? {
        val pv = p?.`val` ?: return q
        val qv = q?.`val` ?: return p
        var ancestor = root
        while (ancestor != null) {
            ancestor = if (ancestor.`val` > pv && ancestor.`val` > qv) {
                ancestor.left
            } else if (ancestor.`val` < pv && ancestor.`val` < qv) {
                ancestor.right
            } else { // q, p 分别来自两个子树
                break
            }
        }
        return ancestor
    }
}