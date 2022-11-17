package leetcode.swap.nodes.`in`.pairs

import leetcode.struct.listNodeOf
import org.assertj.core.api.Assertions.assertThat
import org.testng.annotations.Test

internal class SwapNodesInPairsTest {

    private val core = Loop()

    @Test
    fun testSwapNode0() {
        val head = null
        val res = this.core.swapPairs(head)
        assertThat(res).isEqualTo(null)
    }

    @Test
    fun testSwapNode1() {
        val head = listNodeOf(1)
        val res = this.core.swapPairs(head)
        assertThat(res).isEqualTo(listNodeOf(1))
    }

    @Test
    fun testSwapNode2() {
        val head = listNodeOf(1, 2)
        val res = this.core.swapPairs(head)
        assertThat(res).isEqualTo(listNodeOf(2, 1))
    }

    @Test
    fun testSwapNode3() {
        val head = listNodeOf(1, 2, 3)
        val res = this.core.swapPairs(head)
        assertThat(res).isEqualTo(listNodeOf(2, 1, 3))
    }

    @Test
    fun testSwapNode4() {
        val head = listNodeOf(1, 2, 3, 4)
        val res = this.core.swapPairs(head)
        assertThat(res).isEqualTo(listNodeOf(2, 1, 4, 3))
    }

    @Test
    fun testSwapNode5() {
        val head = listNodeOf(1, 2, 3, 4, 5)
        val res = this.core.swapPairs(head)
        assertThat(res).isEqualTo(listNodeOf(2, 1, 4, 3, 5))
    }


}