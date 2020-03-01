package marijuana;

import org.junit.jupiter.api.Test;
import java.math.BigDecimal;
import static org.assertj.core.api.Assertions.assertThat;


class StateTest {
    @Test
    void averagePrice_shouldReturnAverage() {
        //given
        State state = new State("", new BigDecimal("4"), new BigDecimal("3"), new BigDecimal("5"),null);
        //when
        BigDecimal actual = state.averagePrice();
        //then
        assertThat(actual).isEqualTo(new BigDecimal(4));
    }

}