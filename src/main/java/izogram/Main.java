package izogram;

import java.util.HashMap;
import java.util.Map;

public class Main {
    public static void main(String[] args) {

        String line = "Tata";

        Map<Character, Integer> mapa = new HashMap<>();
        for (int i = 0; i < line.length(); ++i) {
            char literka = line.toLowerCase().charAt(i);
            if (!mapa.containsKey(literka)) {
                mapa.put(literka, 0);
            }
            mapa.put(literka, mapa.get(literka) + 1);
        }
        for (Map.Entry<Character, Integer> entry : mapa.entrySet()) {
            System.out.println(entry.getKey() + ":" + entry.getValue());
        }
    }
}
