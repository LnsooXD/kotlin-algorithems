package other.fibonacci

/**
 * ```
 * ┏                ┓   ┏                ┓    ┏       ┓
 * ┃ f(n)    f(n-1) ┃ = ┃ f(n-1)  f(n-2) ┃ x  ┃ 1   1 ┃
 * ┃ f(n-1)  f(n-2) ┃   ┃ f(n-2)  f(n-3) ┃    ┃ 1   0 ┃
 * ┗                ┛   ┗                ┛    ┗       ┛
 * and
 * ┏            ┓   ┏       ┓
 * ┃ f(2)  f(1) ┃ = ┃ 1   1 ┃
 * ┃ f(1)  f(0) ┃   ┃ 1   0 ┃
 * ┗            ┛   ┗       ┛
 * =>
 * ┏                ┓   ┏       ┓
 * ┃ f(n)    f(n-1) ┃ = ┃ 1   1 ┃ ^ (n-1)
 * ┃ f(n-1)  f(n-2) ┃   ┃ 1   0 ┃
 * ┗                ┛   ┗       ┛
 * ```
 */
class Matrix : FibonacciI {

    override fun calculate(n: Int): Int {
        if (n < 2) {
            return n
        }
        return pow(intArrayOf(1, 1, 1, 0), n - 1)[0]
    }

    private fun pow(matrix: IntArray, n: Int): IntArray {
        var res: IntArray = intArrayOf(1, 0, 0, 1)
        var tmp: IntArray = matrix
        var bits = n

        while (bits != 0) {
            if (bits.and(1) == 1) {
                res = this.mul(tmp, res)
            }
            tmp = this.mul(tmp, tmp)
            bits = bits ushr 1
        }

        return res
    }

    /**
     * ```
     * ┏                      ┓
     * ┃ matrix[0]  matrix[1] ┃
     * ┃ matrix[2]  matrix[3] ┃
     * ┗                      ┛
     * ```
     **/
    private fun mul(matrixFirst: IntArray, matrixSecond: IntArray) = MUL_COEFFICIENTS.map {
        matrixFirst[it[0]] * matrixSecond[it[1]] + matrixFirst[it[2]] * matrixSecond[it[3]]
    }.toIntArray()

    companion object {
        val MUL_COEFFICIENTS = arrayOf(
            intArrayOf(0, 0, 1, 2),
            intArrayOf(0, 1, 1, 3),
            intArrayOf(2, 0, 3, 2),
            intArrayOf(2, 1, 3, 3),
        )
    }

}