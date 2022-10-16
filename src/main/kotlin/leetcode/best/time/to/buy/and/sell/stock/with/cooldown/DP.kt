package leetcode.best.time.to.buy.and.sell.stock.with.cooldown

// DP[i][j]: j=0 => max profit of i-th day if it has no stock; j=1 => max profit of i-th day if it has stock;
// the power of definition

// - 持有股票  DP[i][0]
// - 没持有股票
//  - 可以买   DP[i][1] // 0
//  - 不可以买 DP[i][2] // 1 // 剩余 1 天

// DP[i][0] = max(DP[i-1][0], DP[i-1][1] - prices[i])
// DP[i][1] = max(DP[i-1][1], DP[i-1][2])
// DP[i][2] = DP[i-1][0] + prices[i]

class DP : BestTimeToBuyAndSellStockWithCoolDown {
    override fun maxProfit(prices: IntArray): Int {
        val maxProfits = Array(2) { IntArray(3) }

        maxProfits[0][0] = -prices[0]
        maxProfits[0][1] = 0
        maxProfits[0][2] = 0

        var x: Int
        var y = 0

        for (i in 1 until prices.size) {
            x = (i - 1).and(1)
            y = i.and(1)

            maxProfits[y][0] = max(maxProfits[x][0], maxProfits[x][1] - prices[i])
            maxProfits[y][1] = max(maxProfits[x][1], maxProfits[x][2])
            maxProfits[y][2] = maxProfits[x][0] + prices[i]
        }
        return max(maxProfits[y][1], maxProfits[y][2])
    }

    companion object {
        fun max(a: Int, b: Int) = if (a > b) a else b
    }
}