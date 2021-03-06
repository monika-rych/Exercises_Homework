package marijuana.provider;

import marijuana.State;

import java.time.LocalDate;
import java.time.temporal.TemporalAdjusters;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;

public class LowestStatePricePerMonth {
    public Map<LocalDate, State> get(List<State> states) {
        return states.stream()
                .collect(Collectors.groupingBy(
                        state -> state.getData().with(TemporalAdjusters.firstDayOfMonth()),
                        Collectors.minBy(
                                Comparator.comparing(State::lowestPrice)
                        )
                ))
                .values()
                .stream()
                .filter(Optional::isPresent)
                .map(Optional::get)
                .collect(Collectors.toMap(state1 -> state1.getData(), state2 -> state2));

    }

}
