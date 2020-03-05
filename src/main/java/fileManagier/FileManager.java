package fileManagier;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
public class FileManager {

    private String filePath;

    public FileManager(String filePath) {
        this.filePath = filePath;
    }

    public String readWholeFile() {
        StringBuilder builder = new StringBuilder();

        try(BufferedReader bufferedReader = new BufferedReader(new FileReader(filePath))) {
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
