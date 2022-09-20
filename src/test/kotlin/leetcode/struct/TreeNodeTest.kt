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
}