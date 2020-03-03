package marijuana.provider;


import marijuana.State;

import java.math.BigDecimal;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;

public class HistoricalLowestMediumQualityWeedPriceProvider {
    public Map<String, BigDecimal> get(List<State> states) {
        return states.stream()
                .collect(Collectors.groupingBy(
                        State::getStateName,
                        Collectors.minBy(
                                Comparator.comparing(State::getMediumQualityWeedPrice)
                        )
                ))
                .values()
                .stream()
                .filter(Optional::isPresent)
                .map(Optional::get)
                .collect(Collectors.toMap(State::getStateName, State::getMediumQualityWeedPrice));
    }
}
