package leetcode.best.time.to.buy.and.sell.stock.iv

// DP[i][k][j] max profit of i-th day with k trade times, j=0 can buy, j=1, can sell


class DP : BestTimeToBuyAndSellStockIV {
    override fun maxProfit(k: Int, prices: IntArray): Int {
        val maxProfits = Array(2) { Array(k + 1) { LongArray(2) { Int.MIN_VALUE.toLong() } } }

        maxProfits[0][0][0] = 0
        maxProfits[0][0][1] = (-prices[0]).toLong()

        var maxProfit = 0L

        for (i in 1 until prices.size) {
            val x = (i - 1).and(1)
            val y = i.and(1)
            val price = prices[i].toLong()

            maxProfits[y][0][0] = maxProfits[x][0][0]
            maxProfits[y][0][1] = max(maxProfits[x][0][1], -price)

            for (kk in 1..k) {
                maxProfits[y][kk][0] = max(maxProfits[x][kk][0], maxProfits[x][kk - 1][1] + price)
                maxProfits[y][kk][1] = max(maxProfits[x][kk][1], maxProfits[x][kk][0] - price)

                maxProfit = max(maxProfit, maxProfits[y][kk][0])
            }
        }

        return maxProfit.toInt()
    }

    companion object {
        fun max(a: Long, b: Long) = if (a > b) a else b
    }
}