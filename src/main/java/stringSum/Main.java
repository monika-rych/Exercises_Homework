package stringSum;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Main {
    public static void main(String[] args) {
        String text = "ab12cx-3se---6d";
        String naszeWyrazenieRegularne = "-?\\d+";
        Pattern pattern = Pattern.compile(naszeWyrazenieRegularne);
        Matcher matcher = pattern.matcher(text);
        int sum = 0;
        while (matcher.find()) {
            String numberAsString = matcher.group();
            System.out.print(numberAsString);
            sum += Integer.parseInt(numberAsString);
        }
        System.out.println("=" + sum);
    }
}
