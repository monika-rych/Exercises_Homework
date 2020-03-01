package stringSum;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Main {
    public static void main(String[] args) {
        String text = "ab12cx-3se---6d";
        text.split(",");
        String naszeWyrazenieRegularne = "[^a-zA-Z]";
        Pattern pattern = Pattern.compile(naszeWyrazenieRegularne);
        Matcher matcher = pattern.matcher(text);
        while (matcher.find()) {
            System.out.print(matcher.group());
        }


    }
}
