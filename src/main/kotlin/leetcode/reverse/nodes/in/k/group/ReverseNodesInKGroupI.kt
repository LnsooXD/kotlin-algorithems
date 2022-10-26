package leetcode.reverse.nodes.`in`.k.group

import leetcode.struct.ListNode

// 25. https://leetcode.com/problems/reverse-nodes-in-k-group/

interface ReverseNodesInKGroupI {
    fun reverseKGroup(head: ListNode?, k: Int): ListNode?
}