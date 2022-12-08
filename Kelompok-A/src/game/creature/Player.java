package game.creature;

import game.generators.TextGenerator;
import game.item.*;
import game.item.armor.Arms;
import game.item.armor.Head;
import game.item.armor.Legs;
import game.item.armor.Torso;

import java.util.ArrayList;

public class Player extends Creature {
    private String saveName = "";
    private ArrayList<Item> inventory;
    private Weapon weapon;
    private Legs legs;
    private Torso torso;
    private Arms arms;
    private Head head;
    private boolean ended = false;
    private String currentQuest = "";
    private int questCount = 0;
    private int maxQuestCount = 0;
    private String whereQuest = "";
    private String doneQuest = "";
    private Weapon defaultWeapon = new Weapon("trusty stick",0,0);
    private Legs defaultLegs = new Legs("patched linen pants",0,0);
    private Torso defaultTorso = new Torso("simple linen shirt",0,0);
    private Arms defaultArms = new Arms("frayed friendship bracelet",0,0);
    private Head defaultHead = new Head("old straw hat",0,0);
    private int defaultMaxHp = 100;
    private int defaultArmor = 0;
    private int defaultAttack = 2;
    private int defaultExp = 0;
    private int defaultMoney = 0;
    private ArrayList<Item> defaultInventory = new ArrayList<>();
    public int fartmasterCount;
    private int dayCount;
    private int lastShopRestock;
    private int killCount;
    private int dailyKillCount;
    private boolean killedPlainsBoss;
    private boolean killedForestBoss;
    private boolean killedMountainsBoss;
    private boolean triggeredMountainBoss;
    private String trait1;
    private String trait2;
    private String age;
    private String gender;
    private String hobby1;
    private String job;
    private String hobby2;


    public Player(){
        this.maxhp = defaultMaxHp;
        this.hp = defaultMaxHp;
        this.armor = defaultArmor;
        this.attack = defaultAttack;
        this.exp = defaultExp;
        this.money = defaultMoney;
        this.setInventory(defaultInventory);
        this.setWeapon(defaultWeapon);
        this.setLegs(defaultLegs);
        this.setTorso(defaultTorso);
        this.setArms(defaultArms);
        this.setHead(defaultHead);
        this.dayCount = 1;
        this.lastShopRestock = 1;
        this.dayCount = 0;
        this.lastShopRestock = 0;
        this.killedPlainsBoss = false;
        this.killedForestBoss = false;
        this.killedMountainsBoss = false;
        this.triggeredMountainBoss = false;
        this.trait1 = TextGenerator.trait();
        this.trait2 = TextGenerator.traitTwo();
        this.age = TextGenerator.age();
        this.gender = TextGenerator.gender();
        this.hobby1 = TextGenerator.hobby();
        this.hobby2 = TextGenerator.hobbyTwo();
        this.job = TextGenerator.job();
    }

    public Player(int maxhp, int armor, int attack, int exp, int money) {
        super(maxhp, armor, attack, exp, money);
        this.setInventory(defaultInventory);
        this.setWeapon(defaultWeapon);
        this.setLegs(defaultLegs);
        this.setTorso(defaultTorso);
        this.setArms(defaultArms);
        this.setHead(defaultHead);
        this.dayCount = 1;
        this.lastShopRestock = 1;
        this.dayCount = 0;
        this.lastShopRestock = 0;
        this.killedPlainsBoss = false;
        this.killedForestBoss = false;
        this.killedMountainsBoss = false;
        this.triggeredMountainBoss = false;
        this.trait1 = TextGenerator.trait();
        this.trait2 = TextGenerator.traitTwo();
        this.age = TextGenerator.age();
        this.gender = TextGenerator.gender();
        this.hobby1 = TextGenerator.hobby();
        this.hobby2 = TextGenerator.hobbyTwo();
        this.job = TextGenerator.job();
    }

    public void take(Item item){
        if(getInventory().size() < 12){
            getInventory().add(item);
        }
    }

    public void remove(int i){
        if (getInventory().size()-1 <= i && i>=0) {
            getInventory().remove(i);
        }

    }

    public void useItem(Item item){
        if (item instanceof Weapon){
            this.setAttack(this.getAttack() - this.getWeapon().getDamage() + ((Weapon) item).getDamage());
            this.setWeapon((Weapon) item);
        }
        if (item instanceof Legs){
            this.setArmor(this.getArmor() - this.getLegs().getDefence() + ((Legs) item).getDefence());
            this.setLegs((Legs) item);
        }
        if (item instanceof Arms){
            this.setArmor(this.getArmor() - this.getArms().getDefence() + ((Arms) item).getDefence());
            this.setArms((Arms) item);
        }
        if (item instanceof Torso){
            this.setArmor(this.getArmor() - this.getTorso().getDefence() + ((Torso) item).getDefence());
            this.setTorso((Torso) item);
        }
        if (item instanceof Head){
            this.setArmor(this.getArmor() - this.getHead().getDefence() + ((Head) item).getDefence());
            this.setHead((Head) item);
        }
        if (item instanceof Healing){
            setHp(Math.min(this.getHp()+((Healing) item).getRestore(), this.getMaxhp()));
        }
    }

    public int howManyItemsInInv(){
        return this.getInventory().size();
    }

    public Item getItemFromInv(int i) {
        if (i<howManyItemsInInv()) return this.getInventory().get(i);
        return null;
    }

    public void removeItemFromInv(int i) {
        if (i<howManyItemsInInv()) this.getInventory().remove(i);
    }

    public void addItemToInv(Item item) {
        if (howManyItemsInInv()<12) this.getInventory().add(item);
    }

