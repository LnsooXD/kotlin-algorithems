package leetcode.linked.list.cycle

class ListNode(var `val`: Int) {
    var next: ListNode? = null
}

fun listNodeOf(vararg elements: Int): ListNode? = if (elements.isNotEmpty()) {
    val head = ListNode(elements[0])
    var curr = head

    for (i in 1 until elements.size) {
        val next = ListNode(elements[i])
        curr.next = next
        curr = next
    }
    head
} else null