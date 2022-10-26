package leetcode.reverse.linked.list

import leetcode.struct.ListNode

class ReverseLinkedList {

    fun reverseListLooped(head: ListNode?): ListNode? {
        if (head?.next == null) {
            return head
        }

        var curr = head
        var next = curr.next

        while (next != null) {
            val tmp = next.next
            next.next = curr

            curr = next
            next = tmp
        }

        head.next = null
        return curr
    }

    fun reverseListRecursive(head: ListNode?): ListNode? {
        if (head?.next == null) {
            return head
        }

        val res = reverseListRecursiveNonNull(head)
        head.next = null
        return res

    }

    private fun reverseListRecursiveNonNull(head: ListNode): ListNode {
        val next = head.next ?: return head
        val sub = reverseListRecursiveNonNull(next)
        next.next = head
        return sub
    }

}