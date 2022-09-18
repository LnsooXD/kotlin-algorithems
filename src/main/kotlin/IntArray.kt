fun IntArray.format(): String {
    return this.map { it.toString() }.reduce { x, y -> "$x, $y" }
}

fun IntArray.exchange(i: Int, j: Int) {
    val tmp = this[i]
    this[i] = this[j]
    this[j] = tmp
}