package leetcode.coin.change

class Recursion : CoinChange {
    override fun coinChange(coins: IntArray, amount: Int) = this.coinChange(coins, 0, amount)

    private fun coinChange(coins: IntArray, startIndex: Int, amount: Int): Int {
        if (amount == 0) {
            return 0
        } else if (startIndex >= coins.size) {
            return -1
        }

        var currentCount = 0
        val currentCoin = coins[startIndex]
        var changedAmount = 0

        var minCount = -1

        while (changedAmount <= amount) {
            var count = this.coinChange(coins, startIndex + 1, amount - changedAmount)
            if (count >= 0) {
                count += currentCount
                if (minCount == -1 || minCount > count) {
                    minCount = count
                }
            }

            changedAmount += currentCoin
            currentCount++
        }
        return minCount
    }
}