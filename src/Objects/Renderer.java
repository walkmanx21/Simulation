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

        for (char[] matrix : MATRIX) {
            for (char ch : matrix) {
                switch (ch) {
                    case ('"'):
                        System.out.print(GREEN + ch + RESET);
                        break;
                    case ('O'):
                        System.out.print(BLUE + ch + RESET);
                        break;
                    case ('X'):
                        System.out.print(RED + ch + RESET);
                        break;
                    default:
                        System.out.print(ch);
                }
            }
            System.out.println();
        }
    }
}