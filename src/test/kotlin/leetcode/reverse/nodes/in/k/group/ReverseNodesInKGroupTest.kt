package leetcode.reverse.nodes.`in`.k.group

import leetcode.struct.listNodeOf
import org.assertj.core.api.Assertions.assertThat
import org.testng.annotations.Test

internal class ReverseNodesInKGroupTest {

    private val core = Recursion()

    @Test
    fun testReverseKGroup0() {
        val head = listNodeOf(1, 2)
        val res = this.core.reverseKGroup(head, 2)
        assertThat(res?.hasCycle()).isFalse()
        assertThat(res?.values).isEqualTo(listOf(2, 1))
    }

    @Test
    fun testReverseKGroup1() {
        val head = listNodeOf(1, 2, 3, 4, 5)
        val res = this.core.reverseKGroup(head, 2)
        assertThat(res?.hasCycle()).isFalse()
        assertThat(res?.values).isEqualTo(listOf(2, 1, 4, 3, 5))
    }

    @Test
    fun testReverseKGroup2() {
        val head = listNodeOf(1, 2, 3, 4, 5)
        val res = this.core.reverseKGroup(head, 3)
        assertThat(res?.hasCycle()).isFalse()
        assertThat(res?.values).isEqualTo(listOf(3, 2, 1, 4, 5))
    }

    @Test
    fun testReverseKGroup3() {
        val head = listNodeOf(1, 2)
        val res = this.core.reverseKGroup(head, 3)
        assertThat(res?.hasCycle()).isFalse()
        assertThat(res?.values).isEqualTo(listOf(1, 2))
    }

}