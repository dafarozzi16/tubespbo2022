package game.scenarios;

import game.creature.Player;
import game.state.GameWorld;

public class GhostTown {

    GameWorld gameworld;
    public GhostTown(GameWorld gameworld) {
        this.gameworld = gameworld;
    }

    public void town() {
        gameworld.getVm().showChoices();

        gameworld.getUi().mainTextArea.setText("You are currently in <font color='red'>TOWN</font>. " +
                "<br><br><font color='red'>It's silent.</font>");

        gameworld.getUi().choice1.setText("Find the TAVERN");
        gameworld.getUi().choice2.setText("Go to the SHOP");
        gameworld.getUi().choice3.setText("CONTEMPLATE your life choices");
        gameworld.getUi().choice4.setText("Get OUT OF here");

        gameworld.setNextPosition1("TAVERN");
        gameworld.setNextPosition2("SHOP");
        gameworld.setNextPosition3("CONTEMPLATE");
        gameworld.setNextPosition4("FIGHT_CHOOSE");

    }

    public void fightChoose() {
        gameworld.getUi().mainTextArea.setText("You are NEAR THE TOWN GATES. You see THREE PATHS.<br>" +
                "<br><font color='red'>All of them smell of blood and death.</font>");

        gameworld.getUi().choice1.setText("Go EAST, towards the PLAINS");
        gameworld.getUi().choice2.setText("Go NORTH, towards the FOREST");
        gameworld.getUi().choice3.setText("Go WEST, towards the MOUNTAINS");
        gameworld.getUi().choice4.setText("Turn around and GO BACK to the TOWN");

        gameworld.setNextPosition1("PLAINS");
        gameworld.setNextPosition2("FOREST");
        gameworld.setNextPosition3("MOUNTAINS");
        gameworld.setNextPosition4("TOWN");
    }

    public void shop() {
        gameworld.getVm().showChoices();

        gameworld.getUi().mainTextArea.setText("You are in the <font color='red'>SHOP</font>. " +
                "<br><br><font color='red'>There's nobody here.</font>");

        gameworld.getUi().choice1.setText("Get OUT OF here");
        gameworld.getUi().choice2.setText("");
        gameworld.getUi().choice3.setText("");
        gameworld.getUi().choice4.setText("");

        gameworld.setNextPosition1("TOWN");
        gameworld.setNextPosition2("");
        gameworld.setNextPosition3("");
        gameworld.setNextPosition4("");

    }

    public void tavern() {
        gameworld.getVm().showChoices();

        gameworld.getUi().mainTextArea.setText("You find the <font color='red'>TAVERN</font>. " +
                "<br><br><font color='red'>It's empty.</font>");

        gameworld.getUi().choice1.setText("Get OUT OF here");
        gameworld.getUi().choice2.setText("");
        gameworld.getUi().choice3.setText("");
        gameworld.getUi().choice4.setText("");

        gameworld.setNextPosition1("TOWN");
        gameworld.setNextPosition2("");
        gameworld.setNextPosition3("");
        gameworld.setNextPosition4("");

    }

    public void contemplate() {
        gameworld.getVm().showChoices();

        gameworld.getUi().mainTextArea.setText("Your NAME is <font color='red'>"+GameWorld.getPlayer().getSaveName()+"</font>. " +
                "<br><br><font color='red'>Your QUEST to become a GOD is finally complete.</font>");

        gameworld.getUi().choice1.setText("<html><font color='red'>...</font></html>");
        gameworld.getUi().choice2.setText("");
        gameworld.getUi().choice3.setText("");
        gameworld.getUi().choice4.setText("");

        gameworld.setNextPosition1("TOWN");
        gameworld.setNextPosition2("");
        gameworld.setNextPosition3("");
        gameworld.setNextPosition4("");

    }

    public void characterSheet(){
        Player player = GameWorld.getPlayer();
        gameworld.getVm().showCharacterSheet();
        gameworld.getUi().characterStatsArea.setText(
                "Current stats:" +
                        "<br><br>Attack: " + player.getAttack() +
                        "<br>Max HP: " + player.getMaxhp() +
                        "<br>Armor: " + player.getArmor() +
                        "<br>THREAT RATING: " + "<font color='red'>XXX</font>" +
                        "<br>Gold coins: " + player.getMoney() +
                        "<br>Kills today: " + "<font color='red'>all</font>" +
                        "<br><br>Current goals:<br>" +
                        "<font color='red'>end it all</font>"

        );
        gameworld.getUi().characterEqArea.setText(
                "Equipped items:" +
                        "<br><br>Weapon: " + player.getWeapon().getName().toUpperCase() + " (+" +  player.getWeapon().getDamage() + ")" +
                        "<br><br>Head: " + player.getHead().getName().toUpperCase() + " (+" +  player.getHead().getDefence() + ")" +
                        "<br><br>Torso: " + player.getTorso().getName().toUpperCase() + " (+" +  player.getTorso().getDefence() + ")" +
                        "<br><br>Arms: " + player.getArms().getName().toUpperCase() + " (+" +  player.getArms().getDefence() + ")" +
                        "<br><br>Legs: " + player.getLegs().getName().toUpperCase() + " (+" +  player.getLegs().getDefence() + ")"

        );
    }

}
