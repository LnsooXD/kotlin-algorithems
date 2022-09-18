package leetcode

// https://leetcode.cn/problems/merge-two-sorted-lists/

class MergeTwoSortedLists {

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

    fun mergeTwoLists1(list1: ListNode?, list2: ListNode?): ListNode? {
        if (list1 == null) {
            return list2
        } else if (list2 == null) {
            return list1
        }

        val isList1First = list1.`val` < list2.`val`

        val head: ListNode = if (isList1First) list1 else list2
        var src: ListNode = if (isList1First) list2 else list1
        var dst: ListNode = head

        while(true) {
            val dstNext = dst.next
            if (dstNext == null) {
                dst.next = src
                break
            } else {
                if (src.`val` >= dst.`val` && src.`val` < dstNext.`val`) {
                    val srcNext = src.next
                    src.next = dstNext
                    dst.next = src
                    dst = src
                    if (srcNext == null) {
                        break
                    } else {
                        src = srcNext
                    }
                } else {
                    dst = dstNext
                }
            }
        }
        return head
    }


}