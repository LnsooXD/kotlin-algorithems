package heap

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class MinHeapTest {

    @Test
    fun test() {
        val heap = MinHeap(10)

        heap.offer(1)

        assertThat(heap.peek()).isEqualTo(1)

        heap.offer(2)
        assertThat(heap.peek()).isEqualTo(1)


        assertThat(heap.balance(3)).isEqualTo(2)
        assertThat(heap.peek()).isEqualTo(2)

        assertThat(heap.balance(1)).isEqualTo(1)
        assertThat(heap.peek()).isEqualTo(2)
    }
}