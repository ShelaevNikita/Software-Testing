package lesson6.task1

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test
import java.lang.Integer.max
import kotlin.random.Random

class TestNew {
    @Test
    fun bestLongJump() {

        assertEquals(-1, bestLongJump(""))

        assertEquals(-1, bestLongJump("% - % - %"))

        assertEquals(-1, bestLongJump("228 1000- % 785"))

        assertEquals(-1, bestLongJump("502.5 - 7 % 654"))

        assertEquals(781, bestLongJump("781 - -1251 % 654"))

        val random = Random(7 * 11 * 23)
        val inputString = StringBuilder("")
        var maxValue = 0
        for (i in 0..999) {
            val randomNext = random.nextInt()
            maxValue = max(maxValue, randomNext)
            inputString.append(randomNext)
            if (i != 999) inputString.append(" % - ")
        }
        assertEquals(maxValue, bestLongJump(inputString.toString()))

        assertEquals(-1, bestLongJump("% +700 80 - 700"))  // Этот тест не проходит! ("+700")
    }
}