package leetcode.best.time.to.buy.and.sell.stock.ii

// DP[i][j]: j=0 => max profit of i-th day if has no stock; j=1 => max profit of i-th day if has stock;
// the power of definition
//
// DP[i][0] = max(DP[i-1][0], DP[i-1][1] + prices[i])
// DP[i][1] = max(DP[i-1][0] + prices[i], DP[i-1][1])
//
// k = 2, prices = [1, 101, 2, 103, 3, 105]
// i = 0 => 0
// i = 1 => 100
// i = 2 => 100
// i = 3 => 201
// i = 4 => 201
// i = 5 => 203

class DP01 : BestTimeToBuyAndSellStockII {
    override fun maxProfit(prices: IntArray): Int {
        val maxProfits = Array(2) { IntArray(2) { -prices[0] } }
        for (i in prices.indices) {
            val x = i.and(1)
            val y = (i + 1).and(1)

            maxProfits[y][0] = max(maxProfits[x][0], maxProfits[x][1] + prices[i])
            maxProfits[y][1] = max(maxProfits[x][0] - prices[i], maxProfits[x][1])
        }
        return maxProfits[(prices.size).and(1)][0]
    }

    companion object {
        fun max(a: Int, b: Int) = if (a > b) a else b
    }
}