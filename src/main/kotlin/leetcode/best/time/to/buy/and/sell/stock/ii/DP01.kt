package leetcode.best.time.to.buy.and.sell.stock.ii

// DP[i] = DP[i - 1] + Last_Trans[i]

//
// [10000, 100]
// [10000, 100, 100020]
// [10000, 100, 100020, 100001]
// [10000, 100, 100020, 100001, 1]


class DP01 : BestTimeToBuyAndSellStockII {
    override fun maxProfit(prices: IntArray): Int {

        val maxProfits = IntArray(prices.size) { 0 }
        var index = 0
        var lastSellDay = 0

        while (lastSellDay < prices.size) {
            for (i in lastSellDay + 1 until prices.size) {
                val profit = prices[i] - prices[lastSellDay]
                lastSellDay = i
                if (profit > 0) {
                    maxProfits[index++] = profit
                    break
                }
            }

        }
        TODO("Not yet implemented")
        // TODO return maxProfits.reduce { a: Int, b: Int -> a + b }
    }
}