package leetcode.coin.change

// minSteps[i] min coins of i-th step, result is counts[amount]

class DP : CoinChange {

    override fun coinChange(coins: IntArray, amount: Int): Int {
        val minSteps = IntArray(amount + 1) { amount + 1 }
        minSteps[0] = 0

        for (i in 1..amount) {
            for (coin in coins) {
                if (i < coin) {
                    continue
                }
                val minStep = minSteps[i - coin] + 1
                if (minStep < minSteps[i]) {
                    minSteps[i] = minStep
                }
            }
        }
        return if (minSteps[amount] > amount) -1 else minSteps[amount]
    }

}