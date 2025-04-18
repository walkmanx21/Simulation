package Objects;

import Objects.Entity.*;

import java.util.*;

import static Objects.Coordinates.setCoordinates;

public class Map {

    private static final char[][] MATRIX = new char[17][69];
    private static final HashMap<String, Entity> MAP = new HashMap<>();

    public static void createMatrix() {
        for (int i = 0; i < MATRIX.length; i++) {
            for (int j = 0; j < MATRIX[i].length; j++) {
                if (i == 0 || i == MATRIX.length - 1) {
                    MATRIX[i][j] = '|';
                } else if (j % 4 == 0 || j == MATRIX[i].length - 1) {
                    MATRIX[i][j] = '|';
                } else {
                    MATRIX[i][j] = ' ';
                }
            }
        }
    }

    public static void createEntityInMatrix(Entity entity, String type) {
        setCoordinates(entity);
        if (MAP.isEmpty()) {
            MAP.put(type, entity);
        } else {
            do {
                setCoordinates(entity);
            } while (MATRIX[entity.getY()][entity.getX()] != ' ');
            MAP.put(type, entity);
        }
        MATRIX[entity.getY()][entity.getX()] = entity.getSymbol();
    }

    public static void updateEntitiesInMatrix() {
        createMatrix();
        Set<String> keys = MAP.keySet();
        for (String s : keys) {
            if (MATRIX[MAP.get(s).getY()][MAP.get(s).getX()] == ' ' || MATRIX[MAP.get(s).getY()][MAP.get(s).getX()] == '"') {
                    MATRIX[MAP.get(s).getY()][MAP.get(s).getX()] = MAP.get(s).getSymbol();
            }
        }
    }

    public static HashMap<String, Entity> getMap() {
        return MAP;
    }
    public static char[][] getMatrix() {
        return MATRIX;
    }
}

