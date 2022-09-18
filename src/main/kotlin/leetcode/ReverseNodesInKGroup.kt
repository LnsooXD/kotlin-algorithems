package leetcode

// https://leetcode.cn/problems/reverse-nodes-in-k-group/

class ReverseNodesInKGroup {

    fun reverseKGroup(head: ListNode?, k: Int): ListNode? {
        if (head?.next == null) {
            return head
        }

        val headRest = reverseKHead(head, k)
        var currTail = headRest.tail
        var nextHead: ListNode? = currTail?.next

        while (nextHead != null) {
            val res = reverseKHead(nextHead, k)
            currTail?.next = res.head
            currTail = res.tail
            nextHead = currTail?.next
        }

        return headRest.head
    }

    private fun reverseKHead(head: ListNode, k: Int): Result {
        val size = size(head)
        if (size < k) {
            return Result(head, null)
        }

        var node = head
        var next = node.next
        var count = k

        while (next != null && count > 1) {
            val nnext = next.next
            next.next = node
            node = next
            next = nnext
            count--
        }
        head.next = next
        return Result(node, head)
    }

    fun size(head: ListNode?): Int {
        var size = 0
        var node = head
        while (node != null) {
            size++
            node = node.next
        }
        return size
    }

    class Result(val head: ListNode, val tail: ListNode?)
}
