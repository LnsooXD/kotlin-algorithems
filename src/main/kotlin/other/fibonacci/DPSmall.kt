package other.fibonacci

class DPSmall : FibonacciI {

    // 利用4的余数：https://www.jianshu.com/p/0711e9eb8cef

    // 取余运算符为“%”。但在以前，CPU采用如下方法计算余数（注意，该方法只对2的N次方数系有效）：
    // X & (2^N - 1)

    override fun calculate(n: Int): Int {
        val fibs = IntArray(4) { 0 }
        fibs[1] = 1

        for (i in 2..n) {
            fibs[i.and(3)] = fibs[(i - 1).and(3)] + fibs[(i - 2).and(3)]
        }

        return fibs[n.and(3)]
    }

}