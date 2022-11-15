package leetcode.struct

class ListNode(var `val`: Int) {
    var next: ListNode? = null

    val comparable: Any by lazy(LazyThreadSafetyMode.SYNCHRONIZED) { ListNodeComparable(this) }
    val size: Int
        get() {
            val set = hashSetOf<ListNode>()
            var node: ListNode? = this
            while (node !== null && set.add(node)) {
                node = node.next
            }
            return set.size
        }


    // i = a + x - 1 (x ∈ [0, b))
    // slow_i = i + m * b = a + x - 1 + m * b (m ∈ [0, ∞))
    // slow_steps = slow_i
    //
    // fast_i = slow_i + n * b  (n ∈ [1, ∞), n > m)
    // [a] => fast_i - slow_i = n * b =>
    // fast_steps = (fast_i - 1) / 2 => fast_i = 2 * fast_steps + 1 => fast_i 是奇数
    // [b] fast_steps = (slow_i + n * b - 1) / 2 = (a + x - 1 + m * b + n * b - 1 ) / 2 = (a + x + (m + n) * b) / 2 - 1
    // => (a + x + (m + n) * b)  是偶数
    // fast_i - slow_i = n * b => 2 * fast_steps + 1 - slow_i = n * b
    // => [c] 2 * fast_steps + 1 - slow_steps = n * b
    // ∵ fast_steps = slow_steps, 令: slow_steps = steps
    // [c] => steps + 1 = n * b
    // steps + 1 >= a => n * b >= a
    // steps + 1 = a + x = n * b
    // m = 0 => a + x - 1 = steps => a + x >= a 成立, 说明 m = 0 有解，即说明slow在第0圈就可以和fast相遇
    // size = a + b - 1
    // size = (steps + 1) / n + a - 1
    // a + x < size
    //
    val cycleSize: Int
        get() {
            val cycledMarkNode = this.cycledMarkNode() ?: return 0
            var node = cycledMarkNode.next
            var size = 1
            while (node !== cycledMarkNode) {
                node = node?.next
                size++
            }
            return size
        }

    val values: List<Int>
        get() {
            val list = mutableListOf<Int>()
            val set = mutableSetOf<ListNode>()
            var node: ListNode? = this
            while (node != null && set.add(node)) {
                list.add(node.`val`)
                node = node.next
            }
            return list
        }


    override fun toString() = "${this.values}@${this.cycleSize}"


    fun hasCycle() = this.cycledMarkNode() !== null

    fun reverse() = this.reverser.reverse(this)

    private val reverser: ListNodeReverser = LoopedListNodeReverser()

    private fun cycledMarkNode(): ListNode? {
        var slow: ListNode? = this
        var fast = this.next
        while (fast !== null && slow !== fast) {
            slow = slow?.next
            fast = fast.next?.next
        }
        return fast
    }
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
        while (next !== null) {
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

private class ListNodeComparable(private val self: ListNode?) {
    override fun equals(other: Any?): Boolean {
        if (this.self === other || this === other) {
            return true
        } else if ((other !is ListNode && other !is ListNodeComparable) || this.self == null) {
            return false
        } else if (other is ListNodeComparable) {
            return this.equals(other.self)
        }

        if (other !is ListNode) {
            return false
        }

        return this.self.cycleSize == other.cycleSize && this.self.values == other.values
    }

    override fun toString() = this.self.toString()

    override fun hashCode() = this.self?.values.hashCode() + this.self?.cycleSize.hashCode()

}