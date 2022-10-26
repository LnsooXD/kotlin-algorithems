package leetcode.struct

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class ListNodeTest {

    private val loopedReverser = LoopedListNodeReverser()
    private val recursiveReverser = RecursiveListNodeReverser()

    @Test
    fun testEquals() {
        val l1 = listNodeOf(1, 2, 3)
        val l2 = listNodeOf(1, 2, 3)
        val l3 = listNodeOf(4, 5, 6)

        assertThat(l1).isEqualTo(l2)
        assertThat(l1).isNotEqualTo(l3)
    }

    @Test
    fun testReverse() {
        val l1 = listNodeOf(1, 2, 3)
        val l2 = listNodeOf(3, 2, 1)

        assertThat(l1?.reverse()).isEqualTo(l2)
    }

    @Test
    fun testLoopedReverser() {
        val list = listNodeOf(1, 2, 3, 4, 5, 6) ?: throw IllegalArgumentException("list is null")
        val res = this.loopedReverser.reverse(list)
        assertThat(res).isEqualTo(listNodeOf(6, 5, 4, 3, 2, 1))
    }

    @Test
    fun testRecursiveReverser() {
        val list = listNodeOf(1, 2, 3, 4, 5, 6) ?: throw IllegalArgumentException("list is null")
        val res = this.recursiveReverser.reverse(list)
        assertThat(res).isEqualTo(listNodeOf(6, 5, 4, 3, 2, 1))
    }

}