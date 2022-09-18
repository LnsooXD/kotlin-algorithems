package leetcode

// https://leetcode.cn/problems/merge-k-sorted-lists/

class MergeKSortedLists {

    fun mergeKLists(lists: Array<ListNode?>): ListNode? {
        val nodes = lists.filterNotNull()
        if (nodes.isEmpty()) {
            return null
        } else if (nodes.size == 1) {
            return nodes[0]
        }

        var list = nodes[0]

        for (i in 1 until nodes.size) {
            val merged = mergeTwoLists(list, nodes[i])
            if (merged != null) {
                list = merged
            }
        }

        return list
    }

    fun mergeTwoLists(list1: ListNode?, list2: ListNode?): ListNode? {
        if (list1 == null) {
            return list2
        } else if (list2 == null) {
            return list1
        }

        return if (list1.`val` < list2.`val`) {
            list1.next = mergeTwoLists(list1.next, list2)
            list1
        } else {
            list2.next = mergeTwoLists(list1, list2.next)
            list2
        }
    }

}