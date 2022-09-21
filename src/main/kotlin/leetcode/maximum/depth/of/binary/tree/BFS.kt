package leetcode.maximum.depth.of.binary.tree

import leetcode.struct.TreeNode
import java.util.*

class BFS : MaximumDepthOfBinaryTree {
    override fun maxDepth(root: TreeNode?): Int {
        if (root == null) {
            return 0
        }

        val queue: Queue<TreeNode> = LinkedList()
        queue.offer(root)

        var maxDepth = 0

        while (queue.isNotEmpty()) {
            for (i in 0 until queue.size) {
                val node = queue.poll()
                node.left?.let { queue.offer(it) }
                node.right?.let { queue.offer(it) }
            }
            maxDepth++
        }

        return maxDepth
    }
}