package search

class BinarySearch {
    fun search(values: IntArray, target: Int): Int {
        var left = 0
        var right = values.size - 1

        while (left <= right) {
            val mid = (left + right).shr(1)
            if (target == values[mid]) {
                return mid
            } else if (target > values[mid]) {
                left = mid + 1
            } else {
                right = mid - 1
            }
        }
        return -1
    }
}