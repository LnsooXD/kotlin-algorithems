package leetcode.coin.change

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class CoinChangeTest {

    private val core = Recursion()

    @Test
    fun test01() {
        val coins = intArrayOf(1, 2, 5)
        val amount = 11
        val res = this.core.coinChange(coins, amount)
        assertThat(res).isEqualTo(3)
    }

    @Test
    fun test02() {
        val coins = intArrayOf(2)
        val amount = 3
        val res = this.core.coinChange(coins, amount)
        assertThat(res).isEqualTo(-1)
    }

    @Test
    fun test03() {
        val coins = intArrayOf(1)
        val amount = 0
        val res = this.core.coinChange(coins, amount)
        assertThat(res).isEqualTo(0)
    }

    @Test
    fun test04() {
        val coins = intArrayOf(411, 412, 413, 414, 415, 416, 417, 418, 419, 420, 421, 422)
        val amount = 9864
        val res = this.core.coinChange(coins, amount)
        assertThat(res).isEqualTo(24)
    }

}