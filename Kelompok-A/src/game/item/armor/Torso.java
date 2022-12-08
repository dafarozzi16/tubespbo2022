package game.item.armor;

import game.item.Armor;

public class Torso extends Armor {
    public Torso(String type, int defence, int price) {
        super(type, defence, price);
    }

    @Override
    public boolean equals(Object o) {
        return super.equals(o);
    }
    @Override
    public int hashCode() {
        return 0;
    }

    @Override
    public String toString() {
        return super.toString();
    }
}
