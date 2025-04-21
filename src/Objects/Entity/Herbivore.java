package Objects.Entity;

import java.util.ArrayList;
import java.util.Set;

import static Objects.Actions.SearchWay.waySearch;
import static Objects.Map.*;
import static Objects.Map.getMap;

public class Herbivore extends Creature {
    private int HP = 100;
    private static final char SYMBOL = 'O';
    private static final char SACRIFICE_SYMBOL = '"';

    public Herbivore(String name) {
        super(name);
    }

    @Override
    public char getSymbol() {
        return SYMBOL;
    }

    public int getHp() {
        return HP;
    }

    public void setHp(int hp) {
        this.HP = hp;
    }


    @Override
    public void makeMove() {
        String whoIsLookingKey = getName();
        Entity entity = getMap().get(whoIsLookingKey);
        ArrayList<Cell> way;
        int x = 0;
        int y = 0;
        do {
            way = waySearch(entity, SACRIFICE_SYMBOL);
            x = way.get(0).getX();
            y = way.get(0).getY();
        } while (getMatrix()[y][x] == 'O');

        Set<String> keys = getMap().keySet();
        for (String key : keys) {
            if (getMap().get(key).getX() == x && getMap().get(key).getY() == y && getMap().get(key).getSymbol() == SACRIFICE_SYMBOL) {
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
