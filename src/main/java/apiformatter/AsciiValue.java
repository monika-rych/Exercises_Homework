package apiformatter;

public class AsciiValue implements WordValueProvider {

    @Override
    public int get(String text) {
        int sum = 0;
        for (int i = 0; i < text.length(); i++) {
            char ch = text.charAt(i);
            int asciiValue = ch;
            sum = sum + asciiValue;
        }
        return sum;
    }
}

