package game.item;

import java.util.Objects;

// TODO isEquipped ?

public class Item {
    private String type;
    private String name;
    private int price;
    public boolean isEquipped;

    public Item(){}

    public Item(String type, int price) {
        this.type = type;
        this.name = type;
        this.price = price;
        this.isEquipped = false;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public String getType() {
        return type;
    }

    public int getStat() { return 0; }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Item)) return false;
        Item item = (Item) o;
        return getPrice() == item.getPrice() &&
                isEquipped == item.isEquipped &&
                Objects.equals(getName(), item.getName());
    }
    @Override
    public int hashCode() {
        return 0;
    }

    @Override
    public String toString() {
        return "Item{" +
                "type='" + type + '\'' +
                ", name='" + name + '\'' +
                ", price=" + price +
                '}';
    }
}