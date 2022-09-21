package leetcode.binary.tree.level.order.traversal

import leetcode.struct.TreeNode

class LevelBatchProcess : BinaryTreeLevelOrderTraversal {

    override fun levelOrder(root: TreeNode?): List<List<Int>> {
        if (root == null) {
            return emptyList()
        }

        var levelParentNodes = listOf(root)
        var levelNodes = mutableListOf<TreeNode>()

        val res = mutableListOf<List<Int>>()
        res.add(listOf(root.`val`))

        while (true) {
            for (parent in levelParentNodes) {
                parent.left?.let { levelNodes.add(it) }
                parent.right?.let { levelNodes.add(it) }
            }

            if (levelNodes.isEmpty()) {
                break
            }

            levelParentNodes = levelNodes
            res.add(levelNodes.map { it.`val` })
            levelNodes = mutableListOf()
        }
        return res
    }

}