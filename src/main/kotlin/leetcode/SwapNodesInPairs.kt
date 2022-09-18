package leetcode

// https://leetcode.cn/problems/swap-nodes-in-pairs/

class SwapNodesInPairs {

    fun swapPairs(head: ListNode?): ListNode? {
        val next  = head?.next ?: return head
        head.next = swapPairs(next.next)
        next.next = head
        return next
    }

    fun swapPairs1(head: ListNode?): ListNode? {
        if (head?.next == null) {
            return head
        }
        val res: ListNode = swapOnePair(null, head)
        var prev = res.next
        var tmp = prev?.next

        while (tmp != null) {
            tmp = swapOnePair(prev, tmp)
            prev = tmp.next
            tmp = prev?.next
        }
        return res
    }


    fun swapPairsRecursive(head: ListNode?): ListNode? {
        val next = head?.next ?: return head
        head.next = swapPairsRecursive(next.next)
        next.next = head
        return next
    }

    fun swapPairsLooped1(head: ListNode?): ListNode? {
        val newHead = head?.next ?: return head

        head.next = newHead.next
        newHead.next = head

        var prev: ListNode = head
        var curr = prev.next ?: return newHead
        var next = curr.next

        while (next != null) {
            curr.next = next.next
            next.next = curr
            prev.next = next

            prev = curr
            curr = prev.next ?: return newHead
            next = curr.next
        }
        return newHead
    }

    fun swapPairsLooped2(head: ListNode?): ListNode? {
        val dummyHead = ListNode(0)
        dummyHead.next = head

        var pre = dummyHead

        while (true) {
            val curr = pre.next ?: return dummyHead.next
            val next = curr.next ?: return dummyHead.next

            curr.next = next.next
            next.next = curr
            pre.next = next

            pre = curr
        }
    }

    private fun swapOnePair(prev: ListNode?, node: ListNode): ListNode {
        val res = node.next ?: return node
        val resNext = res.next
        res.next = node
        node.next = resNext
        if (prev != null) {
            prev.next = res
        }
        return res
    }
}