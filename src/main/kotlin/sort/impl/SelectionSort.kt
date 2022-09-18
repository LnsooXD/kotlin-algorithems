package sort.impl

import exchange
import sort.Sortable

class SelectionSort : Sortable {

    override fun sort(arr: IntArray) {
        val size = arr.size
        if (size <= 1) {
            return
        }

        for (i in 0 until size) {
            for (j in i + 1 until size) {
                if (arr[j] < arr[i]) {
                    arr.exchange(i, j)
                }
            }
        }
    }
}
