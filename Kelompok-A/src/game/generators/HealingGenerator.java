package game.generators;


import game.item.Healing;

import java.util.ArrayList;
import java.util.Random;

public class HealingGenerator {
    static Random rand = new Random();

    public static ArrayList<Healing> healing() {
        ArrayList<Healing> healing = new ArrayList<>();

        healing.add(new Healing("green apple", 5,10));
        healing.add(new Healing("red apple", 6,15));
        healing.add(new Healing("black berries", 8,20));
        healing.add(new Healing("pear", 10,30));
        healing.add(new Healing("buns", 12,35));
        healing.add(new Healing("sweet-roll", 14,40));
        healing.add(new Healing("wheat bread", 15,45));
        healing.add(new Healing("rye bread", 17,50));
        healing.add(new Healing("small healing potion", 20,60));
        healing.add(new Healing("apple pie", 25,70));
        healing.add(new Healing("plum pie", 27,85));
        healing.add(new Healing("pudding", 30,90));
        healing.add(new Healing("light beer", 35,100));
        healing.add(new Healing("dark beer", 40,120));
        healing.add(new Healing("red wine", 50,150));
        healing.add(new Healing("white wine", 60,180));
        healing.add(new Healing("medium healing potion", 80,200));
        healing.add(new Healing("chicken meat", 85,220));
        healing.add(new Healing("rabbit meat", 90,250));
        healing.add(new Healing("pheasant meat", 100,300));
        healing.add(new Healing("goose meat", 110,350));
        healing.add(new Healing("horse meat", 130,400));
        healing.add(new Healing("deer meat", 150,450));
        healing.add(new Healing("bison meat", 200,600));
        healing.add(new Healing("large healing potion", 300,1000));
        healing.add(new Healing("super healing potion", 600,2000));

        return healing;
    }

    private static Healing setHealing(Healing healing){
        String[] descriptions = {"rotten", "moldy", "outdated", "ordinary", "fine", "good", "delicious", "perfect"};

        if (healing.getType().contains("potion")){
            return healing;
        }

        String description = descriptions[rand.nextInt(descriptions.length)];
        switch(description)
        {   case "rotten":
                healing.setRestore((int) (healing.getRestore()*0.2 -2));
            healing.setPrice((int) (healing.getPrice()*0.2 -1)); break;
            case "moldy":
                healing.setRestore((int) (healing.getRestore()*0.4));
                healing.setPrice((int) (healing.getPrice()*0.4)); break;
            case "outdated":
                healing.setRestore((int) (healing.getRestore()*0.7 +1));
                healing.setPrice((int) (healing.getPrice()*0.7 +1)); break;
            case "fine":
                healing.setRestore((int) (healing.getRestore()*1.2 +5));
                healing.setPrice((int) (healing.getPrice()*1.2 +5)); break;
            case "good":
                healing.setRestore((int) (healing.getRestore()*1.8 +10));
                healing.setPrice((int) (healing.getPrice()*1.8 +10)); break;
            case "delicious":
                healing.setRestore((int) (healing.getRestore()*2.5 +20));
                healing.setPrice((int) (healing.getPrice()*2.5 +20)); break;
            case "perfect":
                healing.setRestore(healing.getRestore()*4 +50);
                healing.setPrice(healing.getPrice()*4 +50); break;
            default: break;
        }

        healing.setName(description + " " + healing.getType());
        return healing;
    }

    public static Healing newHealing() {
        Healing healing = healing().get(rand.nextInt(healing().size()));
        healing = setHealing(healing);
        if (healing.getRestore() < 1){ healing.setRestore(1); }
        return healing;
    }

    public static Healing newPotion() {
        Healing healing = newHealing();
        int i = 0;
        while(!healing.getName().contains("potion"))
        { healing = newHealing(); i++;
            if(i==10000) {
                System.out.println("uwaga: prawdopodobnie nieskonczona petla w newPotion");
                break; }
        }
        return healing;
    }

    public static Healing newHealingNotPotion() {
        Healing healing = newHealing();
        int i = 0;
        while(healing.getName().contains("potion"))
        { healing = newHealing(); i++;
            if(i==10000) {
                System.out.println("uwaga: prawdopodobnie nieskonczona petla w newPotion");
                break; }
        }
        return healing;
    }


    public static Healing newHealingPriceRange(int begin, int end) {
        Healing healing = newHealing();
        int i = 0;
        while(healing.getPrice()<begin || healing.getPrice()>end)
        { healing = newHealing(); i++;
            if(i==10000) {
                System.out.println("uwaga: prawdopodobnie nieskonczona petla w newHealingPriceRange");
                break; }
        }
        return healing;
    }

    public static Healing newHealingPriceRangeAndName(int begin, int end, String whatsInTheName) {
        Healing healing = newHealing();
        int i = 0;
        while(healing.getPrice()<begin || healing.getPrice()>end || !healing.getName().contains(whatsInTheName))
        { healing = newHealing(); i++;
            if(i==10000) {
                System.out.println("uwaga: prawdopodobnie nieskonczona petla w newHealingPriceRangeAndName");
                break; }
        }
        return healing;
    }
}
