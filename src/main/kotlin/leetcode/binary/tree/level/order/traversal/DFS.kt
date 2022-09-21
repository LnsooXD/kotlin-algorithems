package leetcode.binary.tree.level.order.traversal

import leetcode.struct.TreeNode
import java.util.*

class DFS : BinaryTreeLevelOrderTraversal {

    override fun levelOrder(root: TreeNode?): List<List<Int>> {
        if (root == null) {
            return emptyList()
        }
        val res = ArrayList<LinkedList<Int>>()
        this.levelOrder(root, 0, res)
        return res
    }

    private fun levelOrder(root: TreeNode, level: Int, valuesOfAllLevels: ArrayList<LinkedList<Int>>) {
        if (level >= valuesOfAllLevels.size) {
            valuesOfAllLevels.add(LinkedList())
        }
        valuesOfAllLevels[level].add(root.`val`)

        if (root.left == null && root.right == null) {
            return
        }

        root.left?.let { this.levelOrder(it, level + 1, valuesOfAllLevels) }
        root.right?.let { this.levelOrder(it, level + 1, valuesOfAllLevels) }
    }
}