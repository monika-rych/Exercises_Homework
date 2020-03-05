package apiformatter;

public class AsciiValueWithStreamsAndReduce implements WordValueProvider {
    @Override
    public int get(String text) {
        return text.chars().reduce(0, new Reductor());
    }


}
