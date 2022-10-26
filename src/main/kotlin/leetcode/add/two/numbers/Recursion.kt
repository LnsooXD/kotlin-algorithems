package leetcode.add.two.numbers

import leetcode.struct.ListNode

class Recursion : AddTwoNumbers {
    override fun addTwoNumbers(l1: ListNode?, l2: ListNode?): ListNode? {
        return addTwoNumbers(l1, l2, 0)
    }

    private fun addTwoNumbers(l1: ListNode?, l2: ListNode?, carry: Int): ListNode? {
        if (l1 == null && l2 == null && carry == 0) {
            return null
        }

        val sum = carry + (l1?.`val` ?: 0) + (l2?.`val` ?: 0)
        return ListNode(sum % 10).apply {
            this.next = addTwoNumbers(l1?.next, l2?.next, sum / 10)
        }
    }
}