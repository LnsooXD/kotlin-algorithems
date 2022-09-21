package leetcode.best.time.to.buy.and.sell.stock.ii

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class GreedyTest {

    private val core = Greedy()

    @Test
    fun testGreedy01() {
        val prices = intArrayOf(7, 1, 5, 3, 6, 4)
        val res = this.core.maxProfit(prices)
        assertThat(res).isEqualTo(7)
    }


}