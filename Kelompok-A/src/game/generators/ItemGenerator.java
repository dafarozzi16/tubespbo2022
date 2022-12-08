package game.generators;

import game.item.Armor;
import game.item.Item;
import game.item.Weapon;
import game.item.armor.Arms;
import game.item.armor.Head;
import game.item.armor.Legs;
import game.item.armor.Torso;

import java.util.ArrayList;
import java.util.Random;

public class ItemGenerator {
    static Random rand = new Random();

    public static ArrayList<Item> items() {
        ArrayList<Item> items = new ArrayList<>();

        items.add(new Weapon("knife", 3,10));
        items.add(new Weapon("dagger", 6,20));
        items.add(new Weapon("sword", 10,50));
        items.add(new Weapon("rapier", 20,100));
        items.add(new Weapon("axe", 30,150));
        items.add(new Weapon("spear", 40,200));
        items.add(new Weapon("halberd", 50,250));
        items.add(new Weapon("scythe", 60,300));

        items.add(new Arms("gloves", 5,15));
        items.add(new Arms("bracers", 10,30));
        items.add(new Arms("armlets", 20,60));
        items.add(new Arms("gauntlets", 30,90));

        items.add(new Legs("shorts", 10,30));
        items.add(new Legs("pants", 20,60));
        items.add(new Legs("chausses", 40,120));
        items.add(new Legs("greaves", 60,200));

        items.add(new Torso("shirt", 10,40));
        items.add(new Torso("vest", 30,140));
        items.add(new Torso("mail", 50,200));
        items.add(new Torso("breastplate", 80,300));

        items.add(new Head("hood", 10,40));
        items.add(new Head("cap", 20,80));
        items.add(new Head("helmet", 40,150));

        return items;
    }

    public static Item descriptor(Item item) {

        String desc = "";
        
        switch(item.getClass().getSimpleName())
        {   case "Weapon": desc = setWeapon((Weapon) item); break;
            case "Arms":
            case "Legs":
            case "Torso":
            case "Head":
                desc = setArmor((Armor) item); break;
            default: break;
        }

        item.setName(desc + " " + item.getType());

        return item;
    }

    private static String setWeapon(Weapon weapon){
        String[] materials = {"wooden", "bone", "bronze", "iron", "steel", "emerald", "obsidian"};
        String material = materials[rand.nextInt(materials.length)];
        String quality = "";
        switch(material)
        {   case "wooden": quality = setWeaponQ(weapon);
                weapon.setDamage((int) (weapon.getDamage()*0.3 -1));
                weapon.setPrice((int) (weapon.getPrice()*0.3 -1)); break;
            case "bone": quality = setWeaponQ(weapon);
                weapon.setDamage((int) (weapon.getDamage()*0.6));
                weapon.setPrice((int) (weapon.getPrice()*0.6)); break;
            case "bronze": quality = setWeaponQ(weapon);
                weapon.setDamage((int) (weapon.getDamage()*0.9 +1));
                weapon.setPrice((int) (weapon.getPrice()*0.3 +1)); break;
            case "iron": quality = setWeaponQ(weapon);
                weapon.setDamage((int) (weapon.getDamage()*1.5 +5));
                weapon.setPrice((int) (weapon.getPrice()*1.5 +5)); break;
            case "steel": quality = setWeaponQ(weapon);
                weapon.setDamage(weapon.getDamage()*2 +10);
                weapon.setPrice(weapon.getPrice()*2 +10); break;
            case "emerald": quality = setWeaponQ(weapon);
                weapon.setDamage(weapon.getDamage()*3 +20);
                weapon.setPrice(weapon.getPrice()*3 +20); break;
            case "obsidian": quality = setWeaponQ(weapon);
                weapon.setDamage(weapon.getDamage()*5 +50);
                weapon.setPrice(weapon.getPrice()*5 +50); break;
            default: break;
        }

        return  quality + " " + material;
    }

