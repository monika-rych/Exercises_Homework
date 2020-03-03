package marijuana.comparators;

import marijuana.State;

import java.util.Comparator;

public class DateComparator implements Comparator<State> {

    @Override
    public int compare(State data1, State data2) {
        return data1.getData().compareTo(data2.getData());
    }
}
