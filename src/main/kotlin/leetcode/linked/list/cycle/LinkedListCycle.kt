package leetcode.linked.list.cycle

import leetcode.struct.ListNode

class LinkedListCycle {

    fun hasCycle(head: ListNode?): Boolean {
        if (head?.next == null) {
            return false
        }

        val duplicatedSet = hashSetOf<ListNode>()
        var node = head
        while (node != null) {
            if (!duplicatedSet.add(node)) {
                return true
            }
            node = node.next
        }

        return false
    }

    fun hasCycleSlowFast(head: ListNode?): Boolean {
        if (head?.next == null) {
            return false
        }

        var slow = head
        var fast = head.next

        while (slow != null && fast != null) {
            if (slow == fast) {
                return true
            }
            slow = slow.next
            fast = fast.next?.next
        }

        return false
    }
}