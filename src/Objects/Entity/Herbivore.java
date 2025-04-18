package Objects.Entity;

import Objects.Actions.SearchWay;
import Objects.Map;

import java.util.ArrayList;
import java.util.Set;

import static Objects.Actions.SearchWay.waySearch;
import static Objects.Map.*;
import static Objects.Map.getMap;

public class Herbivore extends Creature {
    private int hp = 100;
    private char symbol = 'O';
    private char sacrificeSymbol = '"';

    @Override
    public char getSymbol() {
        return symbol;
    }

    public int getHp() {
        return hp;
    }

    public void setHp(int hp) {
        this.hp = hp;
    }


    public void makeMove(String whoIsLookingKey) {
        Entity entity = getMap().get(whoIsLookingKey);
        ArrayList<Cell> way;
        int x = 0;
        int y = 0;
        do {
            way = waySearch(entity, sacrificeSymbol);
            x = way.get(0).getX();
            y = way.get(0).getY();
        } while (getMatrix()[y][x] == 'O');

        Set<String> keys = getMap().keySet();
        for (String key : keys) {
            if (getMap().get(key).getX() == x && getMap().get(key).getY() == y && getMap().get(key).getSymbol() == sacrificeSymbol) {
                getMap().remove(key);
                break;
            }
        }
        entity.setX(x);
        entity.setY(y);
        getMap().put(whoIsLookingKey, entity);
        getMatrix()[entity.getY()][entity.getX()] = entity.getSymbol();
        way.clear();
    }
}
