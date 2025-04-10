package Objects;

import static Objects.Map.MATRIX;

public class Renderer {

    private static final String RESET = "\u001B[0m";
    private static final String GREEN = "\u001B[32m";
    private static final String BLUE = "\u001B[34m";
    private static final String RED = "\u001B[31m";

    public static void showMatrix() {
        System.out.print("\033[H\033[2J");
        System.out.println("\nWelcome to the simulation!\nA - rock, Т - tree, \" - grass, O - herbivore, X - predator.\n");
        for (int i = 0; i < MATRIX.length; i++) {
            for (int j = 0; j < MATRIX[i].length; j++) {
                if (i == 0 || i == MATRIX.length - 1) {
                    System.out.print(MATRIX[i][j]);
                } else if (MATRIX[i][j] == '"') {
                    System.out.print(GREEN + MATRIX[i][j] + RESET);
                } else if (MATRIX[i][j] == 'O') {
                    System.out.print(BLUE + MATRIX[i][j] + RESET);
                } else if (MATRIX[i][j] == 'X') {
                    System.out.print(RED + MATRIX[i][j] + RESET);
                } else {
                    System.out.print(MATRIX[i][j]);
                }
            }
            System.out.println();
        }
    }
}
