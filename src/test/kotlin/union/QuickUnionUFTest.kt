package union

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class QuickUnionUFTest {

    @Test
    fun test() {
        val union = QuickUnionUF(1000)

        union.union(0, 1)
        union.union(2, 3)

        union.union(100, 999)
        union.union(20, 78)
        union.union(100, 78)

        assertThat(union.findRoot(100) == union.findRoot(20)).isTrue()
        assertThat(union.findRoot(100) == union.findRoot(0)).isFalse()

        assertThat(union.isConnected(3, 2)).isTrue()
        assertThat(union.isConnected(100, 20)).isTrue()
        assertThat(union.isConnected(100, 2)).isFalse()
    }

}