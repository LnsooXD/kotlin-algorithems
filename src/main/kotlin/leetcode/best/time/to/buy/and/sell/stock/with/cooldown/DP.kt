package leetcode.best.time.to.buy.and.sell.stock.with.cooldown

// MAX_FIRST_SELL[i] = max(MAX_FIRST_SELL[i-1] + (prices[i] - prices[i - 1]), prices[i] - prices[i - 1])
// DP[i] = MAX_FIRST_SELL[i] + MAX_PROFIT[i + 2]

class DP : BestTimeToBuyAndSellStockWithCoolDown {
    override fun maxProfit(prices: IntArray): Int {
        TODO("Not yet implemented")
    }
}