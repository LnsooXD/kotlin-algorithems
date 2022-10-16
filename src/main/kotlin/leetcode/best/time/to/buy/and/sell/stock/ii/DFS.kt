package leetcode.best.time.to.buy.and.sell.stock.ii

class DFS : BestTimeToBuyAndSellStockII {

    override fun maxProfit(prices: IntArray) = this.maxProfit(prices, 0)

    private fun maxProfit(prices: IntArray, startDay: Int): Int {
        if (startDay >= prices.size - 1) {
            return 0
        }
        var maxProfit = 0
        for (firstSellDay in startDay + 1 until prices.size) {
            val profit = this.maxProfit(prices, startDay, firstSellDay)
            if (profit > maxProfit) {
                maxProfit = profit
            }
        }
        return maxProfit
    }

    private fun maxProfit(prices: IntArray, startDay: Int, firstSellDay: Int): Int {
        var maxProfit = Int.MIN_VALUE
        for (i in startDay until firstSellDay) {
            val profit = prices[firstSellDay] - prices[i]
            if (profit > maxProfit) {
                maxProfit = profit
            }
        }
        return maxProfit + this.maxProfit(prices, firstSellDay + 1)
    }

}