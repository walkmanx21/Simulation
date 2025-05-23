package Objects.Entity;

import java.util.Objects;

public abstract class Entity {

    private int x;
    private int y;
    private char symbol;
    private String name;

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }

    public char getSymbol() {
        return symbol;
    }

    public String getName() {
        return name;
    }

    public Entity() {
    }

    public Entity(String name) {
        this.name = name;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Entity entity = (Entity) o;
        return x == entity.x && y == entity.y;
    }

    @Override
    public int hashCode() {
        return Objects.hash(x, y);
    }
}
