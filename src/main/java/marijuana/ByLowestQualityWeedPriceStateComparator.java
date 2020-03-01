package marijuana;

import java.util.Comparator;

public class ByLowestQualityWeedPriceStateComparator implements Comparator<State> {
    @Override
    public int compare(State s1, State s2) {
        return s2.getLowQualityWeedPrice().compareTo(s1.getLowQualityWeedPrice());
    }
}
