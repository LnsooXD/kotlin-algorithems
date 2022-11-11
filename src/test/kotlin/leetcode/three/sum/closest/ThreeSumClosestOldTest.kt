package leetcode.three.sum.closest

import leetcode.three.sum.closest.ThreeSumClosestOld
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class ThreeSumClosestOldTest {

    private val threeSumClosest = ThreeSumClosestOld()

    @Test
    fun testThreeCloset() {
        val nums = intArrayOf(-1,2,1,-4)
        val target = 1
        val res = this.threeSumClosest.threeSumClosest(nums, target)

        assertThat(res).isEqualTo(2)
    }

    @Test
    fun testThreeCloset1() {
        val nums = intArrayOf(1,1,1,0)
        val target = 100
        val res = this.threeSumClosest.threeSumClosest(nums, target)

        assertThat(res).isEqualTo(3)
    }

    @Test
    fun testThreeCloset2() {

        val nums = intArrayOf(-1,2,1,-4)
        val target = 1
        val res = this.threeSumClosest.threeSumClosest(nums, target)

        assertThat(res).isEqualTo(2)
    }
}