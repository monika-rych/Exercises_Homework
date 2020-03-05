package fileManagier;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Main {
    public static void main(String[] args) {

        String filePath = "C:/MojFolder2/brackets.txt";
        FileManager fileManager = new FileManager(filePath);

        String fileText = fileManager.readWholeFile();
        System.out.println(fileText);

        String naszeWyrazenieRegularne = "[^a-zA-Z]";
        Pattern pattern = Pattern.compile(naszeWyrazenieRegularne);
        Matcher matcher = pattern.matcher(fileText);
        while (matcher.find()) {
            System.out.print(matcher.group());
        }

    }

}
