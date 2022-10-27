package leetcode.sliding.window.maximum

import edu.princeton.cs.algs4.In
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test
import java.io.File

internal class SlidingWindowMaximumTest {

    private val core = SlidingWindowMaximumDeque()

    @Test
    fun testMaxSlidingWindow01() {
        val nums = intArrayOf(1, 3, -1, -3, 5, 3, 6, 7)
        val k = 3
        val res = this.core.maxSlidingWindow(nums, k)
        assertThat(res).isEqualTo(intArrayOf(3, 3, 5, 5, 6, 7))
    }

    @Test
    fun testMaxSlidingWindow02() {
        val nums = intArrayOf(1, 3, -1, 2, 1, 3, 6, 7)
        val k = 3
        val res = this.core.maxSlidingWindow(nums, k)
        assertThat(res).isEqualTo(intArrayOf(3, 3, 2, 3, 6, 7))
    }

    @Test
    fun testMaxSlidingWindow03() {
        val nums = intArrayOf(1, 3, -2, -1, -3, 3, 6, 7)
        val k = 3
        val res = this.core.maxSlidingWindow(nums, k)
        assertThat(res).isEqualTo(intArrayOf(3, 3, -1, 3, 6, 7))
    }

    @Test
    fun testMaxSlidingWindow04() {
        val nums = intArrayOf(9, 10, 9, -7, -4, -8, 2, -6)
        val k = 5
        val res = this.core.maxSlidingWindow(nums, k)
        assertThat(res).isEqualTo(intArrayOf(10, 10, 9, 2))
    }


    @Test
    fun testMaxSlidingWindow05() {
        val nums = intArrayOf(7, 2, 4)
        val k = 2
        val res = this.core.maxSlidingWindow(nums, k)
        assertThat(res).isEqualTo(intArrayOf(7, 4))
    }

    @Test
    fun testMaxSlidingWindow06() {
        val nums = intArrayOf(1,3,-1,-3,5,3,6,7)
        val k = 3
        val res = this.core.maxSlidingWindow(nums, k)
        assertThat(res).isEqualTo(intArrayOf(3,3,5,5,6,7))
    }

    @Test
    fun testMaxSlidingWindow07() {
        val dataDir =
            "${javaClass.packageName.replace(".", "/")}${File.separatorChar}testMaxSlidingWindow06${File.separatorChar}"
        val nums = In(javaClass.classLoader.getResource("${dataDir}nums.txt")).readAllInts()
        val k = 50000
        val start = System.nanoTime()
        val res = this.core.maxSlidingWindow(nums, k)
        println("time cost: ${System.nanoTime() - start} ns")
        val expected = In(javaClass.classLoader.getResource("${dataDir}expected.txt")).readAllInts()
        assertThat(res).isEqualTo(expected)
    }

}
