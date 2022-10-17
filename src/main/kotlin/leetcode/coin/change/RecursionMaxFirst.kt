package leetcode.coin.change

class RecursionMaxFirst : CoinChange {
    override fun coinChange(coins: IntArray, amount: Int) = this.coinChange(coins, coins.size - 1, amount)

    private fun coinChange(coins: IntArray, startIndex: Int, amount: Int): Int {
        if (amount == 0) {
            return 0
        } else if (startIndex < 0) {
            return -1
        }

        val currentCoin = coins[startIndex]

        var currentCount = amount / currentCoin
        var changedAmount = currentCount * currentCoin

        var minCount = -1

        while (changedAmount >= 0) {
            var count = this.coinChange(coins, startIndex - 1, amount - changedAmount)
            if (count >= 0) {
                count += currentCount
                if (minCount == -1 || minCount > count) {
                    minCount = count
                }
            }

            changedAmount -= currentCoin
            currentCount--
        }
        return minCount
    }
}