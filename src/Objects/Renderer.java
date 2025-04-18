package Objects;

import java.util.HashMap;

import static Objects.Map.MATRIX;

public class Renderer {

    private static final String RESET = "\u001B[0m";
    private static final String GREEN = "\u001B[32m";
    private static final String BLUE = "\u001B[34m";
    private static final String RED = "\u001B[31m";
    private static final String NO_COLOR = "";
    private static final HashMap<Character, String> color = new HashMap<>(){{
        put('"', GREEN);
        put('O', BLUE);
        put('X', RED);
        put(' ', NO_COLOR);
        put('|', NO_COLOR);
        put('T', NO_COLOR);
        put('A', NO_COLOR);
    }};

    public static void showMatrix() {
        System.out.print("\033[H\033[2J");
        System.out.println("\nWelcome to the simulation!\nA - rock, Т - tree, \" - grass, O - herbivore, X - predator.\n");
        for (char[] matrix : MATRIX) {
            for (char ch : matrix) {
                printChar(ch);
            }
            System.out.println();
        }
    }

    private static void printChar (char ch) {
        System.out.print(color.get(ch) + ch + RESET);
    }
}