package marijuana.provider;

import marijuana.State;

import java.util.*;
import java.util.stream.Collectors;

public class CurrentStateDataProvider {
    public List<State> get(List<State> states){
        return states.stream()
                .collect(Collectors.groupingBy(
                        State::getStateName,
                        Collectors.maxBy(
                                Comparator.comparing(State::getData)
                        )
                ))
                .values()
                .stream()
                .filter(Optional::isPresent)
                .map(Optional::get)
                .collect(Collectors.toList());
    }
}
