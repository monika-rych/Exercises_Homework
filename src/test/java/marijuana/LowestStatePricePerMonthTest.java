package marijuana;

import marijuana.provider.LowestStatePricePerMonth;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import static org.assertj.core.api.Assertions.assertThat;


class LowestStatePricePerMonthTest {
    @Test
    void should() {
        //given
        List<State> states = new ArrayList<>();
        State record1 = new State("Alabama", new BigDecimal("1"), new BigDecimal("20"), new BigDecimal("10"), LocalDate.of(2014, 8, 1) );
        State record2 = new State("New York", new BigDecimal("11"), new BigDecimal("21"), new BigDecimal("32"), LocalDate.of(2014, 8, 28) );
        State record3 = new State("Florida", new BigDecimal("15"), new BigDecimal("30"), new BigDecimal("24"), LocalDate.of(2014, 8,4) );
        State record4 = new State("Alabama", new BigDecimal("60"), new BigDecimal(50), new BigDecimal("40"), LocalDate.of(2014, 7,5) );
        State record5 = new State("New York", new BigDecimal("40"), new BigDecimal(2), new BigDecimal("60"), LocalDate.of(2014, 7, 6) );
        State record6 = new State("Florida", new BigDecimal("40"), new BigDecimal(20), new BigDecimal("60"), LocalDate.of(2014, 7, 6) );
        State record7 = new State("New York", new BigDecimal("50"), new BigDecimal(60), new BigDecimal("31"), LocalDate.of(2017,4,4) );
        State record8 = new State("Alabama", new BigDecimal("50"), new BigDecimal(60), new BigDecimal("30"), LocalDate.of(2017,4,4) );
        State record9 = new State("Florida", new BigDecimal("50"), new BigDecimal(60), new BigDecimal("3"), LocalDate.of(2017,4,4) );

        states.add(record1);
        states.add(record2);
        states.add(record3);
        states.add(record4);
        states.add(record5);
        states.add(record6);
        states.add(record7);
        states.add(record8);
        states.add(record9);

        //when
        LowestStatePricePerMonth provider = new LowestStatePricePerMonth();
        Map<LocalDate, State> actual = provider.get(states);

        //then

        assertThat(actual.size()).isEqualTo(3);

        var hasValue1 = actual.containsKey(LocalDate.of(2014, 8,1));
        var hasValue2 = actual.containsKey(LocalDate.of(2014, 7,6));
        var hasValue3 = actual.containsKey(LocalDate.of(2017,4,4));
        assertThat(hasValue1).isTrue();
        assertThat(hasValue2).isTrue();
        assertThat(hasValue3).isTrue();

        var actualFor2014 = actual.get(LocalDate.of(2014, 8,1));
        var actualFor2015 = actual.get(LocalDate.of(2014, 7,6));
        var actualFor2017 = actual.get(LocalDate.of(2017, 4,4));
        assertThat(actualFor2014).isEqualTo(record1);
        assertThat(actualFor2015).isEqualTo(record5);
        assertThat(actualFor2017).isEqualTo(record9);
    }


}