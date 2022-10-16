package leetcode.best.time.to.buy.and.sell.stock.with.transaction.fee

//
// DP[i][j] : max profits of i-th day. if j == 0, then there is no stocks hold, if j == 1, then hold stocks
//
// DP[i][0] = max(DP[i-1][0], DP[i-1][1] + prices[i] - fee)
// DP[i][1] = max(DP[i-1][1], DP[i-1][0] - prices[i])
//

class DP : BestTimeToBuyAndSellStockWithTransactionFee {
    override fun maxProfit(prices: IntArray, fee: Int): Int {

        val maxProfits = Array(2) { intArrayOf(0, -prices[0]) }

        var x: Int
        var y = 0

        for (i in 1 until prices.size) {
            x = (i - 1).and(1)
            y = i.and(1)

            maxProfits[y][0] = max(maxProfits[x][0], maxProfits[x][1] + prices[i] - fee)
            maxProfits[y][1] = max(maxProfits[x][1], maxProfits[x][0] - prices[i])
        }

        return maxProfits[y][0]
    }

    companion object {
        fun max(a: Int, b: Int) = if (a > b) a else b
    }
}