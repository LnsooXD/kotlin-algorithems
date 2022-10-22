package heap

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class MinHeapTest {

    @Test
    fun test01() {
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

    @Test
    fun test02() {
        val heap = MinHeap(10)

        heap.offer(1)

        assertThat(heap.peek()).isEqualTo(1)

        heap.offer(2)
        assertThat(heap.peek()).isEqualTo(1)

        heap.offer(3)
        assertThat(heap.peek()).isEqualTo(1)


        assertThat(heap.poll()).isEqualTo(1)
        assertThat(heap.peek()).isEqualTo(2)

        assertThat(heap.poll()).isEqualTo(2)
        assertThat(heap.peek()).isEqualTo(3)

        heap.offer(1)
        assertThat(heap.poll()).isEqualTo(1)
        assertThat(heap.peek()).isEqualTo(3)


    }

    @Test
    fun test03() {
        val heap = MinHeap(8)
        intArrayOf(3, 4, 3, 9, 5, 10, 4).forEach(heap::offer)

        heap.offer(2)
        heap.poll()

        heap.offer(4)
        heap.poll()


    }

}