package leetcode

import org.assertj.core.api.Assertions.assertThat
import org.testng.annotations.Test

internal class RemoveDuplicatesFromSortedArrayTest {

    private val core = RemoveDuplicatesFromSortedArray()

    @Test
    fun testRemoveDuplicates1() {
        val nums = intArrayOf(1, 1, 2)
        val expectedNums = intArrayOf(1, 2)
        this.testRemoveDuplicates(nums, expectedNums)
    }

    @Test
    fun testRemoveDuplicates2() {
        val nums = intArrayOf(0, 0, 1, 1, 1, 2, 2, 3, 3, 4)
        val expectedNums = intArrayOf(0, 1, 2, 3, 4)
        this.testRemoveDuplicates(nums, expectedNums)
    }

    private fun testRemoveDuplicates(nums: IntArray, expectedNums: IntArray) {
        val k = this.core.removeDuplicates(nums)
        this.assertRemoveDuplicates(nums, k, expectedNums)
    }

    private fun assertRemoveDuplicates(nums: IntArray, k: Int, expectedNums: IntArray) {
        assertThat(k).isEqualTo(expectedNums.size)
        for (i in expectedNums.indices) {
            assertThat(nums[i]).isEqualTo(expectedNums[i])
        }
    }


}