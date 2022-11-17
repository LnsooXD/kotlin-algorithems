package leetcode.remove.nth.node.from.end.of.list

import leetcode.remove.nth.node.from.end.of.list.RemoveNthNodeFromEndOfListOld
import leetcode.struct.listNodeOf
import org.testng.annotations.Test

internal class RemoveNthNodeFromEndOfListOldTest {

    private val core = RemoveNthNodeFromEndOfListOld()

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