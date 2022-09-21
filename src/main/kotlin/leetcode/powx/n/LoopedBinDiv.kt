package leetcode.powx.n

//    Some important concepts related to this approach:
//
//    Every number can be written as the sum of powers of 2
//    We can traverse through all the bits of a number from LSB to MSB in O(log(n)) time.
//    For Example :
//
//    - 3^10 = 3^8 * 3^2. (10 in binary can be represented as 1010, where from the left side the first
//    1 represents 3^2 and the second 1 represents 3^8)
//
//    - 3^19 = 3^16 * 3^2 * 3. (19 in binary can be represented as 10011, where from the left side the first
//    1 represents 3^1 and second 1 represents 3^2 and the third one represents 3^16)
//

class LoopedBinDiv : PowXN {

    override fun myPow(x: Double, n: Int): Double {
        var tmp = if (n < 0) 1 / x else x
        var m = if (n < 0) -n else n

        var pow = 1.0
        while (m > 0) {
            if (m.and(1) == 1) {
                pow *= tmp
            }
            tmp *= tmp
            m = m.shr(1)
        }

        if (n < 0 && pow == 1.0 && x > 1.0) {
            pow = 0.0
        }

        return pow
    }
}