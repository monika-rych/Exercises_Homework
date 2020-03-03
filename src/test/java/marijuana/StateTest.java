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

    @Test
    void lowestPrice_highestIsLowest_shouldReturnHighest() {
        //given
        State state = new State("", new BigDecimal("4"), new BigDecimal("9"), new BigDecimal("5"),null);
        //when
        BigDecimal actual = state.lowestPrice();
        //then
        assertThat(actual).isEqualTo(new BigDecimal(4));
    }

    @Test
    void lowestPrice_mediumIsLowest_shouldReturnMedium() {
        //given
        State state = new State("", new BigDecimal("4"), new BigDecimal("3"), new BigDecimal("5"),null);
        //when
        BigDecimal actual = state.lowestPrice();
        //then
        assertThat(actual).isEqualTo(new BigDecimal(3));
    }

    @Test
    void lowestPrice_lowIsLowest_shouldReturnLow() {
        //given
        State state = new State("", new BigDecimal("4"), new BigDecimal("3"), new BigDecimal("1"),null);
        //when
        BigDecimal actual = state.lowestPrice();
        //then
        assertThat(actual).isEqualTo(new BigDecimal(1));
    }

    @Test
    void lowestPrice_lowIsLowestAndHighIsLoverThanMedium_shouldReturnLow() {
        //given
        State state = new State("", new BigDecimal("50"), new BigDecimal(60), new BigDecimal("3"), null);
        //when
        BigDecimal actual = state.lowestPrice();
        //then
        assertThat(actual).isEqualTo(new BigDecimal(3));
    }

    @Test
    void lowestPrice_bug2() {
        //given
        State state = new State("", new BigDecimal(1), new BigDecimal(1), new BigDecimal(1), null);
        //when
        BigDecimal actual = state.lowestPrice();
        //then
        assertThat(actual).isEqualTo(new BigDecimal(1));
    }

    @Test
    void lowestPrice_bug3() {
        //given
        State state = new State("", new BigDecimal(1), new BigDecimal(1), new BigDecimal(4), null);
        //when
        BigDecimal actual = state.lowestPrice();
        //then
        assertThat(actual).isEqualTo(new BigDecimal(1));
    }

    @Test
    void lowestPrice_bug4() {
        //given
        State state = new State("", new BigDecimal(2), new BigDecimal(1), new BigDecimal(1), null);
        //when
        BigDecimal actual = state.lowestPrice();
        //then
        assertThat(actual).isEqualTo(new BigDecimal(1));
    }

}