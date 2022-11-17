package leetcode.reverse.linked.list

import leetcode.struct.listNodeOf
import org.assertj.core.api.Assertions.assertThat
import org.testng.annotations.Test

internal class ReverseLinkedListTest {

    private val core = Recursion()

    @Test
    fun testReverseList0() {
        val list = null
        val res = this.core.reverseList(list)
        assertThat(res).isNull()
    }

    @Test
    fun testReverseList1() {
        val list = listNodeOf(1)
        val res = this.core.reverseList(list)
        assertThat(res).isEqualTo(listNodeOf(1))
    }

    @Test
    fun testReverseList2() {
        val list = listNodeOf(1, 2)
        val res = this.core.reverseList(list)
        assertThat(res).isEqualTo(listNodeOf(2, 1))
    }

    @Test
    fun testReverseList3() {
        val list = listNodeOf(1, 2, 3, 4, 5)
        val res = this.core.reverseList(list)
        assertThat(res).isEqualTo(listNodeOf(5, 4, 3, 2, 1))
    }
}