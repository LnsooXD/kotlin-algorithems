package leetcode.swap.nodes.`in`.pairs

import leetcode.struct.ListNode

// DATE 2022-10-26
class Loop : SwapNodesInPairsI {
    override fun swapPairs(head: ListNode?): ListNode? {
        val pointer = ListNode(0)
        pointer.next = head
        var node: ListNode? = pointer

        while (node?.next?.next != null) {
            val tmp = node.next?.next?.next
            node.next?.next?.next = node.next
            node.next = node.next?.next
            node.next?.next?.next = tmp
            node = node.next?.next
        }
        return pointer.next
    }
}