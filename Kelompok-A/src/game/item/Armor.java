package game.item;

public class Armor extends Item {

    private int defence;

    public Armor(){}

    public Armor(String name, int defence, int price) {
        super(name, price);
        this.defence = defence;
    }

    public int getDefence() {
        return defence;
    }

    public void setDefence(int defence) {
        this.defence = defence;
    }

    public void addDefence(int defence) {
        this.defence += defence;
    }

    @Override
    public int getStat() { return getDefence(); }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Armor)) return false;
        if (!super.equals(o)) return false;
        Armor armor = (Armor) o;
        return getDefence() == armor.getDefence();
    }
    @Override
    public int hashCode() {
        return 0;
    }

    @Override
    public String toString() {
        return "Armor{" +
                "defence=" + defence +
                "} " + super.toString();
    }
}
