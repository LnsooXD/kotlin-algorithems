package other.fibonacci

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class FibonacciTest {

    private val core = Matrix()

    @Test
    fun test00() {
        val n = 0
        val res = this.core.calculate(n)
        assertThat(res).isEqualTo(1)
    }

    @Test
    fun test01() {
        val n = 1
        val res = this.core.calculate(n)
        assertThat(res).isEqualTo(1)
    }

    @Test
    fun test02() {
        val n = 2
        val res = this.core.calculate(n)
        assertThat(res).isEqualTo(1)
    }

    @Test
    fun test03() {
        val n = 3
        val res = this.core.calculate(n)
        assertThat(res).isEqualTo(2)
    }

    @Test
    fun test05() {
        val n = 5
        val res = this.core.calculate(n)
        assertThat(res).isEqualTo(5)
    }

    @Test
    fun test020() {
        val n = 20
        val res = this.core.calculate(n)
        assertThat(res).isEqualTo(6765)
    }
}