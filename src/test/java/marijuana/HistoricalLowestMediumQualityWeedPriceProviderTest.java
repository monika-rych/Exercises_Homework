package marijuana;

import marijuana.provider.HistoricalLowestMediumQualityWeedPriceProvider;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import static org.assertj.core.api.Assertions.assertThat;

class HistoricalLowestMediumQualityWeedPriceProviderTest {

    @Test
    void should() {
        //given
        List<State> states = new ArrayList<>();
        State record1 = new State("Alabama", null, new BigDecimal("10"), null, null );
        State record2 = new State("Alabama", null, new BigDecimal("12"), null, null );
        State record3 = new State("New York", null, new BigDecimal(15), null, null );
        State record4 = new State("New York", null, new BigDecimal(20), null, null );
        State record5 = new State("New York", null, new BigDecimal(30), null, null );

        states.add(record1);
        states.add(record2);
        states.add(record3);
        states.add(record4);
        states.add(record5);

        //when
        HistoricalLowestMediumQualityWeedPriceProvider provider = new HistoricalLowestMediumQualityWeedPriceProvider();
        Map<String, BigDecimal> actual = provider.get(states);

        //then
        var hasValue1 = actual.containsKey("Alabama");
        var hasValue2 = actual.containsKey("New York");
        assertThat(hasValue1).isTrue();
        assertThat(hasValue2).isTrue();

        var actualForAlabama = actual.get("Alabama");
        var actualForNewYork = actual.get("New York");
        assertThat(actualForAlabama).isEqualTo(new BigDecimal(10));
        assertThat(actualForNewYork).isEqualTo(new BigDecimal(15));

    }

}