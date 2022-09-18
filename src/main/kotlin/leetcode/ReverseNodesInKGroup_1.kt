package leetcode

// https://leetcode.cn/problems/reverse-nodes-in-k-group/

//class ReverseNodesInKGroup_1 {
//
//    fun reverseKGroupRecursive(head: ListNode?, k: Int): ListNode? {
//        if (head == null) {
//            return head
//        }
//
//
//
//
//
//    }
//
//    fun reverse(head: ListNode): ListNode {
//        var cur = head
//        var next = head.next
//        while(next != null) {
//            val tmp = next.next
//            next.next = cur
//
//            cur = next
//            next = tmp
//        }
//        head.next = null
//        return cur
//    }
//}