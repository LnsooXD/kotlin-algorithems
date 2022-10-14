package leetcode.best.time.to.buy.and.sell.stock.iii

class DP01 : BestTimeToBuyAndSellStockIII {
    override fun maxProfit(prices: IntArray): Int {
        if (prices.size < 2) {
            return 0
        }

        var maxProfileOfPartOne = prices[1] - prices[0]
        var res = maxProfileOfPartOne + maxProfit(prices, 2)

        for (i in 2 until prices.size) {
            val profit = prices[i] - prices[i - 1]
            maxProfileOfPartOne = max(profit, maxProfileOfPartOne + profit)
            res = max(res, maxProfileOfPartOne + maxProfit(prices, i + 1))
        }

        return max(res, 0)
    }

    private fun maxProfit(prices: IntArray, startDay: Int): Int {
        if (startDay + 1 >= prices.size) {
            return 0
        }
        var res = prices[startDay + 1] - prices[startDay]
        var maxProfile = res

        for (i in startDay + 2 until prices.size) {
            val profit = prices[i] - prices[i - 1]
            maxProfile = max(profit, maxProfile + profit)
            res = max(res, maxProfile)
        }
        return max(res, 0)
    }

    companion object {
        fun max(a: Int, b: Int) = if (a > b) a else b
    }
}