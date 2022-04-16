package lesson7.task1

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class TestNew {
    @Test
    fun countSubstrings() {

        assertEquals(
            mapOf("\n" to 3, " " to 3 + 11, "!" to 6),
            countSubstrings("input/substrings_in3.txt", listOf("\n", " ", "!"))
        )

        assertEquals(
            emptyMap<String, Int>(),
            countSubstrings("input/substrings_in3.txt", emptyList())
        )

        assertEquals(
            mapOf("Лось" to 0),
            countSubstrings("input/substrings_in2.txt", listOf("Лось"))
        )

        assertEquals(
            mapOf("Белоглазый" to 1, "INPUTNAME" to 1, "." to 5, "*" to 24, "," to 7),
            countSubstrings("input/substrings_in1.txt", listOf(".", "*", ",", "Белоглазый", "INPUTNAME"))
        )

        assertEquals(
            mapOf(" * " to 18, "**" to 1, " *\n" to 3),
            countSubstrings("input/substrings_in1.txt", listOf(" * ", "**", " * ", "**", " *\n"))
        )

        assertEquals( // Пустой файл
            mapOf(" " to 0),
            countSubstrings("input/substrings_in4.txt", listOf(" "))
        )

        assertEquals( // Этот тест не проходит! (FileNotFoundException)
            mapOf("В" to 0),
            countSubstrings("", listOf("В"))
        )

        assertEquals( // Этот тест тоже не проходит! (Пустая строка)
            mapOf("" to 757, "е" to 49, "эволюция" to 0),
            countSubstrings("input/substrings_in1.txt", listOf("", "е", "эволюция"))
        )
    }
}