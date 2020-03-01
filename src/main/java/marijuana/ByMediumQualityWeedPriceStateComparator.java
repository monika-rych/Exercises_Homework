package marijuana;

import java.util.Comparator;

public class ByMediumQualityWeedPriceStateComparator implements Comparator<State> {
    @Override
    public int compare(State s1, State s2) {
        return s2.getMediumQualityWeedPrice().compareTo(s1.getMediumQualityWeedPrice());
    }
}
