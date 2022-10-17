package leetcode.coin.change

// counts[i] min coins of i-th step, result is counts[amount]

class DP : CoinChange {

    override fun coinChange(coins: IntArray, amount: Int): Int {
        val counts = IntArray(amount + 1) { Int.MAX_VALUE }
        counts[0] = 0

        for (i in 1..amount) {
            for (coin in coins) {
                if (i < coin) {
                    continue
                }
                val count = counts[i - coin]
                if (count < counts[i] - 1) {
                    counts[i] = count + 1
                }
            }
        }
        return if (counts[amount] == Int.MAX_VALUE) -1 else counts[amount]
    }

}