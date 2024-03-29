package leetcode.linked.list.cycle

import leetcode.annotation.SolvingDate
import leetcode.struct.ListNode

// DATE 2022-10-26
@SolvingDate(2022, 10, 26)
class SlowFast : LinkedListCycleI {

    override fun hasCycle(head: ListNode?): Boolean {
        var slow = head
        var fast = head?.next

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