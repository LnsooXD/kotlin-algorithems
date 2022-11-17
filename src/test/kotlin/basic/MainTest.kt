package basic

import org.testng.annotations.Test

class MainTest {

    @Test
    fun test() {
        val x = 0;
        println(x xor 1)

        val y = 1
        println(y xor 1)
    }

    @Test
    fun test1() {
        for (x in -100..100) {
            println("x: ${x.toUnsignedBinaryString()} => ${x.and(-x).toUnsignedBinaryString()}")
        }
    }

    @Test
    fun test2() {
        for (x in -100..100) {
            println("x: ${x.toUnsignedBinaryString()} => ${x.and(x - 1).toUnsignedBinaryString()}")
        }
    }
}

fun Int.toUnsignedBinaryString(): String {
    var mask = 1
    val res = CharArray(32) { '0' }
    for (i in 0 until 32) {
        if (mask.and(this) != 0) {
            res[31 - i] = '1'
        }
        mask = mask.shl(1)
    }
    return String(res)
}