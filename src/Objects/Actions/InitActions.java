package Objects.Actions;

import Objects.Entity.*;

import static Objects.Map.createEntityInMatrix;

public class InitActions {

    public static void setAllEntitiesInMatrix(int predators, int herbivores, int rocks, int trees, int grasses) {
        for (int i = 0; i < predators; i++) {
            createEntityInMatrix(new Predator("predator" + i));
        }
        for (int i = 0; i < rocks; i++) {
            createEntityInMatrix(new Rock("rock" + i));
        }
        for (int i = 0; i < trees; i++) {
            createEntityInMatrix(new Tree("tree" + i));
        }
        for (int i = 0; i < grasses; i++) {
            createEntityInMatrix(new Grass("grass" + i));
        }
        for (int i = 0; i < herbivores; i++) {
            createEntityInMatrix(new Herbivore("herbivore" + i));
        }
    }
}
