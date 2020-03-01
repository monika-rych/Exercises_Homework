package numberCollector;

import java.util.Arrays;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class Main {
    public static void main(String[] args) {
        int a = 100;

       // Character.toString((char)i);
        String b = String.valueOf(Character.toChars(a));
        System.out.println(b);

      /*  String string = Arrays.stream(numbers)
                .mapToObj(i->((Integer)i).toString().chars())
                .collect(Collectors.joining(","));
        System.out.println(string);*/
    }
}
