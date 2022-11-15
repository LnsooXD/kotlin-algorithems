package leetcode.remove.nth.node.from.end.of.list

import leetcode.annotation.SolvingDate
import leetcode.struct.ListNode

@SolvingDate(2022, 11, 15)
class Rude : RemoveNthNodeFromEndOfList {
    override fun removeNthFromEnd(head: ListNode?, n: Int): ListNode? {
        if (head == null) {
            return null
        }

        val dummy = ListNode(0).apply { this.next = head }

        var size = 0
        var node: ListNode? = dummy

        while (node != null) {
            size++
            node = node.next
        }

        val target = size - n
        if (target < 0) {
            return head
        }

        node = dummy
        for (i in 0 until target - 1) {
            node = node?.next
        }
        node?.next = node?.next?.next
        return dummy.next
    }
}