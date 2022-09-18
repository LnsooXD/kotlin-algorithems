package sort.impl

import sort.Sortable

class MergeSort : Sortable {

    private lateinit var aux: IntArray

    override fun sort(arr: IntArray) {
        val size = arr.size
        if (size <= 1) {
            return
        }
        this.aux = IntArray(size)
        this.sort(arr, 0, size - 1)
    }

    private fun sort(arr: IntArray, lo: Int, hi: Int) {
        if (lo >= hi) {
            return
        }
        val mid: Int = (lo + hi) / 2

        this.sort(arr, lo, mid)
        this.sort(arr, mid + 1, hi)
        this.merge(arr, lo, mid, hi)
    }

    private fun merge(arr: IntArray, lo: Int, mid: Int, hi: Int) {
        val aux = this.aux

        for (i in lo..hi) {
            aux[i] = arr[i]
        }

        var i = lo
        var j = mid + 1
        var k = lo

        while(k <= hi) {
            if (i > mid) {
                arr[k++] = aux[j++]
            } else if (j > hi) {
                arr[k++] = aux[i++]
            } else if (aux[i] < aux[j]) {
                arr[k++] = aux[j++]
            } else {
                arr[k++] = aux[i++]
            }
        }
    }

}


