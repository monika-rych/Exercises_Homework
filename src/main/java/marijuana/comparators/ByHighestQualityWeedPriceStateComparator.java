package marijuana.comparators;

import marijuana.State;

import java.util.Comparator;

public class ByHighestQualityWeedPriceStateComparator implements Comparator<State> {

    @Override
    public int compare(State s1, State s2) {
        return s1.getHighQualityWeedPrice().compareTo(s2.getHighQualityWeedPrice());
    }
}
