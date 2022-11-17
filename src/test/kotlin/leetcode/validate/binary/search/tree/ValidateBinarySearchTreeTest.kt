package leetcode.validate.binary.search.tree

import leetcode.struct.treeOf
import org.assertj.core.api.Assertions.assertThat
import org.testng.annotations.Test

internal class ValidateBinarySearchTreeTest {

    private val core: ValidateBinarySearchTree = Inorder()

    @Test
    fun test01() {
        val root = treeOf(5, 1, 4, null, null, 3, 6)
        val res = this.core.isValidBST(root)
        assertThat(res).isFalse()
    }

    @Test
    fun test02() {
        val root = treeOf(2, 1, 3)
        val res = this.core.isValidBST(root)
        assertThat(res).isTrue()
    }

    @Test
    fun test03() {
        val root = treeOf(2, 2, 2)
        val res = this.core.isValidBST(root)
        assertThat(res).isFalse()
    }

    @Test
    fun test04() {
        val root = treeOf(1, 1)
        val res = this.core.isValidBST(root)
        assertThat(res).isFalse()
    }

    @Test
    fun test05() {
        val root = treeOf(5, 4, 6, null, null, 3, 7)
        val res = this.core.isValidBST(root)
        assertThat(res).isFalse()
    }

    @Test
    fun test06() {
        val root = treeOf(32, 26, 47, 19, null, null, 56, null, 27)
        val res = this.core.isValidBST(root)
        assertThat(res).isFalse()
    }

}
