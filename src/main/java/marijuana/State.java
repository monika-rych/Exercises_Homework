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

    public BigDecimal lowestPrice(){
        if (highQualityWeedPrice.compareTo(mediumQualityWeedPrice) <= 0 && highQualityWeedPrice.compareTo(lowQualityWeedPrice) <= 0){
            return highQualityWeedPrice;
        }
        if (mediumQualityWeedPrice.compareTo(lowQualityWeedPrice) < 0){
            return mediumQualityWeedPrice;
        }
        return lowQualityWeedPrice;
    }
   /* public LocalDate youngestRecord(){

    }*/

}
