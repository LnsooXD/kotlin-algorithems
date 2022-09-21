package leetcode.best.time.to.buy.and.sell.stock.ii

class Greedy : BestTimeToBuyAndSellStockII {

    override fun maxProfit(prices: IntArray): Int {
        if (prices.size <= 1) {
            return 0
        }

        var prev: Int = prices[0]
        var profit = 0

        for (i in 1 until prices.size) {
            val price = prices[i]
            if (price > prev) {
                profit += price - prev
            }
            prev = price
        }
        return profit
    }
}