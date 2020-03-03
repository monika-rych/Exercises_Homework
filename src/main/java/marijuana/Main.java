package marijuana;

import marijuana.comparators.AveragePriceComparator;
import marijuana.comparators.ByHighestQualityWeedPriceStateComparator;
import marijuana.comparators.DateComparator;
import marijuana.provider.CurrentStateDataProvider;
import marijuana.provider.HistoricalLowestMediumQualityWeedPriceProvider;
import marijuana.provider.LowestStatePricePerMonth;
import marijuana.provider.LowestStatePricePerYear;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;
import java.util.Map;

public class Main {
    public static void main(String[] args) {
        StateImporter stateImporter = new StateImporter("src/main/resources/marijuana-street-price-clean.csv");
        List<State> states = stateImporter.readStates();
        CurrentStateDataProvider currentStateDataProvider = new CurrentStateDataProvider();
        List<State> currentStateData = currentStateDataProvider.get(states);


        System.out.println("1--------");
        currentStateData.stream()
                .sorted(new AveragePriceComparator())
                .limit(1)
                .forEach(System.out::println);
        System.out.println("--------");

        System.out.println("2--------");
        currentStateData.stream()
                .sorted(new ByHighestQualityWeedPriceStateComparator())
                .limit(5)
                .forEach(System.out::println);
        System.out.println("--------");

        System.out.println("3--------");
        HistoricalLowestMediumQualityWeedPriceProvider provider = new HistoricalLowestMediumQualityWeedPriceProvider();
        Map<String, BigDecimal> historicalLowestMediumQualityWeedPrices = provider.get(states);

        historicalLowestMediumQualityWeedPrices.entrySet().stream().forEach(lowestPrice -> {
            System.out.print(lowestPrice.getKey() + " : ");
            System.out.println(lowestPrice.getValue());
        });
        System.out.println("--------");

        System.out.println("4--------");
        LowestStatePricePerYear lowestStatePricePerYear = new LowestStatePricePerYear();
        Map<Integer, State> lowestStatePricesPerYear = lowestStatePricePerYear.get(states);

        lowestStatePricesPerYear.entrySet().stream().forEach(lowestPrice -> {
            System.out.print(lowestPrice.getKey() + " : ");
            System.out.println(lowestPrice.getValue());
        });
        System.out.println("--------");

        System.out.println("5--------");
        LowestStatePricePerMonth lowestStatePricePerMonth = new LowestStatePricePerMonth();
        Map<LocalDate, State> lowestStatePricesPerMonth = lowestStatePricePerMonth.get(states);

        lowestStatePricesPerMonth.entrySet().stream().forEach(lowestPrice -> {
            System.out.print(lowestPrice.getKey() + " : ");
            System.out.println(lowestPrice.getValue());
        });
        System.out.println("--------");

        System.out.println("6--------");
        states.stream()
                .sorted(new DateComparator())
                .limit(100)
                .forEach(System.out::println);
        System.out.println("--------");
    }
}
