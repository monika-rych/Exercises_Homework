package marijuana;

import java.util.List;

public class Main {
    public static void main(String[] args) {
        StateImporter stateImporter = new StateImporter("src/main/resources/marijuana-street-price-clean.csv");
        List<State> states = stateImporter.readStates();
        CurrentStateDataProvider currentStateDataProvider = new CurrentStateDataProvider();
        List<State> currentStateData = currentStateDataProvider.get(states);

        System.out.println("--------");
        currentStateData.stream()
                .sorted(new AveragePriceComparator())
                .limit(1)
                .forEach(System.out::println);
        System.out.println("--------");

        System.out.println("--------");
        currentStateData.stream()
                .sorted(new ByHighestQualityWeedPriceStateComparator())
                .limit(5)
                .forEach(System.out::println);
        System.out.println("--------");

    }
}
