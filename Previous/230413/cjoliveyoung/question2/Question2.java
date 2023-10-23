import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Objects;
import java.util.Set;
import java.util.stream.Collectors;

public class Question2 {
    public static class RisingPair {
        private final String nameOfKorea;
        private final String nameOfUsa;

        public RisingPair(String nameOfKorea, String nameOfUsa) {
            this.nameOfKorea = nameOfKorea;
            this.nameOfUsa = nameOfUsa;
        }

        public static RisingPair of(String nameOfKorea, String nameOfUsa) {
            return new RisingPair(nameOfKorea, nameOfUsa);
        }

        @Override
        public boolean equals(Object other) {
            RisingPair that = (RisingPair) other;
            return Objects.equals(nameOfKorea, that.nameOfKorea)
                && Objects.equals(nameOfUsa, that.nameOfUsa);
        }

        @Override
        public int hashCode() {
            return Objects.hash(nameOfKorea, nameOfUsa);
        }
    }

    public int solution(String[] stockNamesOfKorea,
                        String[] stockNamesOfUsa,
                        String[] stocksRising) {
        Set<String> stocksOfKorea = convertToSet(stockNamesOfKorea);
        Set<String> stocksOfUsa = convertToSet(stockNamesOfUsa);

        Map<RisingPair, Integer> risingPairsAndCounts = new HashMap<>();
        for (String stockRising : stocksRising) {
            String[] stocks = stockRising.split(" ");
            Set<String> risingStocksOfKorea = new HashSet<>();
            Set<String> risingStocksOfUsa = new HashSet<>();
            determineAndFillRisingStocks(
                stocks, stocksOfKorea, stocksOfUsa,
                risingStocksOfKorea, risingStocksOfUsa
            );
            addCountsOfRisingPairs(
                risingPairsAndCounts, risingStocksOfKorea, risingStocksOfUsa
            );
        }

        return maxCountOfRisingPairs(risingPairsAndCounts);
    }

    public Set<String> convertToSet(String[] stocks) {
        return Arrays.stream(stocks)
            .collect(Collectors.toSet());
    }

    public void determineAndFillRisingStocks(String[] stocks,
                                             Set<String> stocksOfKorea,
                                             Set<String> stocksOfUsa,
                                             Set<String> risingStocksOfKorea,
                                             Set<String> risingStocksOfUsa) {
        for (String stock : stocks) {
            if (stocksOfKorea.contains(stock)) {
                risingStocksOfKorea.add(stock);
                continue;
            }
            if (stocksOfUsa.contains(stock)) {
                risingStocksOfUsa.add(stock);
            }
        }
    }

    public void addCountsOfRisingPairs(Map<RisingPair, Integer> risingPairsAndCounts,
                                       Set<String> risingStocksOfKorea,
                                       Set<String> risingStocksOfUsa) {
        risingStocksOfKorea.forEach(stockOfKorea -> {
            risingStocksOfUsa.forEach(stockOfUsa -> {
                RisingPair pair = new RisingPair(stockOfKorea, stockOfUsa);
                if (risingPairsAndCounts.containsKey(pair)) {
                    int count = risingPairsAndCounts.get(pair);
                    risingPairsAndCounts.replace(pair, count + 1);
                    return;
                }
                risingPairsAndCounts.put(pair, 1);
            });
        });
    }

    public int maxCountOfRisingPairs(Map<RisingPair, Integer> risingPairsAndCounts) {
        return risingPairsAndCounts.values()
            .stream()
            .min((previous, next) -> next - previous)
            .orElse(0);
    }
}
