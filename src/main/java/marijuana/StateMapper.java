package marijuana;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Optional;
import java.util.logging.Level;
import java.util.logging.Logger;

public class StateMapper {
    Logger logger = Logger.getLogger(StateMapper.class.getName());

    public Optional<State> fromLine(String[] fields) {

        try {
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
            return Optional.of(
                    State.builder()
                            .stateName(fields[0])
                            .highQualityWeedPrice(new BigDecimal(fields[1]))
                            .mediumQualityWeedPrice(new BigDecimal(fields[3]))
                            .lowQualityWeedPrice(new BigDecimal(fields[5]))
                            .data(LocalDate.parse(fields[7], formatter))
                            .build()
            );
        } catch (NumberFormatException number) {
            logger.log(Level.INFO, "State with name " + fields[0] + " has wrong data.");
        }
        return Optional.empty();
    }


}