    private static String setWeaponQ(Weapon weapon){
        String[] qualities = {"broken", "old", "blunt", "common", "casual" , "mystical",
                "plain", "uncommon", "sharp", "rare", "great", "enchanted", "epic" , "legendary"};
        String quality = qualities[rand.nextInt(qualities.length)];
        switch(quality)
        {   case "broken":
                weapon.setDamage((int) (weapon.getDamage()*0.3 -1));
                weapon.setPrice((int) (weapon.getPrice()*0.3 -1)); break;
            case "old":
                weapon.setDamage((int) (weapon.getDamage()*0.5 -1));
                weapon.setPrice((int) (weapon.getPrice()*0.5 -1)); break;
            case "blunt":
                weapon.setDamage((int) (weapon.getDamage()*0.7 -1));
                weapon.setPrice((int) (weapon.getPrice()*0.7 -1)); break;
            case "common":
                weapon.setDamage((int) (weapon.getDamage()*0.9));
                weapon.setPrice((int) (weapon.getPrice()*0.9)); break;
            case "casual":
                weapon.setDamage(weapon.getDamage()+1);
                weapon.setPrice(weapon.getPrice()+1); break;
            case "plain":
                weapon.setDamage((int) (weapon.getDamage()*1.1));
                weapon.setPrice((int) (weapon.getPrice()*1.1)); break;
            case "uncommon":
                weapon.setDamage((int) (weapon.getDamage()*1.3 +2));
                weapon.setPrice((int) (weapon.getPrice()*1.3 +2)); break;
            case "sharp":
                weapon.setDamage((int) (weapon.getDamage()*1.5 +3));
                weapon.setPrice((int) (weapon.getPrice()*1.5 +3)); break;
            case "rare":
                weapon.setDamage((int) (weapon.getDamage()*1.8 +4));
                weapon.setPrice((int) (weapon.getPrice()*1.8 +4)); break;
            case "mystical":
                weapon.setDamage((int) (weapon.getDamage()*2.1 +6));
                weapon.setPrice((int) (weapon.getPrice()*2.1 +6)); break;
            case "great":
                weapon.setDamage((int) (weapon.getDamage()*2.5 +10));
                weapon.setPrice((int) (weapon.getPrice()*2.5 +10)); break;
            case "enchanted":
                weapon.setDamage(weapon.getDamage()*3 +20);
                weapon.setPrice(weapon.getPrice()*3 +20); break;
            case "epic":
                weapon.setDamage(weapon.getDamage()*5 +30);
                weapon.setPrice(weapon.getPrice()*5 +30); break;
            case "legendary":
                weapon.setDamage(weapon.getDamage()*10 +50);
                weapon.setPrice(weapon.getPrice()*10 +100); break;
            default: break;
        }
        return quality;
    }

    private static String setArmor(Armor armor){
        String[] materials = {"leather", "bone", "bronze", "iron", "steel", "emerald", "obsidian"};
        String material = materials[rand.nextInt(materials.length)];
        String quality = "";
        switch(material)
        {   case "leather": quality = setArmorQ(armor);
            armor.setDefence((int) (armor.getDefence()*0.3 -1));
            armor.setPrice((int) (armor.getPrice()*0.3 -1)); break;
            case "bone": quality = setArmorQ(armor);
                armor.setDefence((int) (armor.getDefence()*0.6));
                armor.setPrice((int) (armor.getPrice()*0.6)); break;
            case "bronze": quality = setArmorQ(armor);
                armor.setDefence((int) (armor.getDefence()*0.9 +1));
                armor.setPrice((int) (armor.getPrice()*0.3 +1)); break;
            case "iron": quality = setArmorQ(armor);
                armor.setDefence((int) (armor.getDefence()*1.5 +5));
                armor.setPrice((int) (armor.getPrice()*1.5 +5)); break;
            case "steel": quality = setArmorQ(armor);
                armor.setDefence(armor.getDefence()*2 +10);
                armor.setPrice(armor.getPrice()*2 +10); break;
            case "emerald": quality = setArmorQ(armor);
                armor.setDefence(armor.getDefence()*3 +20);
                armor.setPrice(armor.getPrice()*3 +20); break;
            case "obsidian": quality = setArmorQ(armor);
                armor.setDefence(armor.getDefence()*5 +50);
                armor.setPrice(armor.getPrice()*5 +50); break;
            default: break;
        }

        return  quality + " " + material;
    }

