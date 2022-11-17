package leetcode.container.with.most.water

import org.assertj.core.api.Assertions.assertThat
import org.testng.annotations.Test

internal class ContainerWithMostWaterTest {

    private val core = Greedy()

    @Test
    fun test01() {
        val height = intArrayOf(1, 1)
        val res = this.core.maxArea(height)
        assertThat(res).describedAs("height: ${height.toList()}").isEqualTo(1)
    }

    @Test
    fun test02() {
        val height = intArrayOf(1, 8, 6, 2, 5, 4, 8, 3, 7)
        val res = this.core.maxArea(height)
        assertThat(res).describedAs("height: ${height.toList()}").isEqualTo(49)
    }


}