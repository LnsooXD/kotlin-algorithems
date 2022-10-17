package leetcode.coin.change

// DP[i]

class DPWithHashMap : CoinChange {

    override fun coinChange(coins: IntArray, amount: Int): Int {

        val counts = HashMap<Int, Int>()
        counts[0] = 0
        for (i in 1..amount) {
            var minCount = -1
            for (coin in coins) {
                val preMinCount = counts[i - coin] ?: continue
                if (minCount == -1 || preMinCount < minCount) {
                    minCount = preMinCount
                }
            }
            if (minCount != -1) {
                counts[i] = minCount + 1
            }
        }
        return counts[amount] ?: -1
    }

}