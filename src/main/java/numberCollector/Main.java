package numberCollector;

import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Main {
    public static void main(String[] args) {
      String string = IntStream.of(1,23,4)
                .mapToObj(Integer::toString)
                .collect(Collectors.joining());
        System.out.println(string);
    }
}
