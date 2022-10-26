package leetcode.linked.list.cycle.ii

import leetcode.struct.cycledListNodeOf
import org.assertj.core.api.Assertions
import org.junit.jupiter.api.Test

internal class LinkedListCycleIITest {

    private val core = Cache()

    @Test
    fun test00() {
        val input = cycledListNodeOf(-1, 1, 2, 3, 4)
        val res = core.detectCycle(input)
        Assertions.assertThat(res).isNull()
    }


    @Test
    fun test01() {
        val input = cycledListNodeOf(3, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10)
        val res = core.detectCycle(input)
        Assertions.assertThat(res?.`val`).isEqualTo(4)
    }

    @Test
    fun test02() {
        val input = cycledListNodeOf(-1, 1)
        val res = core.detectCycle(input)
        Assertions.assertThat(res).isNull()
    }
}