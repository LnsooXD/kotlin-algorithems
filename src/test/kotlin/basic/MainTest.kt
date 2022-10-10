package basic

import org.junit.jupiter.api.Test

class MainTest {

    @Test
    fun test() {
        val x = 0;
        println(x xor 1)

        val y = 1
        println( y xor 1)
    }

    @Test
    fun test1() {

        for (x in 0..100) {
            println("x: $x => ${x.and(-x)}")
        }

    }
}