package game.item;

public class Healing extends Item {
    private int restore;

    public Healing(String type, int restore, int price) {
        super(type, price);
        this.restore = restore;
    }

    public int getRestore() {
        return restore;
    }

    public void setRestore(int restore) {
        this.restore = restore;
    }

    @Override
    public int getStat() { return getRestore(); }

    @Override
    public String toString() {
        return "Healing{" +
                "restore=" + restore +
                "} " + super.toString();
    }
}
