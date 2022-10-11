package other.fibonacci

class Loop : FibonacciI {

    override fun calculate(n: Int): Int = if (n <= 1) n else this.calculate(n - 1)+ this.calculate(n - 2)

}