    public void replaceItemInInvWith(int i, Item item) {
        if (i<howManyItemsInInv()) {
            this.getInventory().set(i, item);
        }
    }

    public void yeetItemFromInv(int i) {
        if (i<howManyItemsInInv()) this.getInventory().remove(i);
    }

    public void setEverythingToDefault(){
        this.ended = false;
        this.setWeapon(defaultWeapon);
        this.setLegs(defaultLegs);
        this.setTorso(defaultTorso);
        this.setArms(defaultArms);
        this.setHead(defaultHead);
        this.maxhp = defaultMaxHp;
        this.hp = defaultMaxHp;
        this.armor = defaultArmor;
        this.attack = defaultAttack;
        this.exp = defaultExp;
        this.money = defaultMoney;
        this.getInventory().clear();
        this.setInventory(defaultInventory);
        this.dayCount = 1;
        this.lastShopRestock = 1;
        this.killCount = 0;
        this.dailyKillCount = 0;
        this.killedPlainsBoss = false;
        this.killedForestBoss = false;
        this.killedMountainsBoss = false;
        this.triggeredMountainBoss = false;
        this.trait1 = TextGenerator.trait();
        this.trait2 = TextGenerator.traitTwo();
        this.age = TextGenerator.age();
        this.gender = TextGenerator.gender();
        this.hobby1 = TextGenerator.hobby();
        this.hobby2 = TextGenerator.hobbyTwo();
        this.job = TextGenerator.job();
    }

    public float expWithoutLevel(){
        return (this.exp - (int) this.exp);
    }

    public void updateMaxHp() {this.maxhp = defaultMaxHp + 10* (int) getExp();}

    public int getDayCount() { return dayCount; }
    public void addOneDay() { this.dayCount += 1; }

    public int getLastShopRestock() { return lastShopRestock; }
    public void setLastShopRestock(int lastShopRestock) { this.lastShopRestock = lastShopRestock; }

    public int getKillCount() { return killCount; }
    public void addKillCount() { this.killCount += 1; }

    public int getDailyKillCount() { return dailyKillCount; }
    public void addDailyKillCount() { this.dailyKillCount += 1; }
    public void resetDailyKillCount() { this.dailyKillCount = 0; }

    public String getCurrentQuest() {
        return currentQuest;
    }
    public void setCurrentQuest(String currentQuest) {
        this.currentQuest = currentQuest;
    }

    public int getQuestCount() {
        return questCount;
    }
    public void setQuestCount(int questCount) {
        this.questCount = questCount;
    }
    public void addQuestCount(){ this.questCount += 1; }
    public void resetQuestCount(){ this.questCount = 0; }

    public void setDoneQuest(String doneQuest) {
        this.doneQuest = doneQuest;
    }
    public String getDoneQuest() {
        return doneQuest;
    }

    public void setMaxQuestCount(int maxQuestCount) {
        this.maxQuestCount = maxQuestCount;
    }
    public int getMaxQuestCount() {
        return maxQuestCount;
    }

    public void setWhereQuest(String whereQuest) {
        this.whereQuest = whereQuest;
    }
    public String getWhereQuest() {
        return whereQuest;
    }

    public Weapon getWeapon() {
        return weapon;
    }
    public Legs getLegs() {
        return legs;
    }
    public Torso getTorso() {
        return torso;
    }
    public Arms getArms() {
        return arms;
    }
    public Head getHead() {
        return head;
    }

    public void setWeapon(Weapon weapon) {
        this.weapon = weapon;
    }
    public void setLegs(Legs legs) {
        this.legs = legs;
    }
    public void setTorso(Torso torso) {
        this.torso = torso;
    }
    public void setArms(Arms arms) {
        this.arms = arms;
    }
    public void setHead(Head head) {
        this.head = head;
    }

    public boolean killedPlainsBoss() { return killedPlainsBoss; }
    public void setKilledPlainsBoss(boolean killedPlainsBoss) { this.killedPlainsBoss = killedPlainsBoss; }

    public boolean killedForestBoss() { return killedForestBoss; }
    public void setKilledForestBoss(boolean killedForestBoss) { this.killedForestBoss = killedForestBoss; }

    public boolean killedMountainsBoss() { return killedMountainsBoss; }
    public void setKilledMountainsBoss(boolean killedMountainsBoss) { this.killedMountainsBoss = killedMountainsBoss; }

    public boolean triggeredMountainBoss() { return triggeredMountainBoss; }
    public void setTriggeredMountainBoss(boolean triggeredMountainBoss) { this.triggeredMountainBoss = triggeredMountainBoss; }

    public String getTrait1() { return trait1; }
    public void setTrait1(String trait1) { this.trait1 = trait1; }

    public String getTrait2() { return trait2; }
    public void setTrait2(String trait2) { this.trait2 = trait2; }

    public String getAge() { return age; }
    public void setAge(String age) { this.age = age; }

    public String getGender() { return gender; }
    public void setGender(String gender) { this.gender = gender; }

    public String getHobby1() { return hobby1; }
    public void setHobby1(String hobby1) { this.hobby1 = hobby1; }

    public String getJob() { return job; }
    public void setJob(String job) { this.job = job; }

    public String getHobby2() { return hobby2; }
    public void setHobby2(String hobby2) { this.hobby2 = hobby2; }

    public String getSaveName() {
        return saveName;
    }
    public void setSaveName(String saveName) {
        this.saveName = saveName;
    }

    public ArrayList<Item> getInventory() {
        return inventory;
    }
    public void setInventory(ArrayList<Item> inventory) {
        this.inventory = inventory;
    }

    public boolean getEnded() {
        return ended;
    }
    public void setEnded(boolean ended) {
        this.ended = ended;
    }
}
