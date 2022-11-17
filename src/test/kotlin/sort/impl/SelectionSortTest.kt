package sort.impl

import edu.princeton.cs.algs4.StdRandom
import format
import org.testng.annotations.Test
import sort.Sortable

internal class SelectionSortTest {

    private val sortable: Sortable = SelectionSort()

    @Test
    fun testSort() {
        val array = IntArray(20) { StdRandom.uniform(100) }
        println("before: ${array.format()}")
        this.sortable.sort(array)
        println("after: ${array.format()}")
    }

    @Test
    fun testSpeed() {
        val array = IntArray(10000) { StdRandom.uniform(1000000000) }
        val start = System.nanoTime()
        this.sortable.sort(array)
        println("cost: ${System.nanoTime() - start}")
    }
}

