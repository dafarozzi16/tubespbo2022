package game.item;

public class Weapon extends Item {
    private int damage;

    public Weapon(String type, int damage, int price) {
        super(type, price);
        this.damage = damage;
    }

    public int getDamage() {
        return damage;
    }

    public void setDamage(int damage) {
        this.damage = damage;
    }

    public void addDamage(int damage) {
        this.damage += damage;
    }

    @Override
    public int getStat() { return getDamage(); }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Weapon)) return false;
        if (!super.equals(o)) return false;
        Weapon weapon = (Weapon) o;
        return getDamage() == weapon.getDamage();
    }

    @Override
    public int hashCode() {
        return 0;
    }

    @Override
    public String toString() {
        return "Weapon{" +
                "damage=" + damage +
                "} " + super.toString();
    }
}
