package leetcode.remove.nth.node.from.end.of.list

import leetcode.annotation.SolvingDate
import leetcode.struct.ListNode

@SolvingDate(2022, 11, 15)
class ArrayIndexed : RemoveNthNodeFromEndOfList {
    override fun removeNthFromEnd(head: ListNode?, n: Int): ListNode? {
        if (head == null) {
            return null
        }

        val dummy = ListNode(0).apply { this.next = head }
        val array = arrayListOf<ListNode>()
        array.add(dummy)

        var size = 0
        var node: ListNode? = dummy.next

        while (node != null) {
            array.add(node)
            size++
            node = node.next
        }

        array[size - n].run { this.next = this.next?.next }
        return dummy.next
    }
}