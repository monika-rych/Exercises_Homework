package marijuana;

import java.util.*;
import java.util.stream.Collectors;

public class CurrentStateDataProvider {
    public List<State> get(List<State> states){
        return states.stream()
                .collect(Collectors.groupingBy( // collect companies by grouping
                        State::getStateName, //group by sector
                        Collectors.maxBy( // choose 'max' company in each sector
                                Comparator.comparing(State::getData) // use 'ebitda' to compare companies
                        )
                ))
                .values()
                .stream()
                .filter(Optional::isPresent)
                .map(Optional::get)
                .collect(Collectors.toList());
    }
}
