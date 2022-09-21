package leetcode.binary.tree.level.order.traversal

import leetcode.struct.TreeNode
import leetcode.struct.bfs
import leetcode.struct.treeOf
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class BinaryTreeLevelOrderTraversalTest {
    private val bfsFillNulls = BFSFillNulls()

    @Test
    fun testBFSFillNulls01() {
        val root = treeOf(3, 9, 20, null, null, 15, 7)
        val res = this.bfsFillNulls.levelOrder(root)

        assertThat(res).isEqualTo(
            listOf(
                listOf(3),
                listOf(9, 20),
                listOf(15, 7),
            )
        )
    }

    @Test
    fun testBFSFillNulls02() {
        val root = TreeNode(-150)
        var node = root
        for (i in -149..600) {
            val left = TreeNode(i)
            node.left = left
            node = left
        }

        val res = this.bfsFillNulls.levelOrder(root)
        println(res.toList())
    }
}
