package marijuana;

import java.util.Comparator;

public class ByBestStatePrice  implements Comparator<State> {
    @Override
    public int compare(State s1, State s2) {
        return s1.getStateName().compareTo(s2.getStateName());
    }
}
