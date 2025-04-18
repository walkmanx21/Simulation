import Objects.Actions.*;
import Objects.Map;

public class Simulation extends Map {
    private static final int PREDATORS = 1;
    private static final int ROCKS = 15;
    private static final int TREES = 15;
    private static final int GRASSES = 50;
    private static final int HERBIVORES = 15;
    private static final int TIME = 500;

    public static void main(String[] args) throws InterruptedException {
        TurnActions turnActions = new TurnActions();
        turnActions.startSimulation(PREDATORS, HERBIVORES, ROCKS, TREES, GRASSES, TIME);
    }
}
