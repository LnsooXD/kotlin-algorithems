package leetcode

import leetcode.struct.listNodeOf
import org.testng.annotations.Test

internal class MergeKSortedListsTest {

    private val core = MergeKSortedLists()

    @Test
    fun test() {
        val lists = arrayOf(
            listNodeOf(1, 4, 5),
            listNodeOf(1, 3, 4),
            listNodeOf(2, 6),
        )
        val res = this.core.mergeKLists(lists)
        println(res)
    }

}