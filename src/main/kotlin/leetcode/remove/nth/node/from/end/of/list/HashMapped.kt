package leetcode.remove.nth.node.from.end.of.list

import leetcode.annotation.SolvingDate
import leetcode.struct.ListNode

@SolvingDate(2022, 11, 15)
class HashMapped : RemoveNthNodeFromEndOfList {
    override fun removeNthFromEnd(head: ListNode?, n: Int): ListNode? {
        if (head == null) {
            return null
        }

        val dummy = ListNode(0).apply { this.next = head }
        val map = hashMapOf(Pair(-1, dummy))

        var size = 0
        var node: ListNode? = dummy.next

        while (node != null) {
            map[size++] = node
            node = node.next
        }

        map[size - n - 1].run { this?.next = this?.next?.next }
        return dummy.next
    }
}