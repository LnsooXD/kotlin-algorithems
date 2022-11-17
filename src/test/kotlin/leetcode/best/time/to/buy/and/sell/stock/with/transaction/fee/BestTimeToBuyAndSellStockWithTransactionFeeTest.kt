package leetcode.best.time.to.buy.and.sell.stock.with.transaction.fee

import org.assertj.core.api.Assertions.assertThat
import org.testng.annotations.Test

internal class BestTimeToBuyAndSellStockWithTransactionFeeTest {

    private val core = DP()

    @Test
    fun test01() {
        val prices = intArrayOf(1, 3, 2, 8, 4, 9)
        val fee = 2
        val res = this.core.maxProfit(prices, fee)
        assertThat(res).isEqualTo(8)
    }

    @Test
    fun test02() {
        val prices = intArrayOf(1, 3, 7, 5, 10, 3)
        val fee = 3
        val res = this.core.maxProfit(prices, fee)
        assertThat(res).isEqualTo(6)
    }
}