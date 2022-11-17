package leetcode.add.two.numbers

import leetcode.struct.listNodeOf
import org.assertj.core.api.Assertions.assertThat
import org.testng.annotations.Test

internal class AddTwoNumbersTest {

    private val core = Loop()

    @Test
    fun testAddTwoNumbers0() {
        val l1 = listNodeOf(0)
        val l2 = listNodeOf(0)
        val res = this.core.addTwoNumbers(l1, l2)
        assertThat(res?.values).isEqualTo(listOf(0))
    }

    @Test
    fun testAddTwoNumbers1() {
        val l1 = listNodeOf(2, 4, 3)
        val l2 = listNodeOf(5, 6, 4)
        val res = this.core.addTwoNumbers(l1, l2)
        assertThat(res?.values).isEqualTo(listOf(7, 0, 8))
    }

    @Test
    fun testAddTwoNumbers2() {
        val l1 = listNodeOf(9, 9, 9, 9, 9, 9, 9)
        val l2 = listNodeOf(9, 9, 9, 9)
        val res = this.core.addTwoNumbers(l1, l2)
        assertThat(res?.values).isEqualTo(listOf(8, 9, 9, 9, 0, 0, 0, 1))
    }

    @Test
    fun testAddTwoNumbers3() {
        val l1 = listNodeOf(2, 4, 9)
        val l2 = listNodeOf(5, 6, 4, 9)
        val res = this.core.addTwoNumbers(l1, l2)
        assertThat(res?.values).isEqualTo(listOf(7, 0, 4, 0, 1))
    }

    @Test
    fun testAddTwoNumbers4() {
        val l1 = listNodeOf(1, 6, 0, 3, 3, 6, 7, 2, 0, 1)
        val l2 = listNodeOf(6, 3, 0, 8, 9, 6, 6, 9, 6, 1)
        val res = this.core.addTwoNumbers(l1, l2)
        assertThat(res?.values).isEqualTo(listOf(7, 9, 0, 1, 3, 3, 4, 2, 7, 2))
    }

}