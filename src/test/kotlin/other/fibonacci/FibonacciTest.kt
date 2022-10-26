package other.fibonacci

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class FibonacciTest {

    private val core = Matrix()

    @Test
    fun test01() {
        val n = 5
        val res = this.core.calculate(n)
        assertThat(res).isEqualTo(5)
    }

    @Test
    fun test02() {
        val n = 20
        val res = this.core.calculate(n)
        assertThat(res).isEqualTo(6765)
    }
}