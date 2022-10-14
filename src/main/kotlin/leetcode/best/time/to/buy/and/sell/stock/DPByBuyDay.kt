package leetcode.best.time.to.buy.and.sell.stock


// let DP[i]: the max profit when buy stock in ith day
// then
// DP[i] = max(DP[i + 1] + (prices[i + 1] - prices[i]), prices[i + 1] - prices[i])
// =>
// DP[i] = prices[i + 1] - prices[i] + if (DP[i + 1] > 0) DP[i + 1] else 0

class DPByBuyDay : BestTimeToBuyAndSellStock {
    override fun maxProfit(prices: IntArray): Int {
        var res = 0
        var maxProfitOfDayN = 0

        for (i in (0 until prices.size - 1).reversed()) {
            maxProfitOfDayN = prices[i + 1] - prices[i] + if (maxProfitOfDayN > 0) maxProfitOfDayN else 0
            if (res < maxProfitOfDayN) {
                res = maxProfitOfDayN
            }
        }

        return res
    }

}