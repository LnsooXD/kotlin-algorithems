package search

import org.assertj.core.api.Assertions.assertThat
import org.testng.annotations.Test

internal class BinarySearchTest {
    private val core = BinarySearch()

    @Test
    fun test01() {
        val values = intArrayOf(1, 9, 120, 234, 444, 999, 10001)
        val target = 444
        val res = this.core.search(values, target)
        assertThat(res).isEqualTo(4)
    }

    @Test
    fun test02() {
        val values = intArrayOf()
        val target = 444
        val res = this.core.search(values, target)
        assertThat(res).isEqualTo(-1)
    }

    @Test
    fun test03() {
        val values = intArrayOf(1, 9, 120, 234, 444, 999, 10001)
        val target = 445
        val res = this.core.search(values, target)
        assertThat(res).isEqualTo(-1)
    }

    @Test
    fun test04() {
        val values = intArrayOf(1, 9, 120, 234, 444, 999, 10001)
        val target = 1
        val res = this.core.search(values, target)
        assertThat(res).isEqualTo(0)
    }

    @Test
    fun test05() {
        val values = intArrayOf(1, 9, 120, 234, 444, 999, 10001)
        val target = 10001
        val res = this.core.search(values, target)
        assertThat(res).isEqualTo(values.size - 1)
    }
}