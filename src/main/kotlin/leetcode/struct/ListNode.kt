package leetcode.struct

class ListNode(var `val`: Int) {
    var next: ListNode? = null

    override fun toString(): String {
        val res = mutableListOf<Int>()

        var p: ListNode? = this
        while (true) {
            res.add(p!!.`val`)
            p = p.next
            if (p == null) {
                break
            }
        }

        return res.toString()
    }

    fun reverse() = this.reverser.reverse(this)

    override fun equals(other: Any?): Boolean {
        if (other == null || other !is ListNode) {
            return false
        }

        if (this.`val` != other.`val`) {
            return false
        }

        val thisNext = this.next
        val otherNext = other.next

        if (thisNext == null) {
            return otherNext == null
        }

        return thisNext == otherNext
    }

    override fun hashCode(): Int {
        var result = this.`val`
        result = 31 * result + (this.next?.hashCode() ?: 0)
        return result
    }

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