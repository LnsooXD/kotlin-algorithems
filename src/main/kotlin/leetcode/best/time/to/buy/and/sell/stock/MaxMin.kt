package leetcode.best.time.to.buy.and.sell.stock

class MaxMin : BestTimeToBuyAndSellStock {

    override fun maxProfit(prices: IntArray): Int {
        if (prices.size < 2) {
            return 0
        }

        var minPrice: Int = prices[0]
        var maxProfit = 0

        for (i in 1 until prices.size) {
            val price = prices[i]
            if (price > minPrice) {
                val profit = price - minPrice
                if (profit > maxProfit) {
                    maxProfit = profit
                }
            } else {
                minPrice = price
            }
        }
        return maxProfit
    }
}