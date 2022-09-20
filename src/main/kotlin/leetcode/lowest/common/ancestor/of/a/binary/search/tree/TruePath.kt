package leetcode.lowest.common.ancestor.of.a.binary.search.tree

import leetcode.struct.TreeNode

class TruePath : LowestCommonAncestor {

    override fun lowestCommonAncestor(root: TreeNode?, p: TreeNode?, q: TreeNode?): TreeNode? {
        if (root == null) {
            return null
        } else if (p == null) {
            return q
        } else if (q == null) {
            return p
        }

        val pv = p.`val`
        val qv = q.`val`

        val res = Result(null)
        this.lowestCommonAncestor(root, pv, qv, res)
        return res.node
    }

    private fun lowestCommonAncestor(root: TreeNode?, p: Int, q: Int, result: Result): Boolean {
        if (root == null) {
            return false
        }

        val value = root.`val`

        val isSelf = p == value || q == value

        val isLeft = (value > p || value > q) && this.lowestCommonAncestor(root.left, p, q, result)

        if (isSelf && isLeft) {
            result.node = root
            return true
        }

        val isRight = (value < p || value < q) && this.lowestCommonAncestor(root.right, p, q, result)
        if ((isSelf && isRight) || (isLeft && isRight)) {
            result.node = root
            return true
        }

        return isSelf || isLeft || isRight
    }

    data class Result(var node: TreeNode?)

}