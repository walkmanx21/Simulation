package Objects.Actions;

import Objects.Entity.Grass;
import Objects.Entity.Herbivore;
import Objects.Entity.Predator;

import java.util.*;

import static Objects.Actions.InitActions.setAllEntitiesInMatrix;
import static Objects.Map.*;
import static Objects.Renderer.showMatrix;

public class TurnActions {

    public void startSimulation(int predators, int herbivores, int rocks, int trees, int grasses, int time) throws InterruptedException {
        createMatrix();
        setAllEntitiesInMatrix(predators, herbivores, rocks, trees, grasses);
        showMatrix();
        pauseSimulation(time);

        LinkedList<String> survivingHerbivores = createList("herbivore", herbivores);
        int iteration = 0;
        while (!checkSurvivingEntities(survivingHerbivores)) {
            nextTurn(getMatrix(), predators, herbivores, grasses);
            pauseSimulation(time);
            iteration++;
        }
        System.out.println("\nВыполнено ходов: " + iteration + ".");
    }

    public void nextTurn(char[][] matrix, int predators, int herbivores, int grasses) {
        massMakeMove(predators, "predator");
        massMakeMove(herbivores, "herbivore");

        LinkedList<String> grass = survivingEntities(grasses, "grass");
        if (grass.size() <= 7) {
            for (int i = 0; i < grasses; i++) {
                createEntityInMatrix(new Grass("grass" + i));
                grass.add("grass" + i);
            }
        }

        updateEntitiesInMatrix();
        showMatrix();
    }

    private void pauseSimulation(int time) throws InterruptedException {
        Thread.sleep(time);
    }

    private boolean checkSurvivingEntities(LinkedList<String> survivingEntities) {
        String removeEntity = null;
        for (String verifiable : survivingEntities) {
            if (!getMap().containsKey(verifiable)) {
                removeEntity = verifiable;
            }
        }
        survivingEntities.remove(removeEntity);
        return survivingEntities.isEmpty();
    }

    private LinkedList<String> createList(String entity, int quantity) {
        LinkedList<String> list = new LinkedList<>();
        for (int i = 0; i < quantity; i++) {
            list.add(entity + i);
        }
        return list;
    }

    private LinkedList<String> survivingEntities(int entities, String type) {
        LinkedList<String> survivor = createList(type, entities);
        String removeEntity = null;
        for (int i = 0; i < 100; i++) {
            for (String verifiable : survivor) {
                if (!getMap().containsKey(verifiable)) {
                    removeEntity = verifiable;
                }
            }
            survivor.remove(removeEntity);
        }
        return survivor;
    }

    private void massMakeMove(int entities, String type) {
        LinkedList<String> entities1 = survivingEntities(entities, type);
        for (String key : entities1) {
            if (key.contains("herbivore")) {
                Herbivore herbivore1 = (Herbivore) getMap().get(key);
                herbivore1.makeMove();
            }
            if (key.contains("predator")) {
                Predator predator1 = (Predator) getMap().get(key);
                predator1.makeMove();
            }
        }
    }
}
