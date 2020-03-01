package apiformatter;

import java.util.function.IntBinaryOperator;

public class Reductor {
    public IntBinaryOperator getReductor() {
        return (x, y) -> x + y;
    }
}
