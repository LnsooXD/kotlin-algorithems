package leetcode.linked.list.cycle

class ListNode(var `val`: Int) {
    var next: ListNode? = null
}

fun cycledListNodeOf(pos: Int, vararg elements: Int): ListNode? = if (elements.isNotEmpty()) {
    val head = ListNode(elements[0])
    var curr = head
    if (pos == 0) {
        curr.next = curr
    }
    for (i in 1 until elements.size) {
        val next = ListNode(elements[i])
        next.next = curr.next
        curr.next = next
        curr = next
        if (pos == i) {
            curr.next = curr
        }
    }
    head
} else null