    private static String setArmorQ(Armor armor){
        String[] qualities = {"damaged", "old", "leaky", "common", "casual" , "mystical",
                "plain", "uncommon", "decorated", "rare", "great", "enchanted", "epic" , "legendary"};
        String quality = qualities[rand.nextInt(qualities.length)];
        switch(quality)
        {   case "damaged":
                armor.setDefence((int) (armor.getDefence()*0.3 -1));
                armor.setPrice((int) (armor.getPrice()*0.3 -1)); break;
            case "old":
                armor.setDefence((int) (armor.getDefence()*0.5 -1));
                armor.setPrice((int) (armor.getPrice()*0.5 -1)); break;
            case "leaky":
                armor.setDefence((int) (armor.getDefence()*0.7 -1));
                armor.setPrice((int) (armor.getPrice()*0.7 -1)); break;
            case "common":
                armor.setDefence((int) (armor.getDefence()*0.9));
                armor.setPrice((int) (armor.getPrice()*0.9)); break;
            case "casual":
                armor.setDefence(armor.getDefence()+1);
                armor.setPrice(armor.getPrice()+1); break;
            case "plain":
                armor.setDefence((int) (armor.getDefence()*1.1));
                armor.setPrice((int) (armor.getPrice()*1.1)); break;
            case "uncommon":
                armor.setDefence((int) (armor.getDefence()*1.3 +2));
                armor.setPrice((int) (armor.getPrice()*1.3 +2)); break;
            case "decorated":
                armor.setDefence((int) (armor.getDefence()*1.5 +3));
                armor.setPrice((int) (armor.getPrice()*1.5 +3)); break;
            case "rare":
                armor.setDefence((int) (armor.getDefence()*1.8 +4));
                armor.setPrice((int) (armor.getPrice()*1.8 +4)); break;
            case "mystical":
                armor.setDefence((int) (armor.getDefence()*2.1 +6));
                armor.setPrice((int) (armor.getPrice()*2.1 +6)); break;
            case "great":
                armor.setDefence((int) (armor.getDefence()*2.5 +10));
                armor.setPrice((int) (armor.getPrice()*2.5 +10)); break;
            case "enchanted":
                armor.setDefence(armor.getDefence()*3 +20);
                armor.setPrice(armor.getPrice()*3 +20); break;
            case "epic":
                armor.setDefence(armor.getDefence()*5 +30);
                armor.setPrice(armor.getPrice()*5 +30); break;
            case "legendary":
                armor.setDefence(armor.getDefence()*10 +50);
                armor.setPrice(armor.getPrice()*10 +100); break;
            default: break;
        }
        return quality;
    }

    public static Item newItem() {
        Item item = items().get(rand.nextInt(items().size()));
        item = descriptor(item);
        if(item instanceof Armor && ((Armor) item).getDefence()<1){ ((Armor) item).addDefence(1); }
        if(item instanceof Weapon && ((Weapon) item).getDamage()<1){ ((Weapon) item).addDamage(1); }
        return item;
    }

    public static Item newItemPriceRange(int begin, int end) {
        Item item = newItem();
        int i = 0;
        while(item.getPrice()<begin || item.getPrice()>end)
        { item = newItem(); i++;
            if(i==10000) {
                System.out.println("uwaga: prawdopodobnie nieskonczona petla w newItemPriceRange");
                break; }
        }
        return item;
    }

    public static Item newItemPriceRangeAndName(int begin, int end, String whatsInTheName) {
        Item item = newItem();
        int i = 0;
        while(item.getPrice()<begin || item.getPrice()>end || !item.getName().contains(whatsInTheName))
        { item = newItem(); i++;
            if(i==10000) {
                System.out.println("uwaga: prawdopodobnie nieskonczona petla w newItemPriceRangeAndName");
                break; }
        }
        return item;
    }

    public static Item newItemPriceRangeArmor(int begin, int end) {
        Item item = newItem();
        int i = 0;
        while(item.getPrice()<begin || item.getPrice()>end || item.getClass().getSimpleName().equals("Weapon"))
        { item = newItem(); i++;
            if(i==10000) {
                System.out.println("uwaga: prawdopodobnie nieskonczona petla w newItemPriceRangeArmor");
                break; }
        }
        return item;
    }

    public static Item newItemPriceRangeWeapon(int begin, int end) {
        Item item = newItem();
        int i = 0;
        while(item.getPrice()<begin || item.getPrice()>end || !item.getClass().getSimpleName().equals("Weapon"))
        { item = newItem(); i++;
            if(i>=10000) {
                System.out.println("uwaga: prawdopodobnie nieskonczona petla w newItemPriceRangeArmor");
                break; }
        }
        return item;
    }


}

