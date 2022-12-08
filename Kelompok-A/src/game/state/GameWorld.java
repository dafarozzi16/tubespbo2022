package game.state;

import game.creature.*;
import game.engine.UI;
import game.engine.VisibilityManager;
import game.scenarios.*;

import java.io.IOException;


public class GameWorld {

    private static Player player = new Player();
    private static Enemy currentEnemy = new Enemy();
    private UI ui;
    private Game game;
    private VisibilityManager vm;
    private Boolean fromInventory = false;
    private int prevDmgTaken = 0;
    private int prevDmgDealt = 0;
    private String trueLastState;

    public GameWorld(Game game, UI ui, VisibilityManager vm) {
        this.setGame(game);
        this.setUi(ui);
        this.setVm(vm);
    }

    private String nextPosition1;
    private String nextPosition2;
    private String nextPosition3;
    private String nextPosition4;

    private Start start = new Start(this);
    private Town town = new Town(this);
    private Tavern tavern = new Tavern(this);
    private Shop shop = new Shop(this);
    private FightText fightText = new FightText(this);
    private Plains plains = new Plains(this);
    private Forest forest = new Forest(this);
    private Mountains mountains = new Mountains(this);
    private Inventory inventory = new Inventory(this);
    private Boss boss = new Boss(this);
    private GhostTown ghostTown = new GhostTown(this);

    public static Player getPlayer() {
        return player;
    }

    public static void setPlayer(Player player) {
        GameWorld.player = player;
    }

    public static Enemy getCurrentEnemy() {
        return currentEnemy;
    }

    public static void setCurrentEnemy(Enemy currentEnemy) {
        GameWorld.currentEnemy = currentEnemy;
    }


    public void selectPosition(String nextPosition) throws IOException {
        if (!nextPosition.contains("INVENTORY") && !nextPosition.equals("CHARACTER_SHEET")) {
            getInventory().setLastPosition(nextPosition);
        }
        switch(nextPosition){
            case "BEGIN": getStart().begin(); break;
            case "DESCRIPTION": getStart().description(); break;
            case "CONTEMPLATE": getTown().contemplate(); break;
            case "TOWN": getTown().go(); break;
            case "TAVERN": getTavern().go(); break;
            case "DRINK": getTavern().drink(); break;
            case "REST": getTavern().rest(); break;
            case "SHOP": getShop().go(); break;
            case "SELL": getShop().sell(); break;
            case "BUY": getShop().buy(); break;
            case "FIGHT_CHOOSE": getFightText().go(); break;
            case "PLAINS": getPlains().go(); break;
            case "PLAINS_HUNT": getPlains().hunt(); break;
            case "PLAINS_FIGHT_CHOOSE": getPlains().fightChoose(); break;
            case "PLAINS_FIGHT": getPlains().fight(); break;
            case "PLAINS_DROP": getPlains().inspectDroppedItem(); break;
            case "PLAINS_TAKE_DROP": getPlains().takeDroppedItem(); break;
            case "FOREST": getForest().go(); break;
            case "FOREST_HUNT": getForest().hunt(); break;
            case "FOREST_FIGHT_CHOOSE": getForest().fightChoose(); break;
            case "FOREST_FIGHT": getForest().fight(); break;
            case "FOREST_DROP": getForest().inspectDroppedItem(); break;
            case "FOREST_TAKE_DROP": getForest().takeDroppedItem(); break;
            case "MOUNTAINS": getMountains().go(); break;
            case "MOUNTAINS_HUNT": getMountains().hunt(); break;
            case "MOUNTAINS_FIGHT_CHOOSE": getMountains().fightChoose(); break;
            case "MOUNTAINS_FIGHT": getMountains().fight(); break;
            case "MOUNTAINS_DROP": getMountains().inspectDroppedItem(); break;
            case "MOUNTAINS_TAKE_DROP": getMountains().takeDroppedItem(); break;
            case "CHARACTER_SHEET": getInventory().characterSheet(); break;
            case "INVENTORY": getInventory().manageInventory(); break;
            case "INVENTORY_LOOK_NEXT": getInventory().lookNext(); break;
            case "INVENTORY_LOOK_PREV": getInventory().lookPrev(); break;
            case "INVENTORY_YEET": getInventory().yeet(); break;
            case "INVENTORY_AFTER_EQUIP": getInventory().lookAfterSwapping(); break;
            case "INVENTORY_USE": getInventory().use(); break;
            case "PLAINS_BOSS_2": getBoss().plainsBoss2(); break;
            case "PLAINS_BOSS_3": getBoss().plainsBoss3(); break;
            case "PLAINS_BOSS_FIGHT": getBoss().plainsBossFight(); break;
            case "FOREST_BOSS_2": getBoss().forestBoss2(); break;
            case "FOREST_BOSS_3": getBoss().forestBoss3(); break;
            case "FOREST_BOSS_FIGHT": getBoss().forestBossFight(); break;
            case "MOUNTAINS_BOSS_2": getBoss().mountainsBoss2(); break;
            case "MOUNTAINS_BOSS_3": getBoss().mountainsBoss3(); break;
            case "MOUNTAINS_BOSS_4": getBoss().mountainsBoss4(); break;
            case "MOUNTAINS_BOSS_FIGHT": getBoss().mountainsBossFight(); break;
            case "DEAD": break;
        }
        if (player.killedMountainsBoss()) {
            switch(nextPosition){
                case "CONTEMPLATE": getGhostTown().contemplate(); break;
                case "TOWN": getGhostTown().town(); break;
                case "TAVERN": getGhostTown().tavern(); break;
                case "SHOP": getGhostTown().shop(); break;
                case "CHARACTER_SHEET": getGhostTown().characterSheet(); break;
                case "FIGHT_CHOOSE": getGhostTown().fightChoose(); break;
            }
        }
        if (player.killedMountainsBoss()) vm.setEverythingGray();
        if (nextPosition.equals("BEGIN")) vm.setEverythingWhite();
        this.setTrueLastState(nextPosition);
        getVm().hideUselessChoiceButtons();
    }

