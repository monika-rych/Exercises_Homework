package apiformatter;

public class AsciiValueWithStreams implements WordValueProvider{
    @Override
    public int get(String text) {
        return text.chars().sum();

    }
}
