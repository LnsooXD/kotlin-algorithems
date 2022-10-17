package leetcode.add.two.numbers

import leetcode.ListNode

class Loop : AddTwoNumbers {

    override fun addTwoNumbers(l1: ListNode?, l2: ListNode?): ListNode? {
        val head = ListNode(0)
        var resDigit = head
        var carry = 0

        var digit1 = l1
        var digit2 = l2

        while (digit1 != null || digit2 != null || carry != 0) {
            val sum = (digit1?.`val` ?: 0) + (digit2?.`val` ?: 0) + carry

            val node = ListNode(sum % 10)
            resDigit.next = node
            resDigit = node

            carry = sum / 10
            digit1 = digit1?.next
            digit2 = digit2?.next
        }
        return head.next
    }
}