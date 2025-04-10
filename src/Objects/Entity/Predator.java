package Objects.Entity;

import java.util.ArrayList;
import java.util.Set;

import static Objects.Actions.SearchWay.waySearch;
import static Objects.Map.MATRIX;
import static Objects.Map.getMap;

public class Predator extends Creature {
    private int attackPower = 100;
    private int speed = 2;
    private char symbol = 'X';
    private char sacrificeSymbol = 'O';

    @Override
    public char getSymbol() {
        return symbol;
    }

    public void makeMove(String whoIsLookingKey) {
        Entity entity = getMap().get(whoIsLookingKey);
        ArrayList<Cell> way;
        int x = 0;
        int y = 0;
        do {
            way = waySearch(entity, sacrificeSymbol);
            if (speed > 1 && way.size() > speed) {
                x = way.get(speed - 1).getX();
                y = way.get(speed - 1).getY();
            } else if (speed > 1 && way.size() < speed) {
                x = way.get(way.size() - 1).getX();
                y = way.get(way.size() - 1).getY();
            } else {
                x = way.get(0).getX();
                y = way.get(0).getY();
            }
        } while (MATRIX[y][x] == 'X');
        Set<String> keys = getMap().keySet();
        entity.setX(x);
        entity.setY(y);
        getMap().put(whoIsLookingKey, entity);
        MATRIX[entity.getY()][entity.getX()] = entity.getSymbol();
        way.clear();
        for (String key : keys) {
            if (getMap().get(key).getX() == x && getMap().get(key).getY() == y && getMap().get(key).getSymbol() == sacrificeSymbol) {
                Herbivore herbivore1 = (Herbivore) getMap().get(key);
                int hp = herbivore1.getHp();
                herbivore1.setHp(hp - attackPower);
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
