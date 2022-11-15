package leetcode.remove.nth.node.from.end.of.list

import leetcode.struct.listNodeOf
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class RemoveNthNodeFromEndOfListTest {
    private val core = ArrayIndexed()

    @Test
    fun testRemoveNthFromEnd1() {

        val head = listNodeOf(1, 2, 3, 4, 5)
        val n = 2
        val res = this.core.removeNthFromEnd(head, n)
        assertThat(res?.values ?: emptyList()).describedAs("head=${head?.values}, n=$n").isEqualTo(listOf(1, 2, 3, 5))
    }

    @Test
    fun testRemoveNthFromEnd2() {
        val head = listNodeOf(1)
        val n = 1
        val res = this.core.removeNthFromEnd(head, n)
        assertThat(res?.values ?: emptyList()).describedAs("head=${head?.values}, n=$n").isEqualTo(listOf<Int>())
    }


    @Test
    fun testRemoveNthFromEnd3() {
        val head = listNodeOf(1, 2)
        val n = 2
        val res = this.core.removeNthFromEnd(head, n)
        assertThat(res?.values ?: emptyList()).describedAs("head=${head?.values}, n=$n").isEqualTo(listOf(2))
    }
}