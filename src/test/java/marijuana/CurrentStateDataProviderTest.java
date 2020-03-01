package marijuana;

import org.junit.jupiter.api.Test;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class CurrentStateDataProviderTest {

    @Test
    void shouldReturnCurrentRecordPerState() {
        //given
        List<State> states = new ArrayList<>();
        State record1 = new State("Alabama", null, null, null, LocalDate.of(2015, 1, 1) );
        State record2 = new State("Alabama", null, null, null, LocalDate.of(2015, 1, 28) );
        State record3 = new State("New York", null, null, null, LocalDate.of(2015, 7, 28) );
        State record4 = new State("New York", null, null, null, LocalDate.of(2016, 5, 28) );
        State record5 = new State("New York", null, null, null, LocalDate.of(2014, 12, 28) );

        states.add(record1);
        states.add(record2);
        states.add(record3);
        states.add(record4);
        states.add(record5);

        //when
        CurrentStateDataProvider currentStateDataProvider = new CurrentStateDataProvider();
        List<State> result = currentStateDataProvider.get(states);

        //then
        assertThat(result).containsExactlyInAnyOrder(record4, record2);
    }
}