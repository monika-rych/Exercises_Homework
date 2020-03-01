package fileManagier;

import java.io.BufferedReader;
import java.io.BufferedWriter;

import java.io.*;
public class FileManager {

    private String filePath;
   // private BufferedWriter bufferedWriter;
    private BufferedReader bufferedReader;

    public FileManager(String filePath) {
        this.filePath = filePath;
    }

    public void initReader(){
        try {
            // decorator
            bufferedReader = new BufferedReader(new FileReader(filePath));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public String readSentence() {
        String sentence = "";
        try {
            sentence = bufferedReader.readLine();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return sentence;
    }
    public void closeBufferedReader() {
        try {
            bufferedReader.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public String readWholeFile() {
        StringBuilder builder = new StringBuilder();

        try {
            String currentLine = bufferedReader.readLine();
            while (currentLine != null) {
                builder.append(currentLine);
                builder.append("\n");
                currentLine = bufferedReader.readLine();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return builder.toString();
    }
}
