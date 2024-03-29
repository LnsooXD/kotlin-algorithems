package leetcode.binary.tree.level.order.traversal

import leetcode.struct.TreeNode
import java.util.*

class BFS : BinaryTreeLevelOrderTraversal {
    override fun levelOrder(root: TreeNode?): List<List<Int>> {
        if (root == null) {
            return emptyList()
        }

        val res = ArrayList<List<Int>>()
        val queue: Queue<TreeNode> = LinkedList(listOf(root))

        while (queue.isNotEmpty()) {
            val levelValues = ArrayList<Int>()
            for (i in 0 until queue.size) {
                val node = queue.poll()
                levelValues.add(node.`val`)
                node.left?.let { queue.offer(it) }
                node.right?.let { queue.offer(it) }
            }

            res.add(levelValues)
        }
        return res
    }
}