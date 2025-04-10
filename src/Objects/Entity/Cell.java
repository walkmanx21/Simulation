package Objects.Entity;

import java.util.Objects;

public class Cell extends Entity{
    private final int iteration;
    private int x;
    private int y;
    private char value;

    public Cell(int iteration, int x, int y, char value) {
        this.iteration = iteration;
        this.x = x;
        this.y = y;
        this.value = value;
    }

    public Cell(int iteration, int x, int y) {
        this.iteration = iteration;
        this.x = x;
        this.y = y;
    }

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

    public char getValue() {
        return value;
    }

    public int getIteration() {
        return iteration;
    }

    public void setValue(char value) {
        this.value = value;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Cell cell = (Cell) o;
        return x == cell.x && y == cell.y && value == cell.value;
    }

    @Override
    public int hashCode() {
        return Objects.hash(x, y, value);
    }
}
