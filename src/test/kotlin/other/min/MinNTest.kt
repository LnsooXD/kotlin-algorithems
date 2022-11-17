package other.min

import org.assertj.core.api.Assertions.assertThat
import org.testng.annotations.Test

internal class MinNTest {

    private val core = Reduce()

    @Test
    fun test01() {
        val res = core.min(12, -54, 33, 13245, 33, -109)
        assertThat(res).isEqualTo(-109)
    }
}