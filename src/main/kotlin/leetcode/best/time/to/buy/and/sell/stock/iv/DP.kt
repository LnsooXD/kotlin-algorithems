package leetcode.best.time.to.buy.and.sell.stock.iv

// DP[i][k][j] max profit of i-th day with k trade times, j=0 can buy, j=1, can sell


class DP : BestTimeToBuyAndSellStockIV {
    override fun maxProfit(k: Int, prices: IntArray): Int {
        val maxProfits = Array(2) { Array(k + 1) { Array<Int?>(3) { null } } }
        maxProfits[0][0][0] = 0
        maxProfits[0][0][1] = -prices[0]

        var x: Int
        var y = 0
        var price: Int

        for (i in 1 until prices.size) {
            x = (i - 1).and(1)
            y = i.and(1)
            price = prices[i]

            maxProfits[y][0][0] = maxProfits[x][0][0]
            maxProfits[y][0][1] = max(maxProfits[x][0][1], -price)

            for (kk in 1..k) {
                maxProfits[y][kk][0] = max(maxProfits[x][kk][0], maxProfits[x][kk - 1][1]?.let { it + price })
                maxProfits[y][kk][1] = max(maxProfits[x][kk][1], maxProfits[x][kk][0]?.let { it - price })
            }
        }

        var res = 0
        maxProfits[y].mapNotNull { it[0] }.forEach {
            if (it > res) {
                res = it
            }
        }
        return res
    }

    companion object {
        fun max(a: Int?, b: Int?): Int? = if (b == null || (a != null && a > b)) a else b
    }
}