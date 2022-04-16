package lesson5.task1

import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test
import kotlin.random.Random

class TestNew {
    @Test
    fun averageStockPrice() {

        assertEquals(
            mapOf<String, Double>(),
            averageStockPrice(listOf())
        )

        assertEquals(
            mapOf("META" to Double.NaN),
            averageStockPrice(listOf("META" to Double.POSITIVE_INFINITY, "META" to Double.NEGATIVE_INFINITY))
        )

        for (i in 0 until 100) {
            assertEquals(
                mapOf("MSFT" to (i * 6 + i % 11 + i / 2.0 - 50) / 5.0),
                averageStockPrice(
                    listOf(
                        "MSFT" to i * 4.0, "MSFT" to i / 2.0, "MSFT" to i + 50.0,
                        "MSFT" to i - 100.0, "MSFT" to (i % 11) * 1.0
                    )
                )
            )
        }

        val listStock = listOf("YAND", "GOOG", "META", "MOZI", "OPER")
        val random = Random(11 * 13 * 17)
        val inputRandom = mutableListOf<Pair<String, Double>>()
        val result = mutableMapOf<String, Double>()
        for (i in 0..2)
            for (stock in listStock)
                inputRandom.add(stock to random.nextDouble())
        for (i in 0..4)
            result[listStock[i]] =
                (inputRandom[i].second + inputRandom[i + 5].second + inputRandom[i + 10].second) / 3.0
        assertEquals(result, averageStockPrice(inputRandom))

        val inputLong = mutableListOf<Pair<String, Double>>()
        for (i in 0..9999) inputLong.add(listStock[0] to 0.0)
        assertEquals(mapOf("YAND" to 0.0), averageStockPrice(inputLong))

    }
}