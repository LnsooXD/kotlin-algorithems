package leetcode.struct

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class ListNodeTest {

    private val loopedReverser = LoopedListNodeReverser()
    private val recursiveReverser = RecursiveListNodeReverser()

    @Test
    fun testEquals() {
        val l1 = listNodeOf(1, 2, 3)
        val l2 = listNodeOf(1, 2, 3)
        val l3 = listNodeOf(4, 5, 6)

        assertThat(l1?.comparable).isEqualTo(l2?.comparable)
        assertThat(l1?.comparable).isNotEqualTo(l3?.comparable)
    }

    @Test
    fun testEquals01() {
        val l1 = cycledListNodeOf(1, 1, 2, 3)
        val l2 = listNodeOf(1, 2, 3)
        val l3 = cycledListNodeOf(2, 1, 2, 3)
        val l4 = cycledListNodeOf(1, 1, 2, 3)

        assertThat(l1?.comparable).isNotEqualTo(l2?.comparable)
        assertThat(l1?.comparable).isNotEqualTo(l2?.comparable)
        assertThat(l1?.comparable).isNotEqualTo(l3?.comparable)
        assertThat(l1?.comparable).isEqualTo(l4?.comparable)
    }

    @Test
    fun testReverse() {
        val l1 = listNodeOf(1, 2, 3)
        val l2 = listNodeOf(3, 2, 1)

        assertThat(l1?.reverse()?.comparable).isEqualTo(l2?.comparable)
    }

    @Test
    fun testLoopedReverser() {
        val list = listNodeOf(1, 2, 3, 4, 5, 6) ?: throw IllegalArgumentException("list is null")
        val res = this.loopedReverser.reverse(list)
        assertThat(res.values).isEqualTo(listOf(6, 5, 4, 3, 2, 1))
    }

    @Test
    fun testRecursiveReverser() {
        val list = listNodeOf(1, 2, 3, 4, 5, 6) ?: throw IllegalArgumentException("list is null")
        val res = this.recursiveReverser.reverse(list)
        assertThat(res.values).isEqualTo(listOf(6, 5, 4, 3, 2, 1))
    }

    @Test
    fun testCycleSize00() {
        val list = listNodeOf(1, 2, 3, 4, 5) ?: throw IllegalArgumentException("list is null")
        val cycleSize = list.cycleSize
        assertThat(cycleSize).isEqualTo(0)
    }

    @Test
    fun testCycleSize01() {
        val list = cycledListNodeOf(1, 1, 2, 3, 4, 5) ?: throw IllegalArgumentException("list is null")
        val cycleSize = list.cycleSize
        assertThat(cycleSize).isEqualTo(4)
    }

    @Test
    fun testCycleSize02() {
        val list = cycledListNodeOf(2, 1, 2, 3, 4, 5) ?: throw IllegalArgumentException("list is null")
        val cycleSize = list.cycleSize
        assertThat(cycleSize).isEqualTo(3)
    }

    @Test
    fun testCycleSize03() {
        val list = cycledListNodeOf(3, 1, 2, 3, 4, 5) ?: throw IllegalArgumentException("list is null")
        val cycleSize = list.cycleSize
        assertThat(cycleSize).isEqualTo(2)
    }

    @Test
    fun testCycleSize04() {
        val list = cycledListNodeOf(4, 1, 2, 3, 4, 5) ?: throw IllegalArgumentException("list is null")
        val cycleSize = list.cycleSize
        assertThat(cycleSize).isEqualTo(1)
    }

    @Test
    fun testCycleSize05() {
        val list = listNodeOf(1, 2, 3, 4, 5) ?: throw IllegalArgumentException("list is null")
        val cycleSize = list.cycleSize
        assertThat(cycleSize).isEqualTo(0)
    }

    @Test
    fun testSize1() {
        val list = listNodeOf(1, 2, 3, 4, 5) ?: throw IllegalArgumentException("list is null")
        val cycleSize = list.size
        assertThat(cycleSize).isEqualTo(5)
    }

    @Test
    fun testSize2() {
        val list = cycledListNodeOf(4, 1, 2, 3, 4, 5) ?: throw IllegalArgumentException("list is null")
        val cycleSize = list.size
        assertThat(cycleSize).isEqualTo(5)
    }

    @Test
    fun testCycle00() {
        val input = cycledListNodeOf(-1, 1, 2, 3, 4)
        val res = input?.hasCycle()
        assertThat(res).isFalse()
    }


    @Test
    fun testCycle01() {
        val input = cycledListNodeOf(3, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10)
        val res = input?.hasCycle()
        assertThat(res).isTrue()
    }

    @Test
    fun testCycle02() {
        val input = cycledListNodeOf(-1, 1)
        val res = input?.hasCycle()
        assertThat(res).isFalse()
    }

}