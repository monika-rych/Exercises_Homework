package marijuana;

import marijuana.provider.LowestStatePricePerYear;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import static org.assertj.core.api.Assertions.assertThat;

class LowestStatePricePerYearTest {
    @Test
    void should() {
        //given
        List<State> states = new ArrayList<>();
        State record1 = new State("Alabama", new BigDecimal("1"), new BigDecimal("20"), new BigDecimal("10"), LocalDate.of(2014, 1, 1) );
        State record2 = new State("Alabama", new BigDecimal("11"), new BigDecimal("21"), new BigDecimal("32"), LocalDate.of(2015, 8, 28) );
        State record3 = new State("Alabama", new BigDecimal("15"), new BigDecimal("30"), new BigDecimal("24"), LocalDate.of(2017, 4,4) );
        State record4 = new State("New York", new BigDecimal("60"), new BigDecimal(50), new BigDecimal("40"), LocalDate.of(2014, 8,5) );
        State record5 = new State("New York", new BigDecimal("40"), new BigDecimal(2), new BigDecimal("60"), LocalDate.of(2015, 1, 6) );
        State record6 = new State("New York", new BigDecimal("50"), new BigDecimal(60), new BigDecimal("3"), LocalDate.of(2017,4,4) );

        states.add(record1);
        states.add(record2);
        states.add(record3);
        states.add(record4);
        states.add(record5);
        states.add(record6);

        //when
        LowestStatePricePerYear provider = new LowestStatePricePerYear();
        Map<Integer, State> actual = provider.get(states);

        //then

        assertThat(actual.size()).isEqualTo(3);

        var hasValue1 = actual.containsKey(2014);
        var hasValue2 = actual.containsKey(2015);
        var hasValue3 = actual.containsKey(2017);
        assertThat(hasValue1).isTrue();
        assertThat(hasValue2).isTrue();
        assertThat(hasValue3).isTrue();

        var actualFor2014 = actual.get(2014);
        var actualFor2015 = actual.get(2015);
        var actualFor2017 = actual.get(2017);
        assertThat(actualFor2014).isEqualTo(record1);
        assertThat(actualFor2015).isEqualTo(record5);
        assertThat(actualFor2017).isEqualTo(record6);
    }
}