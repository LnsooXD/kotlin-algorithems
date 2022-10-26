package leetcode.linked.list.cycle.ii

import leetcode.struct.ListNode

class Cache : LinkedListCycleII {

    override fun detectCycle(head: ListNode?): ListNode? {
        val cache = mutableSetOf<ListNode>()
        var node = head
        while (node != null && cache.add(node)) {
            node = node.next
        }
        return node
    }
}