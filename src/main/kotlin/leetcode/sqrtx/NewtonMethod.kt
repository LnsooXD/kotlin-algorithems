package leetcode.sqrtx

//        x_n+1, 0
//        xn, f(xn)
//
//        (f(xn) - 0) / (x_n - x_n+1) = f'(xn)
//
//        f(xn)/f'(xn) = xn - x_n+1
//
//        x_n+1 = x_n -    f(xn)/f'(xn)

//      f'(x) = 2x
//      x_n+1 = x_n - ((xn^2 - x )/ 2xn) = x_n - (x_n / 2 - x / 2x_n)

class NewtonMethod : Sqrtx<Double> {

    override fun mySqrt(x: Double): Double {
        var res = x
        while(this.abs(res * res - x) > 1e-10) {
            res -= (res / 2.0 - x / (res + res))
        }
        return res
    }

    private fun abs(a: Double) = if (a >= 0.0) a else -a
}