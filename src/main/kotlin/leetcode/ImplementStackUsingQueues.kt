package leetcode

import java.util.*

// https://leetcode.cn/problems/implement-stack-using-queues/

class ImplementStackUsingQueues {

    class MyStack() {
        fun push(x: Int) {
            val n = queue.size
            this.queue.offer(x)
            for (i in 0 until n) {
                this.queue.offer(this.queue.poll())
            }
        }
        fun pop() = this.queue.poll()
        fun top() = this.queue.peek()
        fun empty() = this.queue.isEmpty()

        private val queue: Queue<Int> = LinkedList()
    }

}