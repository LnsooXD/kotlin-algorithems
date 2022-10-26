package leetcode

import leetcode.struct.listNodeOf
import org.junit.jupiter.api.Test

internal class MergeTwoSortedListsTest {

    private val core = MergeTwoSortedLists()

    @Test
    fun test01() {
        val list1 = listNodeOf(2)
        val list2 = listNodeOf(1)
        val res = this.core.mergeTwoLists(list1, list2)
        println(res)
    }


    @Test
    fun test02() {
        val list1 = listNodeOf(-2,5)
        val list2 = listNodeOf(-9,-6,-3,-1,1,6)
        val res = this.core.mergeTwoLists(list1, list2)
        println(res)
    }

}