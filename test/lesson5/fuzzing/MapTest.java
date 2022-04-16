package lesson5.fuzzing;

import edu.berkeley.cs.jqf.fuzz.Fuzz;
import edu.berkeley.cs.jqf.fuzz.JQF;
import kotlin.Pair;
import org.junit.runner.RunWith;
import java.util.List;

import static lesson5.task1.MapKt.averageStockPrice;

@RunWith(JQF.class)
public class MapTest {

    @Fuzz
    public void averageStockPriceTest(List<Pair<String, Double>> stockPrices) {
        averageStockPrice(stockPrices);
    }
}
