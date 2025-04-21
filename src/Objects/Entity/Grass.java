package Objects.Entity;

public class Grass extends Entity {

    private static final char SYMBOL = '"';

    @Override
    public char getSymbol() {
        return SYMBOL;
    }

    public Grass(String name) {
        super(name);
    }
}
