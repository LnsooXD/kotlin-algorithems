package leetcode.best.time.to.buy.and.sell.stock.with.cooldown

class DFS01 : BestTimeToBuyAndSellStockWithCoolDown {

    override fun maxProfit(prices: IntArray): Int {
        return this.maxProfit(prices, prices.size - 1)
    }

    fun maxProfit(prices: IntArray, endDay: Int): Int {
        if (endDay <= 0) {
            return 0
        }
        var maxProfit = 0
        for (lastBuyDay in 0 until endDay) {
            val profit = maxProfit(prices, endDay, lastBuyDay)
            if (profit > maxProfit) {
                maxProfit = profit
            }
        }
        return maxProfit
    }

    fun maxProfit(prices: IntArray, endDay: Int, lastBuyDay: Int): Int {
        var maxProfit = Int.MIN_VALUE
        for (i in lastBuyDay + 1..endDay) {
            val profit = prices[i] - prices[lastBuyDay]
            if (profit > maxProfit) {
                maxProfit = profit
            }
        }
        return maxProfit(prices, lastBuyDay - 2) + maxProfit
    }


}