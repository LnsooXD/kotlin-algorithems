package leetcode.best.time.to.buy.and.sell.stock.iii


// let BUY_DP[i]: max of buy at or after day i

class DP02 : BestTimeToBuyAndSellStockIII {
    override fun maxProfit(prices: IntArray): Int {
        if (prices.size < 2) {
            return 0
        }

        val dayProfits = IntArray(prices.size) { 0 }

        for (i in 0 until prices.size - 1) {
            dayProfits[i] = prices[i + 1] - prices[i]
        }

        val buyDP = IntArray(prices.size) { 0 }
        var maxBuyProfit = 0

        for (i in (0..prices.size - 2).reversed()) {
            val profit = dayProfits[i]
            maxBuyProfit = max(profit, maxBuyProfit + profit)
            buyDP[i] = max(maxBuyProfit, buyDP[i + 1])
        }

        var maxSellProfit = dayProfits[0]
        var res = maxSellProfit + buyDP[1]

        for (i in 2 until prices.size) {
            val profit = dayProfits[i - 1]
            maxSellProfit = max(profit, maxSellProfit + profit)
            res = max(res, maxSellProfit + buyDP[i])
        }
        return max(res, 0)
    }

    companion object {
        fun max(a: Int, b: Int) = if (a > b) a else b
    }
}