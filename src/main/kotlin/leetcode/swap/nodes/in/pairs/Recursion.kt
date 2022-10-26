package leetcode.swap.nodes.`in`.pairs

import leetcode.struct.ListNode

// 2022-10-26
class Recursion : SwapNodesInPairsI {
    override fun swapPairs(head: ListNode?): ListNode? {
        val next = head?.next ?: return head
        head.next = swapPairs(next.next)
        next.next = head
        return next
    }
}