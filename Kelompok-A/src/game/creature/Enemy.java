package game.creature;

import game.item.Item;

import java.util.List;
import java.util.Random;



import java.util.ArrayList;

public class Enemy extends Creature {
    protected String race = "";
    protected List<Item> possibleDrop = new ArrayList<>();
    static Random rand = new Random();
    boolean sentient = false;

    public Enemy(){}

    public Enemy(String race, int maxhp, int armor, int attack, int exp, int money) {
        super(maxhp, armor, attack, exp, money);
        this.race = race;
    }

    public String getRace() { return race; }

    public List<Item> getPossibleDrop() { return possibleDrop; }
    public void setPossibleDrop(List<Item> possibleDrop) { this.possibleDrop = possibleDrop; }
    public void addPossibleDrop(List<Item> addedDrop) {
        List<Item> merged = new ArrayList<>(this.getPossibleDrop());
        merged.addAll(addedDrop);
        this.setPossibleDrop(merged);
    }

    public Item getRandomDrop() {
        return this.getPossibleDrop().get(rand.nextInt(this.possibleDrop.size()));
    }

    public boolean isSentient() { return sentient; }
    public void setSentient(boolean sentient) { this.sentient = sentient; }

    @Override
    public String toString() {
        return "Enemy{" +
                "race='" + race + '\'' +
                ", name='" + name + '\'' +
                ", hp=" + hp +
                ", maxhp=" + maxhp +
                ", armor=" + armor +
                ", attack=" + attack +
                ", exp=" + exp +
                ", money=" + money +
                ", possibleDrop=" + possibleDrop +
                '}';
    }
}
