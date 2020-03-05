package apiformatter;

public class AsciiValue implements WordValueProvider {

    @Override
    public int get(String text) {
        int sum = 0;
        for (int i = 0; i < text.length(); i++) {
            sum += text.charAt(i);
        }
        return sum;
    }
}

