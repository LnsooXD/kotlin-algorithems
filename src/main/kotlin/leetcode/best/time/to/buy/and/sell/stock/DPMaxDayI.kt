package leetcode.best.time.to.buy.and.sell.stock


// let DP[i]: the max profit when sell stock in ith day
// then
// DP[i] = max(DP[i - 1] - prices[i - 1] + prices[i], prices[i] - prices[i - 1])

class DPMaxDayI : BestTimeToBuyAndSellStock {
    override fun maxProfit(prices: IntArray): Int {
        if (prices.size < 2) {
            return 0
        }

        var res = prices[1] - prices[0]
        var maxProfitOfDayN = res

        for (i in 2 until prices.size) {
            val profitOfLastDay = prices[i] - prices[i - 1]
            maxProfitOfDayN = max(profitOfLastDay, maxProfitOfDayN + profitOfLastDay)
            res = max(res, maxProfitOfDayN)
        }

        return if (res <= 0) 0 else res
    }

    companion object {
        fun max(a: Int, b: Int) = if (a > b) a else b
    }
}