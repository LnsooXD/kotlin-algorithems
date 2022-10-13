package leetcode.climbing.stairs

class DPSmallData01 : ClimbingStairs {

    /*3*/ /*2*/ /*1*/ /*1*/

    // f(1) = 1
    // f(2) = 2
    // f(3) = 3
    // f(n) = f(n-1) + f(n-2)

    override fun climbStairs(n: Int): Int {
        if (n < 2) {
            return 1
        }
        val ways = IntArray(3) { 1 }
        for (i in 2..n) {
            ways[i % 3] = ways[(i - 1) % 3] + ways[(i - 2) % 3]
        }
        return ways[n.and(3)]
    }

}