package leetcode

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class ReverseNodesInKGroupTest {

    private val core = ReverseNodesInKGroup()

    @Test
    fun testReverseKGroup1() {
        val head = listNodeOf(1, 2, 3, 4, 5)
        val res = this.core.reverseKGroup(head, 2)
        assertThat(res).isEqualTo(listNodeOf(2, 1, 4, 3, 5))
    }

}