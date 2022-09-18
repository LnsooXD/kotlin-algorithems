package sort.impl

import exchange
import sort.Sortable

class InsertionSort : Sortable {
    override fun sort(arr: IntArray) {
        val size = arr.size
        if (size <= 1) {
            return
        }

        for (i in 1 until size) {
            var j = i
            // 速度更快，向有序队列中插入对过程中，减少了次数
            while (j > 0 && arr[j] < arr[j - 1]) {
                arr.exchange(j, j - 1)
                j--
            }
        }
    }
}