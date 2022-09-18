package leetcode

import java.util.*

// https://leetcode.cn/problems/implement-queue-using-stacks/

class ImplementQueueUsingStacks {

    class MyQueue() {
        private val inputStack = Stack<Int>()
        private val outputStack = Stack<Int>()

        fun push(x: Int) {
            this.inputStack.push(x)
        }

        fun pop(): Int {
            this.transportIfNeeded()
            return this.outputStack.pop()
        }

        fun peek(): Int {
            this.transportIfNeeded()
            return this.outputStack.peek()
        }

        fun empty(): Boolean {
            return this.inputStack.isEmpty() && this.outputStack.isEmpty()
        }

        private fun transportIfNeeded() {
            if (this.outputStack.isEmpty()) {
                while (!this.inputStack.isEmpty()) {
                    this.outputStack.push(this.inputStack.pop())
                }
            }
        }
    }
}