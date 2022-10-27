package leetcode.reverse.linked.list

import leetcode.struct.ListNode

// DATE 2022-10-26
class Recursion : ReverseLinkedListI {

    override fun reverseList(head: ListNode?): ListNode? {
        val sub = head?.next ?: return head
        val reversedSub = reverseList(sub)
        sub.next = head
        return reversedSub
    }
}