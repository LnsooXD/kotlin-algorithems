package leetcode.best.time.to.buy.and.sell.stock.iii


// let BUY_DP[i]: max profit of buy at or after day i

class DP02 : BestTimeToBuyAndSellStockIII {
    override fun maxProfit(prices: IntArray): Int {
        val dayProfits = IntArray(prices.size) { 0 }

        for (i in 0 until prices.size - 1) {
            dayProfits[i] = prices[i + 1] - prices[i]
        }

        val buyDP = IntArray(prices.size) { 0 }
        var maxBuyProfit = 0

        for (i in (0..prices.size - 2).reversed()) {
            maxBuyProfit = dayProfits[i] + if (maxBuyProfit > 0) maxBuyProfit else 0
            buyDP[i] = max(maxBuyProfit, buyDP[i + 1])
        }

        var maxSellProfit = 0
        var res = 0

        for (i in 1 until prices.size) {
            maxSellProfit = dayProfits[i - 1] + if (maxSellProfit > 0) maxSellProfit else 0
            res = max(res, maxSellProfit + buyDP[i])
        }
        return max(res, 0)
    }

    companion object {
        fun max(a: Int, b: Int) = if (a > b) a else b
    }
}