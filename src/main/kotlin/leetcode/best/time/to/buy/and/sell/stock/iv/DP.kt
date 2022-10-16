package leetcode.best.time.to.buy.and.sell.stock.iv

// DP[i] max profit of i-th day
//
// k = 2, prices = [1, 101, 2, 103, 3, 105]
// i = 0 => 0
// i = 1 => 100
// i = 2 => 100
// i = 3 => 201
// i = 4 => 201
// i = 5 => 203

// prices = [1, 101, 2, 103, 3, 105]
// k=1 => (105 - 1) = 104
// k=2 => (103 - 1) + (105 - 3) = 204
// k=3 => (101 - 1) + (103 -2) + (105 - 3) = 303

class DP : BestTimeToBuyAndSellStockIV {
    override fun maxProfit(k: Int, prices: IntArray): Int {
        TODO("Not yet implemented")
    }
}