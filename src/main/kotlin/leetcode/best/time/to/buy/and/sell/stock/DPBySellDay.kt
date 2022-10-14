package leetcode.best.time.to.buy.and.sell.stock


// let DP[i]: the max profit when sell stock in ith day
// then
// DP[i] = max(DP[i - 1] - prices[i - 1] + prices[i], prices[i] - prices[i - 1])

class DPBySellDay : BestTimeToBuyAndSellStock {
    override fun maxProfit(prices: IntArray): Int {
        var res = 0
        var maxProfitOfDayN = 0

        for (i in 1 until prices.size) {
            maxProfitOfDayN = prices[i] - prices[i - 1] + if (maxProfitOfDayN > 0) maxProfitOfDayN else 0
            if (res < maxProfitOfDayN) {
                res = maxProfitOfDayN
            }
        }

        return res
    }

}