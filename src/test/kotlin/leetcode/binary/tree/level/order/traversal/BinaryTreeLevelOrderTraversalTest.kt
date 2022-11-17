package leetcode.binary.tree.level.order.traversal

import leetcode.struct.TreeNode
import leetcode.struct.treeOf
import org.assertj.core.api.Assertions.assertThat
import org.testng.annotations.Test

internal class BinaryTreeLevelOrderTraversalTest {
    private val core = DFS()

    @Test
    fun test01() {
        val root = treeOf(3, 9, 20, null, null, 15, 7)
        val res = this.core.levelOrder(root)

        assertThat(res).isEqualTo(
            listOf(
                listOf(3),
                listOf(9, 20),
                listOf(15, 7),
            )
        )
    }

    @Test
    fun test02() {
        val root = TreeNode(-150)
        var node = root
        for (i in -149..600) {
            val left = TreeNode(i)
            node.left = left
            node = left
        }

        val res = this.core.levelOrder(root)
        val expected = mutableListOf<List<Int>>()
        for (i in -150 .. 600) {
            expected.add(listOf(i))
        }
        assertThat(res).isEqualTo(expected)
    }
}
