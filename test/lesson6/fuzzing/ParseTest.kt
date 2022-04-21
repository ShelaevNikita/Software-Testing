package lesson6.fuzzing

import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test
import kotlin.random.Random

class ParseTest {

    private fun generateString(): Pair<Int, String> {
        var len = (Math.random() * 1250).toInt()
        if (len >= 1000)
            len = 0
        val input = StringBuilder()
        var maxValue = -1
        for (i in 0 until len) {
            val newInt = (Math.random() * Int.MAX_VALUE).toInt()
            when (newInt % 10) {
                in 0..2 -> input.append('%')
                in 3..6 -> {
                    input.append(newInt)
                    if (newInt > maxValue)
                        maxValue = newInt
                }
                in 7..9 -> input.append('-')
            }
            if (i != len - 1)
                input.append(' ')
        }
        if (len >= 750) {
            input.append(' ')
            input.append(Random(17).nextDouble())
            maxValue = -1
        }
        // println(input.toString())
        return Pair(maxValue, input.toString())
    }

    @Test
    fun bestLongJump() {
        val iter = (Math.random() * 100000).toInt()
        for (i in 0 until iter) {
            val inputPair = generateString()
            assertEquals(inputPair.first, lesson6.task1.bestLongJump(inputPair.second))
        }
    }
}