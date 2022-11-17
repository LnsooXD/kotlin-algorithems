package leetcode.struct

import org.assertj.core.api.Assertions.assertThat
import org.testng.annotations.Test

internal class BinarySearchTreeTest {

    @Test
    fun inorderBinarySearchTree() {
        val src = intArrayOf(4, 5, 3, 7, 9, 1, 6, 2, 8)
        val binarySearchTree = BinarySearchTree()
        for (value in src) {
            binarySearchTree.insert(value)
        }

        val dst = binarySearchTree.inorder()
        assertThat(dst).isEqualTo(intArrayOf(1, 2, 3, 4, 5, 6, 7, 8, 9))
    }

}