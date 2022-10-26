package other

import leetcode.struct.ListNode

// 给定一个链表， 用 value 把它分成两半， 小数值在左边，大数值在右边。
// list = [5, 6, 1, 2, 3, 4],
// value = 3
// res = [1, 2, 3, 5, 6, 4]

// 快看面试题

class SortLinkedListByValue {

    fun sort(list: ListNode?, value: Int) : ListNode? {
        if (list?.next == null) {
            return list
        }

        val smaller = ListNode(0)
        var smallerTail = smaller

        val bigger = ListNode(0)
        var biggerTail = bigger

        val middle = ListNode(0)
        var middleTail = middle

        var current = list

        while(current != null) {
            if (current.`val` < value) {
                smallerTail.next = current
                smallerTail = current
            } else if (current.`val` > value) {
                biggerTail.next = current
                biggerTail = current
            } else {
                middleTail.next = current
                middleTail = current
            }

            current = current.next
        }

        val resHead = ListNode(0)
        var tail = resHead

        if (smaller.next != null) {
            tail.next = smaller.next
            tail = smallerTail
        }

        if (middle.next != null) {
            tail.next = middle.next
            tail = middleTail
        }

        if (bigger.next != null) {
            tail.next = bigger.next
        }
        return resHead.next
    }

}