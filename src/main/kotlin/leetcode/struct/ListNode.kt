package leetcode.struct

class ListNode(var `val`: Int) {
    var next: ListNode? = null

    override fun toString() = this.toList().toString()

    fun toList(): List<Int> {
        val list = mutableListOf<Int>()
        val cache = mutableSetOf<ListNode>()
        var node: ListNode? = this
        while (node != null && cache.add(node)) {
            list.add(node.`val`)
            node = node.next
        }
        return list
    }

    fun hasCycle(): Boolean {
        var slow: ListNode? = this
        var fast = this.next

        while (slow != null && fast != null) {
            if (slow == fast) {
                return true
            }
            slow = slow.next
            fast = fast.next?.next

        }
        return false
    }

    fun reverse() = this.reverser.reverse(this)

    private val reverser: ListNodeReverser = LoopedListNodeReverser()
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

interface ListNodeReverser {
    fun reverse(node: ListNode): ListNode
}

class LoopedListNodeReverser : ListNodeReverser {
    override fun reverse(node: ListNode): ListNode {
        var res = node
        var next = res.next
        res.next = null
        while (next != null) {
            val nnext = next.next
            next.next = res
            res = next
            next = nnext
        }
        return res
    }
}

class RecursiveListNodeReverser : ListNodeReverser {

    override fun reverse(node: ListNode): ListNode {
        val res = this.reverseNullable(node)
        node.next = null
        return res
    }

    // https://zhuanlan.zhihu.com/p/86745433
    private fun reverseNullable(node: ListNode): ListNode {
        // 只有一个节点对时候，反转也是他自己。从函数定义上思考, 让行为统一化
        val next = node.next ?: return node

        // 把当前链表分成两部分，同时反转子链表
        val reversed = reverseNullable(next)

        // 把当前节点并入子链表
        next.next = node

        // 返回完整链表
        return reversed
    }

}