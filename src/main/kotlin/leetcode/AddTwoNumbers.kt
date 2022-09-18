package leetcode

// https://leetcode.cn/problems/add-two-numbers/

class AddTwoNumbers {

    fun addTwoNumbers(l1: ListNode?, l2: ListNode?): ListNode? {
        if (l1 == null) {
            return l2
        } else if (l2 == null) {
            return l1
        }
        return addTwoNumbers(l1, l2, 0)
    }

    fun addTwoNumbers(l1: ListNode?, l2: ListNode?, carry: Int): ListNode? {
        val res = carry + (l1?.`val` ?: 0) + (l2?.`val` ?: 0)
        if (res == 0 && l1 == null && l2 == null) {
            return null
        }

        val list = addTwoNumbers(l1?.next, l2?.next, res / 10)
        val node = ListNode(res % 10)
        node.next = list
        return node
    }

}