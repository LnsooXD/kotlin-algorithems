package leetcode.minimum.depth.of.binary.tree

import leetcode.struct.TreeNode
import java.util.*

class BFS : MinimumDepthOfBinaryTree {
    override fun minDepth(root: TreeNode?): Int {
        if (root == null) {
            return 0
        }
        val queue: Queue<TreeNode> = LinkedList()
        queue.offer(root)

        var minDepth = 0

        while (queue.isNotEmpty()) {
            minDepth++
            for (i in 0 until queue.size) {
                val node = queue.poll()
                if (node.left == null && node.right == null) {
                    return minDepth
                }
                node.left?.let { queue.offer(it) }
                node.right?.let { queue.offer(it) }
            }
        }

        return minDepth
    }
}