package Objects.Actions;

import Objects.Entity.Cell;
import Objects.Entity.Entity;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;

import static Objects.Map.MATRIX;

public class SearchWay {

    private static final ArrayList<Cell> sortedNeighbors = new ArrayList<>();
    private static final HashSet<Cell> allNeighbors = new HashSet<>();
    private static ArrayList<Cell> way = new ArrayList<>();

    public static ArrayList<Cell> waySearch(Entity whoIsLooking, char sacrificeSymbol) {
        boolean found = false;
        searchNeighbors(whoIsLooking, 0);
        sortedNeighbors.addAll(allNeighbors);
        for (Cell cell : sortedNeighbors) {
            if (cell.getValue() == sacrificeSymbol) {
                found = true;
                break;
            }
        }
        if (!found) {
            for (int i = 1; i < 100; i++) {
                for (Cell cell : sortedNeighbors) {
                    searchNeighbors(cell, i);
                }
                sortedNeighbors.clear();
                sortedNeighbors.addAll(allNeighbors);
                for (Cell cell : sortedNeighbors) {
                    if (cell.getValue() == sacrificeSymbol) {
                        found = true;
                        break;
                    }
                }
                if (found) {
                    break;
                }
            }
        }
        int indexSacrifice = 0;
        for (Cell cell : sortedNeighbors) {
            if (cell.getValue() == sacrificeSymbol) {
                indexSacrifice = sortedNeighbors.indexOf(cell);
            }
        }
        way.add(sortedNeighbors.get(indexSacrifice));
        for (int i = 0; i < way.get(0).getIteration(); i++) {
            if (way.size() == way.get(0).getIteration() + 1) {
                break;
            }
            for (Cell cell : sortedNeighbors) {
                boolean iterationMatched = way.get(i).getIteration() - cell.getIteration() == 1;
                boolean coordinateXMatched = (Math.abs(cell.getX() - way.get(i).getX()) == 4) || (Math.abs(cell.getX() - way.get(i).getX()) == 0);
                boolean coordinateYMatched = (Math.abs(cell.getY() - way.get(i).getY()) == 1) || (Math.abs(cell.getY() - way.get(i).getY()) == 0);
                if (iterationMatched && coordinateYMatched && coordinateXMatched) {
                    way.add(cell);
                    break;
                }
            }
        }
        Collections.reverse(way);
        allNeighbors.clear();
        sortedNeighbors.clear();
        return way;
    }

    private static void searchNeighbors(Entity entity, int iteration) {
        Cell up, upLeft, upRight, down, downLeft, downRight, left, right;
        int x = entity.getX();
        int y = entity.getY();
        up = new Cell(iteration, x, y - 1, MATRIX[y - 1][x]);
        down = new Cell(iteration, x, y + 1, MATRIX[y + 1][x]);
        upLeft = new Cell(iteration, x - 4, y - 1);
        downLeft = new Cell(iteration, x - 4, y + 1);
        left = new Cell(iteration, x - 4, y);
        upRight = new Cell(iteration, x + 4, y - 1);
        downRight = new Cell(iteration, x + 4, y + 1);
        right = new Cell(iteration, x + 4, y);
        if (x >= 6) {
            upLeft.setValue(MATRIX[y - 1][x - 4]);
            downLeft.setValue(MATRIX[y + 1][x - 4]);
            left.setValue(MATRIX[y][x - 4]);
        } else {
            upLeft.setValue('|');
            downLeft.setValue('|');
            left.setValue('|');
        }
        if (x <= 62) {
            upRight.setValue(MATRIX[y - 1][x + 4]);
            downRight.setValue(MATRIX[y + 1][x + 4]);
            right.setValue(MATRIX[y][x + 4]);
        } else {
            upRight.setValue('|');
            downRight.setValue('|');
            right.setValue('|');
        }
        addNeighbour(allNeighbors, up);
        addNeighbour(allNeighbors, upLeft);
        addNeighbour(allNeighbors, upRight);
        addNeighbour(allNeighbors, left);
        addNeighbour(allNeighbors, right);
        addNeighbour(allNeighbors, down);
        addNeighbour(allNeighbors, downLeft);
        addNeighbour(allNeighbors, downRight);
    }

    private static void addNeighbour(HashSet<Cell> list, Cell cell) {
        if (cell.getValue() == ' ' || cell.getValue() == '"' || cell.getValue() == 'O') {
            list.add(cell);
        }
    }
}
