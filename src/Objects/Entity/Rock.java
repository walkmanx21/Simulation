package Objects.Entity;

public class Rock extends Entity {

    private static final char SYMBOL = 'A';

    @Override
    public char getSymbol() {
        return SYMBOL;
    }

    public Rock(String name) {
        super(name);
    }
}
