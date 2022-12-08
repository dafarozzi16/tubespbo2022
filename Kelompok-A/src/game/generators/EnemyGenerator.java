package game.generators;

import game.creature.Enemy;
import game.item.*;
import game.item.armor.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Random;

public class EnemyGenerator {
    static Random rand = new Random();

    public static Enemy descriptor(Enemy enemy) {
        String[] desc = {"wounded", "small", "diseased",  // -EXP, -ATT/HP
                "completely average", "mediocre", "common", "typical", "plain", "boringly ordinary",
                "shaggy", "rare", // -/+MONEY
                "huge", "ferocious", "frenzied", // +EXP, +ATT/ARMOR/HP
                "massive",  // ++EXP, ++ATT, ++HP, +ARMOR, +MONEY
        };

        if(rand.nextInt(500)==0) {
            enemy.addHp(100 + enemy.getMaxhp());
            enemy.addArmor(10 + enemy.getArmor());
            enemy.addMoney(100 + enemy.getMoney());
            enemy.addAttack(10 + enemy.getAttack());
            enemy.addExp(20);
            enemy.setName("titanic " + enemy.getRace());
            return enemy;
        }

        String myDesc = desc[rand.nextInt(desc.length)];
        switch(myDesc)
        {   case "wounded": enemy.lowerHp(enemy.getMaxhp() /10 +2); enemy.lowerExp(1); break;
            case "small": enemy.lowerAttack(enemy.getAttack() /10 +1); enemy.lowerExp(1); break;
            case "diseased": enemy.lowerHp(enemy.getMaxhp() /10 +2);
                enemy.lowerAttack(enemy.getAttack() /10  +1); enemy.lowerExp(1); break;
            case "shaggy": enemy.lowerMoney(enemy.getMoney() /5 +1); break;
            case "rare": enemy.addMoney(enemy.getMoney() /5 +10); break;
            case "huge": enemy.addHp(enemy.getMaxhp() /10 +2); enemy.addExp(1);
                enemy.addArmor(enemy.getArmor() /10); break;
            case "ferocious": enemy.addAttack(enemy.getAttack() /10 +1); enemy.addExp(1); break;
            case "frenzied": enemy.addHp(enemy.getMaxhp() /10 +2);
                enemy.addAttack(enemy.getAttack() /10 +1); enemy.addExp(1); break;
            case "massive": enemy.addHp(enemy.getMaxhp() /5 +2); enemy.addArmor(1);
                enemy.addMoney(enemy.getMoney() /5 +5); enemy.addAttack(enemy.getAttack() /5 +1);
                enemy.addExp(2); break;
            default: break;
        }
        enemy.setName(myDesc + " " + enemy.getRace());
        return enemy;
    }

