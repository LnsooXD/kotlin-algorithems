package other

import leetcode.struct.listNodeOf
import org.assertj.core.api.Assertions.assertThat
import org.testng.annotations.Test

internal class SortLinkedListByValueTest {

    private val core = SortLinkedListByValue()

    @Test
    fun testSort1() {
        val list = listNodeOf(5, 6, 1, 2, 3, 4)
        val value = 3
        val res = this.core.sort(list, value)

        assertThat(res?.values).isEqualTo(listOf(1, 2, 3, 5, 6, 4))
    }

}