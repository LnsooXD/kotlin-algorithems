package leetcode.best.time.to.buy.and.sell.stock.iii

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class BestTimeToBuyAndSellStockIIITest {

    private val core = DP02()

    @Test
    fun test() {
        val prices = intArrayOf(3, 3, 5, 0, 0, 3, 1, 4)
        val res = this.core.maxProfit(prices)

        assertThat(res).isEqualTo(6)
    }
}