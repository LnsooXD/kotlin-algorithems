package leetcode.best.time.to.buy.and.sell.stock.with.cooldown

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class BestTimeToBuyAndSellStockWithCoolDownTest {

    private val core = DFS()

    @Test
    fun test() {
        val prices = intArrayOf(1, 2, 3, 0, 2)
        val res = this.core.maxProfit(prices)
        assertThat(res).isEqualTo(3)
    }
}