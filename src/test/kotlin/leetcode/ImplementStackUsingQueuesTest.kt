package leetcode

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class ImplementStackUsingQueuesTest {

    @Test
    fun test() {
        val stack = ImplementStackUsingQueues.MyStack()

        stack.push(1)

        assertThat(stack.top()).isEqualTo(1)
        assertThat(stack.top()).isEqualTo(1)

        assertThat(stack.pop()).isEqualTo(1)

        stack.push(2)
        stack.push(3)
        stack.push(4)

        assertThat(stack.top()).isEqualTo(4)
        assertThat(stack.top()).isEqualTo(4)

        assertThat(stack.pop()).isEqualTo(4)
        assertThat(stack.pop()).isEqualTo(3)
        assertThat(stack.pop()).isEqualTo(2)
    }

}