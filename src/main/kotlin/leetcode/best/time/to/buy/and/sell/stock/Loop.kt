package leetcode.best.time.to.buy.and.sell.stock

class Loop : BestTimeToBuyAndSellStock {
    override fun maxProfit(prices: IntArray): Int {
        var res = 0
        for (i in 1 until prices.size) {
            for (j in 0 until i) {
                val profit = prices[i] - prices[j]
                res = if (profit > res) profit else res
            }
        }
        return res
    }


}