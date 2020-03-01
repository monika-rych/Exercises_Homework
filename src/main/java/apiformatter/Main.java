package apiformatter;

public class Main {
    public static void main(String[] args) {
        WordValueProvider wordValueProvider = new AsciiValueWithStreamsAndReduce();
        String text = "gfvfvfgbgh";
        int value = wordValueProvider.get(text);
        
        System.out.println(value);

    }
}
