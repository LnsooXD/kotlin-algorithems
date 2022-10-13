package leetcode.climbing.stairs

class DP : ClimbingStairs {

    /*3*/ /*2*/ /*1*/ /*1*/

    // f(1) = 1
    // f(2) = 2
    // f(3) = 3
    // f(n) = f(n-1) + f(n-2)

    override fun climbStairs(n: Int): Int {
        if (n < 2) {
            return 1
        }
        val ways = IntArray(n + 1) { 1 }
        for (i in 2..n) {
            ways[i] = ways[i - 1] + ways[i - 2]
        }
        return ways[n]
    }

}