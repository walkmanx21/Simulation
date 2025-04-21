package Objects.Entity;

public class Tree extends Entity{
    private static final char SYMBOL = 'T';

    @Override
    public char getSymbol() {
        return SYMBOL;
    }

    public Tree(String name) {
        super(name);
    }
}
