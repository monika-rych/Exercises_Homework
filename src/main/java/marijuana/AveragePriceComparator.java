package marijuana;

import java.util.Comparator;

public class AveragePriceComparator implements Comparator<State> {

    @Override
    public int compare(State s1, State s2) {
        return s2.averagePrice().compareTo(s1.averagePrice());
    }
}
