package leetcode.lowest.common.ancestor.of.a.binary.search.tree

import leetcode.struct.TreeNode

// https://leetcode.cn/problems/lowest-common-ancestor-of-a-binary-search-tree/

interface LowestCommonAncestor {
    fun lowestCommonAncestor(root: TreeNode?, p: TreeNode?, q: TreeNode?): TreeNode?
}