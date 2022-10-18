package leetcode.dit.distance

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertTimeoutPreemptively
import java.time.Duration

internal class EditDistanceTest {

    private val core = DP()

    @Test
    fun test01() {
        val word1 = "horse"
        val word2 = "ros"
        val res = this.core.minDistance(word1, word2)
        assertThat(res).describedAs("word1: '$word1', word2: '$word2'").isEqualTo(3)
    }

    @Test
    fun test02() {
        val word1 = "intention"
        val word2 = "execution"
        val res = this.core.minDistance(word1, word2)
        assertThat(res).describedAs("word1: '$word1', word2: '$word2'").isEqualTo(5)
    }

    @Test
    fun test03() {
        val word1 = "park"
        val word2 = "spake"
        val res = this.core.minDistance(word1, word2)
        assertThat(res).describedAs("word1: '$word1', word2: '$word2'").isEqualTo(3)
    }

    @Test
    fun test04() {
        val word1 = ""
        val word2 = "a"
        val res = this.core.minDistance(word1, word2)
        assertThat(res).describedAs("word1: '$word1', word2: '$word2'").isEqualTo(1)
    }


    @Test
    fun test05() {
        val word1 = "aaa"
        val word2 = "aaa"
        val res = this.core.minDistance(word1, word2)
        assertThat(res).describedAs("word1: '$word1', word2: '$word2'").isEqualTo(0)
    }

    @Test
    fun test06() {
        assertTimeoutPreemptively(Duration.ofSeconds(10)) {
            val word1 = "dinitrophenylhydrazine"
            val word2 = "acetylphenylhydrazine"
            val res = this.core.minDistance(word1, word2)
            assertThat(res).describedAs("word1: '$word1', word2: '$word2'").isEqualTo(6)
        };
    }
}