    protected static Enemy profession(Enemy enemy) {
        String[] desc = {"", "", "",  // NO CLASS
                " ranger",  //dagger
                " hunter", //knife
                " warrior",  //any ++EXP
                " swordsman",  //swords
                " spearman", //spears duh
                " axeman", //axe
                " soldier", //halberd
        };

        String[] desc2 = {"completely average", "typical", "female", "male", "boringly ordinary", "suspicious-looking"};

        enemy.setPossibleDrop(Arrays.asList(
                ItemGenerator.newItemPriceRangeArmor(enemy.getMoney() /2, enemy.getMoney()),
                ItemGenerator.newItemPriceRangeArmor(enemy.getMoney() /2, enemy.getMoney()),
                ItemGenerator.newItemPriceRangeArmor(enemy.getMoney() /2, enemy.getMoney()),
                ItemGenerator.newItemPriceRangeArmor(enemy.getMoney() /2, enemy.getMoney()) ));

        String myDesc = desc[rand.nextInt(desc.length)];
        enemy.setName(enemy.getRace() + myDesc);
        switch(myDesc)
        {   case " ranger": enemy.addPossibleDrop(Arrays.asList(
                ItemGenerator.newItemPriceRangeAndName(enemy.getMoney() /2, enemy.getMoney(), "dagger")  ));
                enemy.addAttack(enemy.getAttack() /10 +1); enemy.addExp(1);    break;
            case " hunter": enemy.addPossibleDrop(Arrays.asList(
                ItemGenerator.newItemPriceRangeAndName(enemy.getMoney() /2, enemy.getMoney(), "knife")  ));
                enemy.addAttack(enemy.getAttack() /10 +1); enemy.addExp(1); break;
            case " warrior": enemy.addPossibleDrop(Arrays.asList(
                ItemGenerator.newItemPriceRangeWeapon(enemy.getMoney() /2, enemy.getMoney()*2)  ));
                enemy.addAttack(enemy.getAttack() /5 +1); enemy.addExp(2); break;
            case " swordsman":  enemy.addPossibleDrop(Arrays.asList(
                ItemGenerator.newItemPriceRangeAndName(enemy.getMoney() /2, enemy.getMoney(), "sword")  ));
                enemy.addAttack(enemy.getAttack() /10 +1); enemy.addExp(1); break;
            case " spearman":  enemy.addPossibleDrop(Arrays.asList(
                ItemGenerator.newItemPriceRangeAndName(enemy.getMoney() /2, enemy.getMoney()+10, "spear")  ));
                enemy.addAttack(enemy.getAttack() /10 +1); enemy.addExp(1); break;
            case " axeman":  enemy.addPossibleDrop(Arrays.asList(
                ItemGenerator.newItemPriceRangeAndName(enemy.getMoney() /2, enemy.getMoney()+5, "axe")  ));
                enemy.addAttack(enemy.getAttack() /10 +1); enemy.addExp(1); break;
            case " soldier":  enemy.addPossibleDrop(Arrays.asList(
                    ItemGenerator.newItemPriceRangeAndName(enemy.getMoney() /2, enemy.getMoney()+15, "halberd")  ));
                enemy.addAttack(enemy.getAttack() /10 +1); enemy.addExp(1); break;
            default: enemy.addPossibleDrop(Arrays.asList(
                ItemGenerator.newItemPriceRangeWeapon(enemy.getMoney() /8, enemy.getMoney()/2 + 5)  ));
                enemy.setName(desc2[rand.nextInt(desc2.length)]+ " " + enemy.getRace()); break;
        }
        return enemy;
    }

    public static ArrayList<Enemy> plains() {
        ArrayList<Enemy> plainsEnemies = new ArrayList<>();
        plainsEnemies.add(new Enemy("mouse", 4,0,5,2,3));
        plainsEnemies.add(new Enemy("rabbit", 5,0,7,3,10));
        plainsEnemies.add(new Enemy("pheasant", 9,0,10,5,12));
        plainsEnemies.add(new Enemy("goose", 10,0,13,5,12));
        plainsEnemies.add(new Enemy("rat", 10,0,11,6,5));
        plainsEnemies.add(new Enemy("snake", 20,1,19,9,8));
        plainsEnemies.add(new Enemy("wild horse", 40,3,15,11,20));
        plainsEnemies.add(new Enemy("badger", 30,5,27,13,25));
        plainsEnemies.add(new Enemy("gaggle of geese", 50,3,23,15,30));
        plainsEnemies.add(new Enemy("bison", 60,10,20,17,40));
        return plainsEnemies;
    }

    public static Enemy plainsEnemy() {
        Enemy enemy = plains().get(rand.nextInt(plains().size()));
        enemy = descriptor(enemy);
        return enemy;
    }

    public static Enemy plainsEnemyName(String whatsInTheName) {
        Enemy enemy = plainsEnemy();
        int i = 0;
        while(!enemy.getName().contains(whatsInTheName))
        {   enemy = plainsEnemy(); i++;
            if(i==10000) {
                System.out.println("uwaga: prawdopodobnie nieskonczona petla w plainsEnemyName");
                break; }
        }
        return enemy;
    }

