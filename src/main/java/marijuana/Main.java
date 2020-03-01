package marijuana;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        StateImporter stateImporter = new StateImporter("src/main/resources/marijuana-street-price-clean.csv");
        List<State> states = stateImporter.readStates();
//        AverageBestStatePrice averageBestStatePrice = new AverageBestStatePrice();
//        averageBestStatePrice.average(new ArrayList<BigDecimal>(), RoundingMode.HALF_UP);
        List<BigDecimal> mean = new LinkedList<>();

//       System.out.println(averageBestStatePrice);

        states.stream()
                .sorted(new ByHighestQualityWeedPriceStateComparator())
                .limit(3)
                .forEach(System.out::println);

        states.stream()
                .sorted(new ByMediumQualityWeedPriceStateComparator())
                .limit(3)
                .forEach(System.out::println);

        states.stream()
                .sorted(new ByLowestQualityWeedPriceStateComparator())
                .limit(3)
                .forEach(System.out::println);

       /* states.stream()
                .sorted(new AverageBestStatePrice())*/

        //System.out.println(states);
    }
}
