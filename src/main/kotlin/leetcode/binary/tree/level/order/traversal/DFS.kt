package leetcode.binary.tree.level.order.traversal

import leetcode.struct.TreeNode
import java.util.*

class DFS : BinaryTreeLevelOrderTraversal {
    override fun levelOrder(root: TreeNode?): List<List<Int>> = if (root == null) {
        emptyList()
    } else {
        ArrayList<LinkedList<Int>>().apply { levelOrder(root, 0, this) }
    }

    private fun levelOrder(root: TreeNode, level: Int, valuesOfAllLevels: ArrayList<LinkedList<Int>>) {
        val levelValues = if (level >= valuesOfAllLevels.size) {
            LinkedList<Int>().apply { valuesOfAllLevels.add(this) }
        } else {
            valuesOfAllLevels[level]
        }
        levelValues.add(root.`val`)
        root.left?.let { this.levelOrder(it, level + 1, valuesOfAllLevels) }
        root.right?.let { this.levelOrder(it, level + 1, valuesOfAllLevels) }
    }
}