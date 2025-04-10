package Objects;

import Objects.Entity.Entity;

import java.util.ArrayList;
import java.util.Random;

import static Objects.Map.MATRIX;

public class Coordinates {

    private static final Random random = new Random();

    public static void setCoordinates(Entity entity) {
        ArrayList<Integer> arrayX = createCoordinatesX();
        ArrayList<Integer> arrayY = createCoordinatesY();
        entity.setX(arrayX.get(random.nextInt(arrayX.size())));
        entity.setY(arrayY.get(random.nextInt(arrayY.size())));
    }

    private static ArrayList<Integer> createCoordinatesX() {
        ArrayList<Integer> coordinatesX = new ArrayList<>();
        coordinatesX.add(2);
        for (int i = 6; i < MATRIX[1].length - 2; i++) {
            if (i % 4 == 2) {
                coordinatesX.add(i);
            }
        }
        return coordinatesX;
    }

    private static ArrayList<Integer> createCoordinatesY() {
        ArrayList<Integer> coordinatesY = new ArrayList<>();
        for (int i = 0; i < MATRIX.length - 2; i++) {
            coordinatesY.add(i+1);
        }
        return coordinatesY;
    }
}
