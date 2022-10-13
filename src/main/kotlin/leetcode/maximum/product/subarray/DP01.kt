package leetcode.maximum.product.subarray


// nums = [2, 3, -2, 4]
// DP[0] = [2, 3, -2, 4]
// DP[1] = [6, -6, -8]
// DP[2] = [-12, -24] [DP[1][0] * DP[0][2], DP[1][1] * DP[0][3]]
// DP[3] = [-48] // DP[2][0] * DP[0][3]

// DP[i][j] = product(nums[j]..nums[j + i])
// DP[i][j] = DP[i - 1][j] * DP[0][j + i]

class DP01 : MaximumProductSubarray {
    override fun maxProduct(nums: IntArray): Int {
        val products = nums.copyOf()

        var max = nums.reduce { acc, i -> if (acc > i) acc else i }

        for (row in 1 until nums.size) {
            for (col in 0 until nums.size - row) {
                products[col] = products[col] * nums[row + col]
                if (max < products[col]) {
                    max = products[col]
                }
            }
        }
        return max
    }
}