package leetcode.reverse.nodes.`in`.k.group

import leetcode.struct.ListNode

class Recursion : ReverseNodesInKGroupI {
    override fun reverseKGroup(head: ListNode?, k: Int): ListNode? {
        if (head?.next == null) {
            return head
        }
        return reverseKGroup(head, head, 1, k)
    }

    private fun reverseKGroup(head: ListNode?, tail: ListNode, i: Int, k: Int): ListNode? {
        val next = head?.next
            ?: return if (i == k) {
                head
            } else {
                tail
            }


        return if (i == k) {
            val sub = reverseKGroup(next, next, 1, k)
            tail.next = sub
            head
        } else {
            val sub = reverseKGroup(next, tail, i + 1, k)
            if (sub != tail) {
                next.next = head
                if (head.next == next) {
                    head.next = null
                }
            }
            sub
        }
    }

}