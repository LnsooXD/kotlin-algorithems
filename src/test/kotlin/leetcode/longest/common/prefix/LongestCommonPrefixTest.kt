package leetcode.longest.common.prefix

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class LongestCommonPrefixTest {

    private val core: LongestCommonPrefix = BinDiv()

    @Test
    fun test00() {
        val strs = arrayOf<String>()
        val res = this.core.longestCommonPrefix(strs)
        assertThat(res).isEqualTo("")
    }

    @Test
    fun test01() {
        val strs = arrayOf("1234567890")
        val res = this.core.longestCommonPrefix(strs)
        assertThat(res).isEqualTo("1234567890")
    }

    @Test
    fun test02() {
        val strs = arrayOf("flower", "flow", "flight")
        val res = this.core.longestCommonPrefix(strs)
        assertThat(res).isEqualTo("fl")
    }

    @Test
    fun test03() {
        val strs = arrayOf("dog", "racecar", "car")
        val res = this.core.longestCommonPrefix(strs)
        assertThat(res).isEqualTo("")
    }

    @Test
    fun testCost() {
        val strs = arrayOf("flower", "flow", "flight")
            .map { str -> Array(100000) { str } }
            .flatMap { it.toList() }
            .toTypedArray()
        val start = System.nanoTime()
        val res = this.core.longestCommonPrefix(strs)
        println("cost: ${System.nanoTime() - start} ns")
        assertThat(res).isEqualTo("fl")
    }
}