package leetcode.four.sum

import org.assertj.core.api.Assertions.assertThat
import org.testng.annotations.Test
import kotlin.system.measureNanoTime

internal class FourSumTest {

    private val core = AsThreeSunTwoPointers()

    @Test
    fun test01() {
        val nums = intArrayOf(1, 0, -1, 0, -2, 2)
        val target = 0
        val res = this.core.fourSum(nums, target)
        assertThat(res.toSet()).describedAs("nums=${nums.toList()}, target=$target").isEqualTo(
            setOf(
                listOf(-2, -1, 1, 2).sorted(),
                listOf(-2, 0, 0, 2).sorted(),
                listOf(-1, 0, 0, 1).sorted(),
            )
        )
    }

    @Test
    fun test02() {
        val nums = intArrayOf(2, 2, 2, 2, 2)
        val target = 8
        val res = this.core.fourSum(nums, target)
        assertThat(res.toSet()).describedAs("nums=${nums.toList()}, target=$target").isEqualTo(
            setOf(
                listOf(2, 2, 2, 2).sorted()
            )
        )
    }

    @Test
    fun test03() {
        val nums = IntArray(2000) { 2 }
        val target = 8
        val cost = measureNanoTime {
            val res = this.core.fourSum(nums, target)
            assertThat(res.toSet()).describedAs("nums=${nums.toList()}, target=$target").isEqualTo(
                setOf(
                    listOf(2, 2, 2, 2).sorted()
                )
            )
        }

        println("cost: $cost ns")
    }

    @Test
    fun test04() {
        val count = 100
        val nums = IntArray(count) { it }
        val target = count + count
        val cost = measureNanoTime {
            this.core.fourSum(nums, target)
        }
        println("cost: $cost ns")
    }

    @Test
    fun test05() {
        val nums = intArrayOf(-3, -2, -1, 0, 0, 1, 2, 3)
        val target = 0
        val res = this.core.fourSum(nums, target)
        assertThat(res.toSet()).describedAs("nums=${nums.toList()}, target=$target").isEqualTo(
            setOf(
                listOf(-3, -2, 2, 3).sorted(),
                listOf(-3, -1, 1, 3).sorted(),
                listOf(-3, 0, 0, 3).sorted(),
                listOf(-3, 0, 1, 2).sorted(),
                listOf(-2, -1, 0, 3).sorted(),
                listOf(-2, -1, 1, 2).sorted(),
                listOf(-2, 0, 0, 2).sorted(),
                listOf(-1, 0, 0, 1).sorted(),
            )

        )
    }

    @Test
    fun test06() {
        val nums = intArrayOf(1000000000, 1000000000, 1000000000, 1000000000)
        val target = Int.MIN_VALUE
        val res = this.core.fourSum(nums, target)
        assertThat(res.toSet()).describedAs("nums=${nums.toList()}, target=$target").isEqualTo(
            emptySet<List<Int>>()
        )
    }
}