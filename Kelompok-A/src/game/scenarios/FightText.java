package game.scenarios;

import game.creature.Enemy;
import game.creature.Player;
import game.generators.TextGenerator;
import game.item.*;
import game.item.armor.*;
import game.state.GameWorld;

public class FightText {

    GameWorld gameworld;

    public FightText(GameWorld gameworld) {
        this.gameworld = gameworld;
    }

    public void go() { // generator opisów DO ZAIMPLEMENTOWANIA

        gameworld.getUi().mainTextArea.setText("You are NEAR THE TOWN GATES. It is "+ TextGenerator.weather() +". You see THREE PATHS.<br>" +
                "You decide to:");

        gameworld.getUi().choice1.setText("Go EAST, towards the PLAINS");
        gameworld.getUi().choice2.setText("Go NORTH, towards the FOREST");
        gameworld.getUi().choice3.setText("Go WEST, towards the MOUNTAINS");
        gameworld.getUi().choice4.setText("Turn around and GO BACK to the TOWN");

        gameworld.setNextPosition1("PLAINS");
        gameworld.setNextPosition2("FOREST");
        gameworld.setNextPosition3("MOUNTAINS");
        gameworld.setNextPosition4("TOWN");
    }

    public static void lookingAround(String where, Enemy enemy, GameWorld gameworld) {
        gameworld.getUi().mainTextArea.setText("You are now in the <font color='red'>"+where+"</font>. It is "+ TextGenerator.weather() +". You see a " +
                enemy.getName().toUpperCase() + "." +
                "<br>You decide to:");

        gameworld.getVm().showChoices();

        gameworld.getUi().choice1.setText("GET CLOSER to this creature");
        gameworld.getUi().choice2.setText("SEARCH for other enemies");
        gameworld.getUi().choice3.setText("GET BACK on the road");
        gameworld.getUi().choice4.setText("");

        if (!GameWorld.getPlayer().getCurrentQuest().equals("") & !GameWorld.getPlayer().getCurrentQuest().equals(" ")
                & GameWorld.getPlayer().getWhereQuest().equals(where))  {
            gameworld.getUi().choice3.setText("HUNT for " + GameWorld.getPlayer().getCurrentQuest());
            gameworld.getUi().choice4.setText("GET BACK on the road");
        }
    }

    public static void whatNow(Enemy enemy, GameWorld gameworld){
        gameworld.getUi().mainTextArea.setText("The "+enemy.getRace().toUpperCase() + " looks nervous.<br>" +
                "What do you do now?");

        gameworld.getUi().choice1.setText("ATTACK");
        gameworld.getUi().choice2.setText("LEAVE it be");
        gameworld.getUi().choice3.setText("");
        gameworld.getUi().choice4.setText("");
    }

    public static void inspectDropText(Item item, GameWorld gameworld){
        gameworld.getVm().showChoices();
        Player player = GameWorld.getPlayer();

        String tmpText;
        tmpText = "You inspect the " + item.getName().toUpperCase() + ".";
        if (item instanceof Weapon) {
            gameworld.getUi().mainTextArea.setText(tmpText +
                    "<br><br>Attack: +" + ((Weapon) item).getDamage() +
                    "<br>Worn weapon's attack: +" + player.getWeapon().getDamage() +
                    "<br>Worth: " + item.getPrice() + " GOLD COINS"
            );
        }
        if (item instanceof Armor){
            Armor tmp = new Armor();
            if (item instanceof Arms) tmp = player.getArms();
            if (item instanceof Torso) tmp = player.getTorso();
            if (item instanceof Legs) tmp = player.getLegs();
            if (item instanceof Head) tmp = player.getHead();

            gameworld.getUi().mainTextArea.setText(tmpText +
                    "<br><br>Defence: +" + ((Armor) item).getDefence() +
                    "<br>Worn armor's defence: +" + tmp.getDefence() +
                    "<br>Worth: " + item.getPrice() + " GOLD COINS"
            );
        }
        if (item instanceof Healing) {
            gameworld.getUi().mainTextArea.setText(tmpText +
                    "<br><br>Restoration: " + ((Healing) item).getRestore() +
                    "<br>Current missing HP: " + (player.getMaxhp()-player.getHp()) +
                    "<br>Worth: " + item.getPrice() + " GOLD COINS"
            );
        }

        gameworld.getUi().choice1.setText("TAKE it");
        gameworld.getUi().choice2.setText("FORGET it and go look for MORE ENEMIES");
        gameworld.getUi().choice3.setText("Get BACK on the ROAD");
        gameworld.getUi().choice4.setText("");
    }

    public static void cantPickUpDrop(Item item, GameWorld gameworld){
        gameworld.getUi().mainTextArea.setText("You're carrying TOO MANY ITEMS and can't fit the " +
                item.getName().toUpperCase() + " in your bag. Maybe if you THROW something OUT...?");

        gameworld.getVm().showChoicesWithoutPlayerPanel();

        gameworld.getUi().choice1.setText(">");
        gameworld.getUi().choice2.setText("");
        gameworld.getUi().choice3.setText("");
        gameworld.getUi().choice4.setText("");
    }

    public static void pickUpDrop(Item item, GameWorld gameworld){
        gameworld.getUi().mainTextArea.setText("You manage to fit the " +
                item.getName().toUpperCase() + " in your bag. Nice!");

        gameworld.getVm().showChoicesWithoutPlayerPanel();

        gameworld.getUi().choice1.setText(">");
        gameworld.getUi().choice2.setText("");
        gameworld.getUi().choice3.setText("");
        gameworld.getUi().choice4.setText("");
    }

