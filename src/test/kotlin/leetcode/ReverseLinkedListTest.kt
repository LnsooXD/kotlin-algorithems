package leetcode

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class ReverseLinkedListTest {

    private val core = ReverseLinkedList()

    @Test
    fun testReverseListLooped0() {
        val list = null
        val res = this.core.reverseListLooped(list)
        assertThat(res).isNull()
    }

    @Test
    fun testReverseListLooped1() {
        val list = listNodeOf(1)
        val res = this.core.reverseListLooped(list)
        assertThat(res).isEqualTo(listNodeOf(1))
    }

    @Test
    fun testReverseListLooped2() {
        val list = listNodeOf(1, 2)
        val res = this.core.reverseListLooped(list)
        assertThat(res).isEqualTo(listNodeOf(2, 1))
    }

    @Test
    fun testReverseListLooped3() {
        val list = listNodeOf(1, 2, 3, 4, 5)
        val res = this.core.reverseListLooped(list)
        assertThat(res).isEqualTo(listNodeOf(5, 4, 3, 2, 1))
    }

    @Test
    fun testReverseListRecursive0() {
        val list = null
        val res = this.core.reverseListRecursive(list)
        assertThat(res).isNull()
    }

    @Test
    fun testReverseListRecursive1() {
        val list = listNodeOf(1)
        val res = this.core.reverseListRecursive(list)
        assertThat(res).isEqualTo(listNodeOf(1))
    }

    @Test
    fun testReverseListRecursive2() {
        val list = listNodeOf(1, 2)
        val res = this.core.reverseListRecursive(list)
        assertThat(res).isEqualTo(listNodeOf(2, 1))
    }

    @Test
    fun testReverseListRecursive3() {
        val list = listNodeOf(1, 2, 3, 4, 5)
        val res = this.core.reverseListRecursive(list)
        assertThat(res).isEqualTo(listNodeOf(5, 4, 3, 2, 1))
    }
}