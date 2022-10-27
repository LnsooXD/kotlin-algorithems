package leetcode.reverse.linked.list

import leetcode.struct.ListNode

// DATE 2022-10-26

class Loop : ReverseLinkedListI {

    override fun reverseList(head: ListNode?): ListNode? {
        var curr: ListNode? = null
        var next = head
        while (next != null) {
            val tmp = next.next
            next.next = curr
            curr = next
            next = tmp
        }
        return curr
    }
}