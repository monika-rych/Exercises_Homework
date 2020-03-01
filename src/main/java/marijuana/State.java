package marijuana;

import lombok.*;

import java.math.BigDecimal;
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

}