    public static Enemy plainsEnemyExpRangeAndName(int begin, int end, String whatsInTheName) {
        Enemy enemy = plainsEnemy();
        int i = 0;
        while(enemy.getExp()<begin || enemy.getExp()>end || !enemy.getName().contains(whatsInTheName))
        {   enemy = plainsEnemy(); i++;
            if(i==10000) {
                System.out.println("uwaga: prawdopodobnie nieskonczona petla w plainsEnemyExpRangeAndName");
                break; }
        }
        return enemy;
    }

    public static Enemy plainsEnemyExpRange(int begin, int end) {
        Enemy enemy = plainsEnemy();
        int i = 0;
        while(enemy.getExp()<begin || enemy.getExp()>end)
        {   enemy = plainsEnemy(); i++;
            if(i==10000) {
                System.out.println("uwaga: prawdopodobnie nieskonczona petla w plainsEnemyExpRange");
                break; }
        }
        return enemy;
    }

    public static ArrayList<Enemy> forestAnimals() {
        ArrayList<Enemy> forestAnimals = new ArrayList<>();
        forestAnimals.add(new Enemy("hare", 10,0,10,5,10));
        forestAnimals.add(new Enemy("deer", 20,2,10,9,20));
        forestAnimals.add(new Enemy("fox", 30,5,35,14,27));
        forestAnimals.add(new Enemy("wolverine", 50,10,30,18,25));
        forestAnimals.add(new Enemy("swarm of angry hornets", 10,20,40,20,0));
        forestAnimals.add(new Enemy("murder of crows", 40,20,40,22,20));
        forestAnimals.add(new Enemy("moose", 80,35,20,23,40));
        forestAnimals.add(new Enemy("wolf", 60,15,55,26,45));
        forestAnimals.add(new Enemy("black bear", 100,20,40,29,50));
        forestAnimals.add(new Enemy("grizzly bear", 150,30,50,32,65));
        forestAnimals.add(new Enemy("dire wolf", 180,25,70,35,70));
        forestAnimals.add(new Enemy("cockatrice", 200,40,90,38,90));
        forestAnimals.add(new Enemy("basilisk", 250,55,100,42,100));
        forestAnimals.add(new Enemy("green wyvern", 500,100,140,50,120));
        return forestAnimals;
    }

    public static ArrayList<Enemy> forestSentients() {
        ArrayList<Enemy> forestSentients = new ArrayList<>();
        forestSentients.add(new Enemy("green goblin", 50,20,15,21,10));
        forestSentients.add(new Enemy("black goblin", 60,25,20,23,10));
        forestSentients.add(new Enemy("kobold", 80,30,30,26,30));
        forestSentients.add(new Enemy("green hobgoblin", 100,40,45,29,40));
        forestSentients.add(new Enemy("black hobgoblin", 120,45,55,31,40));
        forestSentients.add(new Enemy("gnoll", 90,40,85,32,60));
        forestSentients.add(new Enemy("lizardman", 160,60,50,34,50));
        forestSentients.add(new Enemy("green ogre", 200,60,80,37,90));
        forestSentients.add(new Enemy("wood elf", 180,40,120,40,100));
        forestSentients.add(new Enemy("faun", 250,80,110,43,120));
        forestSentients.add(new Enemy("werewolf", 300,100,130,48,150));
        return forestSentients;
    }

    public static Enemy forestEnemy() {
        Enemy enemy = new Enemy();

        if(rand.nextInt(4)==0) {
            enemy = forestSentients().get(rand.nextInt(forestSentients().size()));
            enemy = profession(enemy);
            enemy.setSentient(true);
        }

        else {
            enemy = forestAnimals().get(rand.nextInt(forestAnimals().size()));
            enemy = descriptor(enemy);
        }

        return enemy;
    }

