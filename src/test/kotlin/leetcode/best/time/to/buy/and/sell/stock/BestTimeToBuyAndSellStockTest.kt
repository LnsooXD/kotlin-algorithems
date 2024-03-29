package leetcode.best.time.to.buy.and.sell.stock

import org.assertj.core.api.Assertions.assertThat
import org.testng.annotations.Test

internal class BestTimeToBuyAndSellStockTest {

    private val core = MaxMin()

    @Test
    fun test() {
        val prices = intArrayOf(7, 1, 5, 3, 6, 4)
        val res = this.core.maxProfit(prices)

        assertThat(res).isEqualTo(5)
    }
}