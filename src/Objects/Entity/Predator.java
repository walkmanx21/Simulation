package Objects.Entity;

import java.util.ArrayList;
import java.util.Set;

import static Objects.Actions.SearchWay.waySearch;
import static Objects.Map.*;
import static Objects.Map.getMap;

public class Predator extends Creature {
    private static final int ATTACK_POWER = 100;
    private static final int SPEED = 2;
    private static final char SYMBOL = 'X';
    private static final char SACRIFICE_SYMBOL = 'O';

    @Override
    public char getSymbol() {
        return SYMBOL;
    }

    public void makeMove(String whoIsLookingKey) {
        Entity entity = getMap().get(whoIsLookingKey);
        ArrayList<Cell> way;
        int x = 0;
        int y = 0;
        do {
            way = waySearch(entity, SACRIFICE_SYMBOL);
            if (SPEED > 1 && way.size() > SPEED) {
                x = way.get(SPEED - 1).getX();
                y = way.get(SPEED - 1).getY();
            } else if (SPEED > 1 && way.size() < SPEED) {
                x = way.get(way.size() - 1).getX();
                y = way.get(way.size() - 1).getY();
            } else {
                x = way.get(0).getX();
                y = way.get(0).getY();
            }
        } while (getMatrix()[y][x] == 'X');
        Set<String> keys = getMap().keySet();
        entity.setX(x);
        entity.setY(y);
        getMap().put(whoIsLookingKey, entity);
        getMatrix()[entity.getY()][entity.getX()] = entity.getSymbol();
        way.clear();
        for (String key : keys) {
            if (getMap().get(key).getX() == x && getMap().get(key).getY() == y && getMap().get(key).getSymbol() == SACRIFICE_SYMBOL) {
                Herbivore herbivore1 = (Herbivore) getMap().get(key);
                int hp = herbivore1.getHp();
                herbivore1.setHp(hp - ATTACK_POWER);
                if (herbivore1.getHp() != 0) {
                    break;
                } else {
                    getMap().remove(key);
                    break;
                }
            }
        }
    }
}