    public static void youDied(int attack2, Enemy enemy, GameWorld gameworld){
        gameworld.getUi().mainTextArea.setText("The "+ enemy.getName().toUpperCase() + " hurt you for "
                + attack2 + " DMG.<br><br>" +
                "You DIED.<br><br>" +
                "GAME OVER");

        gameworld.getUi().choice1.setText("Start a NEW GAME");
        gameworld.getUi().choice2.setText("");
        gameworld.getUi().choice3.setText("");
        gameworld.getUi().choice4.setText("");
    }

    public static void enemyStillNotDead(int attack1, int attack2, Enemy enemy, GameWorld gameworld){
        gameworld.getUi().mainTextArea.setText("You dealt " + attack1 + " DMG.<br>" +
                "The "+ enemy.getName().toUpperCase() + " hurt you for " + attack2 + " DMG.<br>" +
                "This " + enemy.getRace().toUpperCase() + " has " + enemy.getHp() + " HP now.");

        gameworld.getUi().choice1.setText("ATTACK");
        gameworld.getUi().choice2.setText("RUN for your life");
        gameworld.getUi().choice3.setText("");
        gameworld.getUi().choice4.setText("");
    }

    public static void animalEnemyDead(Enemy enemy, int attack1, int attack2, GameWorld gameworld){
        String lvlUp = "";
        String doneQuest = "";
        Player player = GameWorld.getPlayer();

        float receivedExp = enemy.getExp()/20;
        if (enemy.getRace().equals(player.getCurrentQuest()) & !gameworld.getFromInventory()){
            player.addQuestCount();
        }
        if (player.getQuestCount() >= player.getMaxQuestCount() & !gameworld.getFromInventory()
                & player.getCurrentQuest().equals(enemy.getRace())){
            doneQuest = "You have fulfilled your desire. <br> ";
            player.setDoneQuest(player.getCurrentQuest());
            player.setCurrentQuest("");
            player.addExp(enemy.getExp()*player.getMaxQuestCount()/60);
            receivedExp += (enemy.getExp()*player.getMaxQuestCount()/60);
            player.setQuestCount(0);
            player.setMaxQuestCount(0);
        }
        if (player.getQuestCount() >= player.getMaxQuestCount() & enemy.getRace().equals(player.getDoneQuest())){
            doneQuest = "You have fulfilled your desire. <br>";
        }
        if (receivedExp + player.expWithoutLevel()>=1) {
            lvlUp = "Your THREAT RATING just went up!";
        }

        gameworld.getUi().mainTextArea.setText("You dealt " + attack1 + " DMG.<br>" +
                "The " + enemy.getRace().toUpperCase() + " is DEAD.<br>" +
                "You WON the fight!<br><br>" +
                "You think you can sell parts from the DEAD " + enemy.getRace().toUpperCase() +
                " for about " + enemy.getMoney() + " GOLD COINS.<br><br>" +
                doneQuest + lvlUp);

        gameworld.getUi().choice1.setText("LOOK for MORE");
        gameworld.getUi().choice2.setText("Get BACK on the ROAD");
        gameworld.getUi().choice3.setText("");
        gameworld.getUi().choice4.setText("");


        if (!gameworld.getFromInventory()){
            //no double rewards + dead enemy doesnt deal dmg
            player.addHp(attack2);
            player.addMoney(enemy.getMoney());
            player.addExp(receivedExp);
            player.addDailyKillCount();
            player.addKillCount();
        }

    }

    public static void sentientEnemyDead(Enemy enemy, int attack1, int attack2, Item item, GameWorld gameworld){
        String lvlUp = "";
        String doneQuest = "";
        Player player = GameWorld.getPlayer();

        float receivedExp = enemy.getExp()/20;
        if (enemy.getRace().equals(player.getCurrentQuest()) & !gameworld.getFromInventory()){
            player.addQuestCount();
        }
        if (player.getQuestCount() >= player.getMaxQuestCount() & !gameworld.getFromInventory()
                & player.getCurrentQuest().equals(enemy.getRace())){
            doneQuest = "You have fulfilled your desire. <br>";
            player.setDoneQuest(player.getCurrentQuest());
            player.setCurrentQuest("");
            player.addExp(enemy.getExp()*player.getMaxQuestCount()/60);
            receivedExp += (enemy.getExp()*player.getMaxQuestCount()/60);
            player.setQuestCount(0);
            player.setMaxQuestCount(0);
        }
        if (player.getQuestCount() >= player.getMaxQuestCount() & enemy.getRace().equals(player.getDoneQuest())){
            doneQuest = "You have fulfilled your desire. <br>";
        }
        if (receivedExp + player.expWithoutLevel()>=1) {
            lvlUp = "Your THREAT RATING just went up!";
        }

        gameworld.getUi().mainTextArea.setText("You dealt " + attack1 + " DMG.<br>" +
                "The " + enemy.getRace().toUpperCase() + " is DEAD.<br>" +
                "You WON the fight!<br><br>" +
                "You eye the DEAD " + enemy.getRace().toUpperCase() + "'S " +
                item.getName().toUpperCase() + ".<br><br>" +
                doneQuest + lvlUp );

        gameworld.getUi().choice1.setText("LOOK for MORE");
        gameworld.getUi().choice2.setText("INSPECT the ITEM");
        gameworld.getUi().choice3.setText("Get BACK on the ROAD");
        gameworld.getUi().choice4.setText("");

        if (!gameworld.getFromInventory()){
            //no double rewards + dead enemy doesnt deal dmg
            player.addHp(attack2);
            player.addExp(receivedExp);
            player.addDailyKillCount();
            player.addKillCount();
            if (enemy.getRace().contains("great devourer")) player.setKilledPlainsBoss(true);
            if (enemy.getRace().contains("leshy")) player.setKilledForestBoss(true);
            if (enemy.getRace().contains("mountain god")) player.setKilledMountainsBoss(true);
        }

    }

}
