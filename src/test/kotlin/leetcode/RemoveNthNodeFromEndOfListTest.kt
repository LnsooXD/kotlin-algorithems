package leetcode

import org.junit.jupiter.api.Test

internal class RemoveNthNodeFromEndOfListTest {

    private val core = RemoveNthNodeFromEndOfList()

    @Test
    fun testRemoveNthFromEnd1() {

        val head = listNodeOf(1,2,3,4,5)
        println(head)
        val n = 2
        val res = this.core.removeNthFromEnd(head, n)
        println(res)
    }

    @Test
    fun testRemoveNthFromEnd2() {
        val head = listNodeOf(1)
        println(head)
        val n = 1
        val res = this.core.removeNthFromEnd(head, n)
        println(res)
    }
}