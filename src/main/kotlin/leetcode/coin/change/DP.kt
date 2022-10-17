package leetcode.coin.change

// minSteps[i] min coins of i-th step, result is counts[amount]

class DP : CoinChange {

    override fun coinChange(coins: IntArray, amount: Int): Int {
        val minSteps = IntArray(amount + 1) { Int.MAX_VALUE }
        minSteps[0] = 0

        for (i in 1..amount) {
            for (coin in coins) {
                if (i < coin) {
                    continue
                }
                val minStep = minSteps[i - coin]
                if (minStep < minSteps[i] - 1) {
                    minSteps[i] = minStep + 1
                }
            }
        }
        return if (minSteps[amount] == Int.MAX_VALUE) -1 else minSteps[amount]
    }

}