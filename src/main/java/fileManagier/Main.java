package fileManagier;

import fileManagier.FileManager;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Main {
    public static void main(String[] args) {

        String filePath = "C:/MojFolder2/brackets.txt";
        FileManager fileManager = new FileManager(filePath);
        fileManager.initReader();

        String fileText = fileManager.readWholeFile();
        fileManager.closeBufferedReader();
        System.out.println(fileText);

        String naszeWyrazenieRegularne = "[^a-zA-Z]";
        Pattern pattern = Pattern.compile(naszeWyrazenieRegularne);
        Matcher matcher = pattern.matcher(fileText);
        while (matcher.find()) {
            System.out.print(matcher.group());
        }

    }

    private static void checkStringBuilder(int numberOfStringsToAdd) {


        StringBuilder sB = new StringBuilder();
        for (int i = 0; i < numberOfStringsToAdd; i++) {
            sB.append(" ").append(i).append("Programowanie jest super");
        }

    }
}