    public static Enemy forestEnemyName(String whatsInTheName) {
        Enemy enemy = forestEnemy();
        int i = 0;
        while(!enemy.getName().contains(whatsInTheName))
        {   enemy = forestEnemy(); i++;
            if(i==10000) {
                System.out.println("uwaga: prawdopodobnie nieskonczona petla w forestEnemyName");
                break; }
        }
        return enemy;
    }

    public static Enemy forestEnemyExpRangeAndName(int begin, int end, String whatsInTheName) {
        Enemy enemy = forestEnemy();
        int i = 0;
        while(enemy.getExp()<begin || enemy.getExp()>end || !enemy.getName().contains(whatsInTheName))
        {   enemy = forestEnemy(); i++;
            if(i==10000) {
                System.out.println("uwaga: prawdopodobnie nieskonczona petla w forestEnemyExpRangeAndName");
                break; }
        }
        return enemy;
    }

    public static Enemy forestEnemyExpRange(int begin, int end) {
        Enemy enemy = forestEnemy();
        int i = 0;
        while(enemy.getExp()<begin || enemy.getExp()>end)
        {   enemy = forestEnemy(); i++;
            if(i==10000) {
                System.out.println("uwaga: prawdopodobnie nieskonczona petla w forestEnemyExpRange");
                break; }
        }
        return enemy;
    }

    public static ArrayList<Enemy> mountainAnimals() {
        ArrayList<Enemy> mountainAnimals = new ArrayList<>();
        mountainAnimals.add(new Enemy("chipmunk", 10,0,7,3,3));
        mountainAnimals.add(new Enemy("mountain goat", 30,8,18,13,20));
        mountainAnimals.add(new Enemy("yak", 80,20,25,19,27));
        mountainAnimals.add(new Enemy("cougar", 50,14,60,27,36));
        mountainAnimals.add(new Enemy("mountain wolf", 70,20,70,31,40));
        mountainAnimals.add(new Enemy("dire bear", 180,40,75,37,65));
        mountainAnimals.add(new Enemy("manticore", 200,35,90,41,80));
        mountainAnimals.add(new Enemy("griffin", 260,45,85,42,85));
        mountainAnimals.add(new Enemy("rock drake", 380,80,120,48,100));
        mountainAnimals.add(new Enemy("maned wyvern", 550,120,150,53,155));
        mountainAnimals.add(new Enemy("gem-eating wyvern", 650,135,155,56,280));
        mountainAnimals.add(new Enemy("frostfang basilisk", 450,100,200,59,160));
        mountainAnimals.add(new Enemy("archgriffin", 600,130,190,62,180));
        mountainAnimals.add(new Enemy("frostscale wyvern", 700,150,185,67,200));
        mountainAnimals.add(new Enemy("royal basilisk", 600,120,285,69,250));
        mountainAnimals.add(new Enemy("royal wyvern", 900,185,230,72,300));
        mountainAnimals.add(new Enemy("brass dragon", 1100,210,270,75,450));
        mountainAnimals.add(new Enemy("copper dragon", 1050,200,275,79,550));
        mountainAnimals.add(new Enemy("silver dragon", 1150,205,295,81,650));
        mountainAnimals.add(new Enemy("gold dragon", 1100,225,320,85,750));
        mountainAnimals.add(new Enemy("platinum dragon", 1300,260,380,89,800));
        mountainAnimals.add(new Enemy("prismatic dragon", 1600,400,650,96,1200));
        mountainAnimals.add(new Enemy("frost dracolich", 2000,500,550,100,1400));
        mountainAnimals.add(new Enemy("kirin", 5000,1000,1000,110,3000));
        return mountainAnimals;
    }

