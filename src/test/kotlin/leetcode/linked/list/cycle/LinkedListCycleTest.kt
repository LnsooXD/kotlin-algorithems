package leetcode.linked.list.cycle

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class LinkedListCycleTest {

    private val core = SlowFast()

    @Test
    fun test00() {
        val input = listNodeOf(1, 2, 3, 4)
        val res = core.hasCycle(input)
        assertThat(res).isFalse()
    }


    @Test
    fun test01() {
        val input = listNodeOf(1, 2, 3, 4)
        input?.next?.next = input
        val res = core.hasCycle(input)
        assertThat(res).isTrue()
    }

    @Test
    fun test02() {
        val input = ListNode(1)
        val res = core.hasCycle(input)
        assertThat(res).isFalse()
    }

}