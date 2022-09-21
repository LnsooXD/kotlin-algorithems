package leetcode.binary.tree.level.order.traversal

import leetcode.struct.TreeNode
import java.util.*

// 无效信息太多
class BFSFillNulls : BinaryTreeLevelOrderTraversal {
    override fun levelOrder(root: TreeNode?): List<List<Int>> {
        if (root == null) {
            return emptyList()
        }
        val separator = TreeNode(0)
        val queue: Queue<TreeNode?> = LinkedList<TreeNode>().apply {
            this.add(root)
            this.add(separator)
        }
        val res = mutableListOf<List<Int>>()

        var layerCount = 0
        var layerNullCount = 0
        var layerMax = 2


        var layerValues = mutableListOf<Int>()

        val counting = { it: TreeNode? ->
            queue.offer(it)
            layerCount++
            if (it == null) {
                layerNullCount++
            }
        }

        while (queue.isNotEmpty()) {
            val node = queue.poll()
            if (node == separator) {
                res.add(layerValues)
                layerValues = mutableListOf()
                continue
            }

            node?.`val`?.let { layerValues.add(it) }
            node?.left.let(counting)
            node?.right.let(counting)

            if (layerCount >= layerMax) {
                if (layerNullCount >= layerCount) {
                    res.add(layerValues)
                    break
                }
                layerCount = 0
                layerNullCount = 0
                layerMax += layerMax
                queue.offer(separator)
            }
        }

        return res
    }
}