package leetcode.number.of.provinces

import org.assertj.core.api.Assertions.assertThat
import org.testng.annotations.Test

internal class NumberOfProvincesTest {

    private val core = Union()

    @Test
    fun test01() {
        val isConnected = arrayOf(
            intArrayOf(1,1,0),
            intArrayOf(1,1,0),
            intArrayOf(0,0,1),
        )

        val res= this.core.findCircleNum(isConnected)
        assertThat(res).isEqualTo(2)
    }


    @Test
    fun test02() {
        val isConnected = arrayOf(
            intArrayOf(1,0,0),
            intArrayOf(0,1,0),
            intArrayOf(0,0,1),
        )

        val res= this.core.findCircleNum(isConnected)
        assertThat(res).isEqualTo(3)
    }


}