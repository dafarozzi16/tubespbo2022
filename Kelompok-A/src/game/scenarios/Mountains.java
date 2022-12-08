package game.scenarios;

import game.combat.Combat;
import game.creature.Enemy;
import game.generators.EnemyGenerator;
import game.creature.Player;
import game.item.*;
import game.state.GameWorld;

public class Mountains {

    GameWorld gameworld;
    String where = "MOUNTAINS";

    public Mountains(GameWorld gameworld) {
        this.gameworld = gameworld;
    }

    Player player = GameWorld.getPlayer();
    Enemy enemy = GameWorld.getCurrentEnemy();
    Item drop;

    public void go() {

        enemy = GameWorld.getCurrentEnemy();

        if (!gameworld.getFromInventory()){
            enemy = EnemyGenerator.mountainEnemy();
            GameWorld.setCurrentEnemy(enemy);
        }

        FightText.lookingAround("MOUNTAINS", enemy, gameworld);

        gameworld.setNextPosition1("MOUNTAINS_FIGHT_CHOOSE");
        gameworld.setNextPosition2("MOUNTAINS");
        gameworld.setNextPosition3("FIGHT_CHOOSE");
        gameworld.setNextPosition4("");

        if (!GameWorld.getPlayer().getCurrentQuest().equals("") & !GameWorld.getPlayer().getCurrentQuest().equals(" ")
                & GameWorld.getPlayer().getWhereQuest().equals("MOUNTAINS")) {
            gameworld.setNextPosition3("MOUNTAINS_HUNT"); // hunt
            gameworld.setNextPosition4("FIGHT_CHOOSE");
        }

        if (player.getDailyKillCount()>=16 & player.getExp()>=100 & player.killedForestBoss()) gameworld.getBoss().mountainsBoss1(); //BOSS
        if (player.triggeredMountainBoss()) gameworld.getBoss().mountainsBoss1();
        if (player.killedMountainsBoss()) gameworld.getBoss().mountainsBossKilled(); //AFTER BOSS
    }

    public void hunt() {

        enemy = GameWorld.getCurrentEnemy();

        if (!gameworld.getFromInventory()){
            enemy = EnemyGenerator.mountainEnemyName(GameWorld.getPlayer().getCurrentQuest());
            GameWorld.setCurrentEnemy(enemy);
        }

        FightText.lookingAround("MOUNTAINS", enemy, gameworld);

        gameworld.setNextPosition1("MOUNTAINS_FIGHT_CHOOSE");
        gameworld.setNextPosition2("MOUNTAINS");
        gameworld.setNextPosition3("FIGHT_CHOOSE");
        gameworld.setNextPosition4("");

        if (!GameWorld.getPlayer().getCurrentQuest().equals("") & !GameWorld.getPlayer().getCurrentQuest().equals(" ")
                & GameWorld.getPlayer().getWhereQuest().equals("MOUNTAINS")) {
            gameworld.setNextPosition3("MOUNTAINS_HUNT"); // hunt
            gameworld.setNextPosition4("FIGHT_CHOOSE");
        }

        if (player.getDailyKillCount()>=16 & player.getExp()>=100 & player.killedForestBoss()) gameworld.getBoss().mountainsBoss1(); //BOSS
        if (player.killedMountainsBoss()) gameworld.getBoss().mountainsBossKilled(); //AFTER BOSS
    }

    public void fightChoose(){

        enemy = GameWorld.getCurrentEnemy();
        if (enemy.isSentient()) this.drop = enemy.getRandomDrop();

        FightText.whatNow(enemy, gameworld);

        gameworld.setNextPosition1("MOUNTAINS_FIGHT");
        gameworld.setNextPosition2("MOUNTAINS"); //FIGHT CHOOSE ? szukanie nowego przeciwnika
        gameworld.setNextPosition3("");
        gameworld.setNextPosition4("");
    }

    public void fight(){

        int attack1;
        int attack2;

        if(!gameworld.getFromInventory()){
            enemy = GameWorld.getCurrentEnemy();
            attack1 = Combat.attack(player, enemy);
            attack2 = Combat.attack(enemy, player);

            gameworld.setPrevDmgDealt(attack1);
            gameworld.setPrevDmgTaken(attack2);
        }
        else {
            attack1 = gameworld.getPrevDmgDealt();
            attack2 = gameworld.getPrevDmgTaken();
        }

        if (player.getHp() < 1) {
            FightText.youDied(attack2, enemy, gameworld);

            gameworld.setNextPosition1("BEGIN");
            gameworld.setNextPosition2("");
            gameworld.setNextPosition3("");
            gameworld.setNextPosition4("");
        }
        else if (enemy.getHp() < 1) {    // DEAD ENEMY
            if (!enemy.isSentient())
            FightText.animalEnemyDead(enemy, attack1, attack2, gameworld);

            if (enemy.isSentient()) {
                Item item = this.drop;
                this.drop = item;
                FightText.sentientEnemyDead(enemy, attack1, attack2, item, gameworld);
            }

            if (!enemy.isSentient()){  //NOT SENTIENT ENEMY

                gameworld.setNextPosition1("MOUNTAINS");
                gameworld.setNextPosition2("FIGHT_CHOOSE");
                gameworld.setNextPosition3("");
                gameworld.setNextPosition4("");
            }
            else{  //SENTIENT ENEMY

                gameworld.setNextPosition1("MOUNTAINS");
                gameworld.setNextPosition2("MOUNTAINS_DROP");
                gameworld.setNextPosition3("FIGHT_CHOOSE");
                gameworld.setNextPosition4("");

            }
        }                                   //END DEAD ENEMY
        else {
            FightText.enemyStillNotDead(attack1, attack2, enemy, gameworld);

            gameworld.setNextPosition1("MOUNTAINS_FIGHT");
            gameworld.setNextPosition2("FIGHT_CHOOSE");
            gameworld.setNextPosition3("");
            gameworld.setNextPosition4("");
        }
        gameworld.getVm().updateCurrentHPLabel(player.getHp()); //UPDATE HP
        player.updateMaxHp();
    }

    public void inspectDroppedItem() {
        Item item = this.drop;
        FightText.inspectDropText(item, gameworld);

        gameworld.setNextPosition1("MOUNTAINS_TAKE_DROP");
        gameworld.setNextPosition2("MOUNTAINS");
        gameworld.setNextPosition3("FIGHT_CHOOSE");
        gameworld.setNextPosition4("");

        gameworld.getVm().hideUselessChoiceButtons();
    }
    public void takeDroppedItem(){

        Item item = this.drop;
        if (player.howManyItemsInInv()==12) {
            FightText.cantPickUpDrop(item, gameworld);

            gameworld.setNextPosition1("MOUNTAINS_DROP");
        }
        else{
            FightText.pickUpDrop(item, gameworld);
            player.take(item);

            gameworld.setNextPosition1("MOUNTAINS");
        }
        gameworld.setNextPosition2("");
        gameworld.setNextPosition3("");
        gameworld.setNextPosition4("");

    }
}
