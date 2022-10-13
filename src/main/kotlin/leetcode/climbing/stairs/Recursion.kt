package leetcode.climbing.stairs

class Recursion : ClimbingStairs {
    override fun climbStairs(n: Int): Int = if (n < 2) 1 else this.climbStairs(n - 1) + this.climbStairs(n - 2)

}