    public static ArrayList<Enemy> mountainSentients() {
        ArrayList<Enemy> mountainSentients = new ArrayList<>();
        mountainSentients.add(new Enemy("mountain kobold", 100,40,45,30,40));
        mountainSentients.add(new Enemy("white gnoll", 140,50,85,38,70));
        mountainSentients.add(new Enemy("snow elf", 200,80,95,44,100));
        mountainSentients.add(new Enemy("mountain dwarf", 220,100,105,48,100));
        mountainSentients.add(new Enemy("tauren", 300,130,145,53,120));
        mountainSentients.add(new Enemy("frostling", 400,150,155,57,150));
        mountainSentients.add(new Enemy("half-dragon", 500,160,170,62,200));
        mountainSentients.add(new Enemy("goliath", 550,165,190,66,230));
        mountainSentients.add(new Enemy("firbolg", 650,180,200,70,280));
        mountainSentients.add(new Enemy("storm giant", 800,200,240,76,320));
        mountainSentients.add(new Enemy("frost titan", 1000,280,300,85,420));
        mountainSentients.add(new Enemy("nephilim", 1200,400,440,92,800));
        return mountainSentients;
    }

    public static Enemy mountainEnemy() {
        Enemy enemy = new Enemy();

        if(rand.nextInt(4)==0) {
            enemy = mountainSentients().get(rand.nextInt(mountainSentients().size()));
            enemy = profession(enemy);
            enemy.setSentient(true);
        }

        else {
            enemy = mountainAnimals().get(rand.nextInt(mountainAnimals().size()));
            enemy = descriptor(enemy);
        }

        return enemy;
    }

    public static Enemy mountainEnemyName(String whatsInTheName) {
        Enemy enemy = mountainEnemy();
        int i = 0;
        while(!enemy.getName().contains(whatsInTheName))
        {   enemy = mountainEnemy(); i++;
            if(i==10000) {
                System.out.println("uwaga: prawdopodobnie nieskonczona petla w forestEnemyName");
                break; }
        }
        return enemy;
    }

    public static Enemy mountainEnemyExpRangeAndName(int begin, int end, String whatsInTheName) {
        Enemy enemy = mountainEnemy();
        int i = 0;
        while(enemy.getExp()<begin || enemy.getExp()>end || !enemy.getName().contains(whatsInTheName))
        {   enemy = mountainEnemy(); i++;
            if(i==10000) {
                System.out.println("uwaga: prawdopodobnie nieskonczona petla w forestEnemyExpRangeAndName");
                break; }
        }
        return enemy;
    }

    public static Enemy mountainEnemyExpRange(int begin, int end) {
        Enemy enemy = mountainEnemy();
        int i = 0;
        while(enemy.getExp()<begin || enemy.getExp()>end)
        {   enemy = mountainEnemy(); i++;
            if(i==10000) {
                System.out.println("uwaga: prawdopodobnie nieskonczona petla w forestEnemyExpRange");
                break; }
        }
        return enemy;
    }

    public static Enemy areaBoss(String where){
        Enemy enemy = new Enemy();
        ArrayList<Item> drop = new ArrayList<Item>();

        if(where.equalsIgnoreCase("plains")){
            enemy = new Enemy("great devourer", 400,200,80,50,0);
            drop.add(new Weapon("<font color='red'>serrated fang</font>", 800, 500));
            enemy.setPossibleDrop(drop);
            enemy.setName("ravenous wyrm");
        }
        if(where.equalsIgnoreCase("forest")){
            enemy = new Enemy("leshy", 4000,2000,300,110,0);
            drop.add(new Torso("<font color='red'>forest protector's robe</font>", 2000, 1000));
            enemy.setPossibleDrop(drop);
            enemy.setName("forest protector");
        }
        if(where.equalsIgnoreCase("mountains")){
            enemy = new Enemy("mountain god", 10000,6000,1000,1000,0);
            drop.add(new Head("<font color='red'>antlered skull</font>", 9000, 0));
            enemy.setPossibleDrop(drop);
            enemy.setName("lord of the mountain");
        }
        enemy.setSentient(true);
        return enemy;
    }

}
