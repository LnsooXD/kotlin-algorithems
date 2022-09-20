package leetcode.struct

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class TreeNodeTest {

    @Test
    fun testInorder() {
        val tree = treeOf(
            5,/**/
            3, 7, /**/
            1, 4, 6, 9,/**/
            null, 2, null, null, null, null, 8, null
        )
        val inorder = inorder(tree)
        assertThat(inorder).isEqualTo(intArrayOf(1, 2, 3, 4, 5, 6, 7, 8, 9))
    }

    @Test
    fun testPreorder() {
        val tree = treeOf(
            1,/**/
            2, 6, /**/
            3, 5, 7, 8,/**/
            null, 4, null, null, null, null, 9, null
        )
        val preorder = preorder(tree)
        assertThat(preorder).isEqualTo(intArrayOf(1, 2, 3, 4, 5, 6, 7, 8, 9))
    }

    @Test
    fun testPostorder() {
        val tree = treeOf(
            1,/**/
            2, 3, /**/
            4, 5, 6, 7,/**/
            null, 8, null, null, null, null, 9, null
        )
        val postorder = postorder(tree)
        assertThat(postorder).isEqualTo(intArrayOf(8, 4, 5, 2, 6, 9, 7, 3, 1))
    }
}