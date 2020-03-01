package marijuana;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.List;
import java.util.Objects;
import java.util.Optional;

public class AverageBestStatePrice {

    public BigDecimal average(List<BigDecimal> bigDecimals, RoundingMode roundingMode) {

        BigDecimal sum = bigDecimals.stream()
                .map(Objects::requireNonNull)
                .reduce(BigDecimal.ZERO, BigDecimal::add);
        long count = bigDecimals.stream().filter(Objects::nonNull).count();
        return sum.divide(new BigDecimal(count), roundingMode);
    }
}
