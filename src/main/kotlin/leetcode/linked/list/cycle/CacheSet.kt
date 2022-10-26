package leetcode.linked.list.cycle

// 2022-10-26
class CacheSet : LinkedListCycleI {

    override fun hasCycle(head: ListNode?): Boolean {
        val cache = mutableSetOf<ListNode>()
        var node = head
        while (node != null) {
            if (!cache.add(node)) {
                return true
            }
            node = node.next
        }
        return false
    }

}