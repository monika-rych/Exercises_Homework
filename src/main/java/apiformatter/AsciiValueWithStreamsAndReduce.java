package apiformatter;

import java.util.function.IntBinaryOperator;

public class AsciiValueWithStreamsAndReduce implements WordValueProvider {
    @Override
    public int get(String text) {
        int value = text.chars().reduce(0, (x, y) -> x + y);
        return value;
    }


}
