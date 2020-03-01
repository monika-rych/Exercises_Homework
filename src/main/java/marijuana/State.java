package marijuana;

import lombok.*;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.time.LocalDate;

@Builder
@AllArgsConstructor
@NoArgsConstructor
@ToString
@EqualsAndHashCode
@Getter

public class State {
    private String stateName;
    private BigDecimal highQualityWeedPrice;
    private BigDecimal mediumQualityWeedPrice;
    private BigDecimal lowQualityWeedPrice;
    private LocalDate data;


    public BigDecimal averagePrice(){
        BigDecimal sum = highQualityWeedPrice.add(mediumQualityWeedPrice).add(lowQualityWeedPrice);
        BigDecimal mean = sum.divide(new BigDecimal(3), RoundingMode.HALF_UP);
        return mean;
    }

    // nie rob compareto w tej klasie z porownaniem sredniej, to nie ma sensu wielkiego,
    // bo pozniej bedziesz cgciala porownywac wg innych kryteriow
    // dlatego te osobne komparatory sa lepsze
}
