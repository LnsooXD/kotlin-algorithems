package leetcode.remove.nth.node.from.end.of.list

import leetcode.struct.ListNode

// https://leetcode.cn/problems/remove-nth-node-from-end-of-list/submissions/

class RemoveNthNodeFromEndOfListOld {
    fun removeNthFromEnd(head: ListNode?, n: Int): ListNode? {
        if (head == null) {
            return head
        }

        if (n <= 0) {
            return head
        }

        var size = 0

        var cur: ListNode = head

        while(true) {
            val next = cur.next
            size ++
            if (next == null) {
                break
            }
            cur = next
        }

        if (n > size) {
            return head
        }

        if (size == 1) {
            return null
        }

        if (size == n) {
            return head.next
        }

        var i = size - n - 1
        cur = head

        while (i > 0) {
            cur = cur.next!!
            i --
        }

        val delete = cur.next!!


        cur.next = delete.next

        return head
    }
}
