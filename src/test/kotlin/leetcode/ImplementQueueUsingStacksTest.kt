package leetcode

import org.assertj.core.api.Assertions.assertThat
import org.testng.annotations.Test

internal class ImplementQueueUsingStacksTest {

    @Test
    fun test0() {
        val queue = ImplementQueueUsingStacks.MyQueue()
        queue.push(1)

        assertThat(queue.peek()).isEqualTo(1)
        assertThat(queue.peek()).isEqualTo(1)

        assertThat(queue.pop()).isEqualTo(1)

        queue.push(2)
        queue.push(3)
        queue.push(4)

        assertThat(queue.peek()).isEqualTo(2)
        assertThat(queue.peek()).isEqualTo(2)

        assertThat(queue.pop()).isEqualTo(2)
        assertThat(queue.pop()).isEqualTo(3)
        assertThat(queue.pop()).isEqualTo(4)

    }
}