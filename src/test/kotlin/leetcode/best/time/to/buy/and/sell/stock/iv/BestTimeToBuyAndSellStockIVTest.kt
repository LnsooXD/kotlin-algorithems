package leetcode.best.time.to.buy.and.sell.stock.iv

import org.assertj.core.api.Assertions.assertThat
import org.testng.annotations.Test

internal class BestTimeToBuyAndSellStockIVTest {
    private val core = DP()

    @Test
    fun test01() {
        val prices = intArrayOf(2, 4, 1)
        val k = 2
        val res = this.core.maxProfit(k, prices)

        assertThat(res).isEqualTo(2)
    }

    @Test
    fun test02() {
        val prices = intArrayOf(3, 2, 6, 5, 0, 3)
        val k = 2
        val res = this.core.maxProfit(k, prices)

        assertThat(res).isEqualTo(7)
    }
}