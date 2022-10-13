package leetcode.climbing.stairs

class DPSmallData : ClimbingStairs {

    /*3*/ /*2*/ /*1*/ /*1*/

    // f(1) = 1
    // f(2) = 2
    // f(3) = 3
    // f(n) = f(n-1) + f(n-2)

    // 利用4的余数：https://www.jianshu.com/p/0711e9eb8cef

    // 取余运算符为“%”。但在以前，CPU采用如下方法计算余数（注意，该方法只对2的N次方数系有效）：
    // X & (2^N - 1)
    override fun climbStairs(n: Int): Int {
        if (n < 2) {
            return 1
        }
        val ways = IntArray(4) { 1 }
        for (i in 2..n) {
            ways[i.and(3)] = ways[(i - 1).and(3)] + ways[(i - 2).and(3)]
        }
        return ways[n.and(3)]
    }

}