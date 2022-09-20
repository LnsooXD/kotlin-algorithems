package leetcode.struct

import org.junit.jupiter.api.Test

internal class BinarySearchTreeTest {

    @Test
    fun inorderBinarySearchTree() {
        val src = intArrayOf(4, 5, 3, 7, 9, 1, 6, 2, 8)
        val binarySearchTree = BinarySearchTree()
        for (value in src) {
            binarySearchTree.insert(value)
        }

        val dst = binarySearchTree.inorder()
        println(dst.toList())
    }

}