package leetcode.best.time.to.buy.and.sell.stock.with.cooldown

class DFS : BestTimeToBuyAndSellStockWithCoolDown {

    override fun maxProfit(prices: IntArray): Int {
        return this.maxProfit(prices, 0)
    }

    fun maxProfit(prices: IntArray, startDay: Int): Int {
        if (startDay >= prices.size - 1) {
            return 0
        }
        var maxProfit = 0
        for (firstSellDay in startDay + 1 until prices.size) {
            val profit = maxProfit(prices, startDay, firstSellDay)
            if (profit > maxProfit) {
                maxProfit = profit
            }
        }
        return maxProfit
    }

    fun maxProfit(prices: IntArray, startDay: Int, firstSellDay: Int): Int {
        var maxProfit = 0
        for (i in startDay until firstSellDay) {
            val profit = prices[firstSellDay] - prices[i]
            if (profit > maxProfit) {
                maxProfit = profit
            }
        }
        return maxProfit + maxProfit(prices, firstSellDay + 2)
    }


}