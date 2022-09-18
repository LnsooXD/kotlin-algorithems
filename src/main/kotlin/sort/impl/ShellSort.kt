package sort.impl

import exchange
import sort.Sortable

class ShellSort : Sortable {

    override fun sort(arr: IntArray) {
        val N: Int = arr.size
        var h = 1

        while (h < N / 3) {
            h = 3 * h + 1 // 1, 4, 13, 40, 121, 364, 1093, ...
        }

        while (h >= 1) { // h-sort the array.
            for (i in h until N) {
                var j: Int = i
                while (j >= h && arr[j] < arr[j - h]) {
                    arr.exchange(j, j - h)
                    j -= h
                }
            }
            h /= 3
        }
    }

}