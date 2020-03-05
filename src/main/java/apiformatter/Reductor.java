package apiformatter;

import java.util.function.IntBinaryOperator;

public class Reductor implements IntBinaryOperator {

    @Override
    public int applyAsInt(int left, int right) {
        return left + right;
    }
}