    public Boolean getFromInventory() {
        return fromInventory;
    }

    public void setFromInventory(Boolean fromInventory) {
        this.fromInventory = fromInventory;
    }

    public int getPrevDmgTaken() {
        return prevDmgTaken;
    }

    public void setPrevDmgTaken(int prevDmgTaken) {
        this.prevDmgTaken = prevDmgTaken;
    }

    public int getPrevDmgDealt() {
        return prevDmgDealt;
    }

    public void setPrevDmgDealt(int prevDmgDealt) {
        this.prevDmgDealt = prevDmgDealt;
    }

    public String getTrueLastState() {
        return trueLastState;
    }

    public void setTrueLastState(String trueLastState) {
        this.trueLastState = trueLastState;
    }

    public String getNextPosition1() {
        return nextPosition1;
    }

    public void setNextPosition1(String nextPosition1) {
        this.nextPosition1 = nextPosition1;
    }

    public String getNextPosition2() {
        return nextPosition2;
    }

    public void setNextPosition2(String nextPosition2) {
        this.nextPosition2 = nextPosition2;
    }

    public String getNextPosition3() {
        return nextPosition3;
    }

    public void setNextPosition3(String nextPosition3) {
        this.nextPosition3 = nextPosition3;
    }

    public String getNextPosition4() {
        return nextPosition4;
    }

    public void setNextPosition4(String nextPosition4) {
        this.nextPosition4 = nextPosition4;
    }

    public UI getUi() {
        return ui;
    }

    public void setUi(UI ui) {
        this.ui = ui;
    }

    public Game getGame() {
        return game;
    }

    public void setGame(Game game) {
        this.game = game;
    }

    public VisibilityManager getVm() {
        return vm;
    }

    public void setVm(VisibilityManager vm) {
        this.vm = vm;
    }

    public Start getStart() {
        return start;
    }

    public Town getTown() {
        return town;
    }

    public Tavern getTavern() {
        return tavern;
    }

    public Shop getShop() {
        return shop;
    }

    public FightText getFightText() {
        return fightText;
    }

    public Plains getPlains() {
        return plains;
    }

    public Forest getForest() {
        return forest;
    }

    public Mountains getMountains() {
        return mountains;
    }

    public Inventory getInventory() {
        return inventory;
    }

    public Boss getBoss() { return boss; }


    public GhostTown getGhostTown() {
        return ghostTown;
    }
}
