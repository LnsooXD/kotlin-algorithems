package leetcode

class LinkedListCycleII {

    class ListNode(var `val`: Int) {
        var next: ListNode? = null
    }

    fun detectCycle(head: ListNode?): ListNode? {
        if (head?.next== null) {
            return null
        }

        val set = hashSetOf<ListNode>()

        var node = head
        while(node != null) {
            if (!set.add(node)) {
                return node
            }
            node = node.next
        }
        return null
    }

//    fun detectCycleFastSlow(head: ListNode?): ListNode? {
//
//    }

}