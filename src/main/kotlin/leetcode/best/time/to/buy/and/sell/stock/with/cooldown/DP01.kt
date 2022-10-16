package leetcode.best.time.to.buy.and.sell.stock.with.cooldown

class DP01 : BestTimeToBuyAndSellStockWithCoolDown {

    override fun maxProfit(prices: IntArray): Int {
        val profits = IntArray(prices.size - 1)
        for (i in profits.indices) {
            profits[i] = prices[i + 1] - prices[i]
        }
        return this.maxProfit(profits, prices.size - 1)
    }

    fun maxProfit(profits: IntArray, endDay: Int): Int {
        if (endDay <= 0) {
            return 0
        }
        var maxProfit = 0

        val maxBuyProfits = IntArray(endDay)
        maxBuyProfits[endDay - 1] = profits[endDay - 1]

        for (lastBuyDay in (0 until endDay - 1).reversed()) {
            val preMaxBuyProfit = maxBuyProfits[lastBuyDay + 1]
            maxBuyProfits[lastBuyDay] = profits[lastBuyDay] + if (preMaxBuyProfit > 0) preMaxBuyProfit else 0
        }

        for (lastBuyDay in 0 until endDay) {
            val profit = maxBuyProfits[lastBuyDay] + maxProfit(profits, lastBuyDay - 2)
            if (profit > maxProfit) {
                maxProfit = profit
            }
        }
        return maxProfit
    }


}