package game.scenarios;

import game.creature.Player;
import game.item.*;
import game.item.armor.*;
import game.state.GameWorld;

public class Inventory {

    GameWorld gameworld;
    String lastPosition;
    int lastLooked = 0;
    Player player;

    public Inventory(GameWorld gameworld) {
        this.gameworld = gameworld;
        this.player = GameWorld.getPlayer();
    }


    public void characterSheet(){

        String questDesc;

        if (player.getCurrentQuest().equals("") | player.getCurrentQuest().equals(" ") | player.getCurrentQuest().equals("  ")){
            questDesc = "<br>Kill things." +
                    "<br>Don't get killed." +
                    "<br>Have fun! ( <font color ='red'>'</font>⌣<font color ='red'>'</font> )";
        } else {
            questDesc = "<br>Kill " + player.getCurrentQuest()  + "<br> [ "
                    + player.getQuestCount() + " / " + player.getMaxQuestCount() + " ]";
        }


        gameworld.getVm().showCharacterSheet();
        gameworld.getUi().characterStatsArea.setText(
                "Current stats:" +
                "<br><br>Attack: " + player.getAttack() +
                "<br>Max HP: " + player.getMaxhp() +
                "<br>Armor: " + player.getArmor() +
                "<br>THREAT RATING: " + (int) player.getExp() +
                "<br>Gold coins: " + player.getMoney() +
                "<br>Kills today: " + player.getDailyKillCount() +
                "<br><br>Current goals:<br>" +
                questDesc
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

    public void manageInventory(){
        int i = 0;
        gameworld.getVm().showInventory();
        gameworld.getVm().changeBackButtonToExit();

        while (i < player.howManyItemsInInv() ) {
            gameworld.getUi().inventoryChoiceButtons[i].setText("<html>" + (i+1) + ". " +
                    player.getItemFromInv(i).getName().toUpperCase()
                    //player.getItemFromInv(i).getName().substring(0,1).toUpperCase()
                    //+ player.getItemFromInv(i).getName().substring(1)
                    + "</html>"
            );
            gameworld.getUi().inventoryChoiceButtons[i].setActionCommand("I" + i);
            gameworld.getUi().inventoryChoiceButtons[i].setBorderPainted(true);
            i++;
        }
        while (i < 12 ) {
            gameworld.getUi().inventoryChoiceButtons[i].setText("");
            gameworld.getUi().inventoryChoiceButtons[i].setActionCommand("");
            gameworld.getUi().inventoryChoiceButtons[i].setBorderPainted(false);
            i++;
        }
    }

    public void lookItem(Item item){
        gameworld.getVm().showChoicesForLookingAtItem();
        gameworld.getVm().changeExitButtonToGoBackFromLooking();
        String tmpText;
        tmpText = item.getName().toUpperCase();
        if (player.getHp()>0) tmpText = "You look at the " + tmpText + ".";

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

        gameworld.getUi().choice1.setText("USE this thing");
        gameworld.getUi().choice2.setText("NEXT item");
        gameworld.getUi().choice3.setText("PREVIOUS item");
        gameworld.getUi().choice4.setText("YEET it AWAY");

        gameworld.setNextPosition1("INVENTORY_USE");
        gameworld.setNextPosition2("INVENTORY_LOOK_NEXT");
        gameworld.setNextPosition3("INVENTORY_LOOK_PREV");
        gameworld.setNextPosition4("INVENTORY_YEET");

        if (player.getHp()==0){
            gameworld.getUi().choice1.setText(">");
            gameworld.getUi().choice2.setText("<");
            gameworld.getUi().choice3.setText("");
            gameworld.getUi().choice4.setText("");

            gameworld.setNextPosition1("INVENTORY_LOOK_NEXT");
            gameworld.setNextPosition2("INVENTORY_LOOK_PREV");
            gameworld.setNextPosition3("");
            gameworld.setNextPosition4("");
        }

        gameworld.getVm().hideUselessChoiceButtons();
    }

    public void use(){
        Item tmp = player.getItemFromInv(this.lastLooked);

        if (tmp instanceof Weapon) {
            gameworld.getUi().mainTextArea.setText("You let go of the " + player.getWeapon().getName().toUpperCase() +
                    " and arm yourself with the " + tmp.getName().toUpperCase() + "."
            );
        }
        if (tmp instanceof Head) {
            gameworld.getUi().mainTextArea.setText("You take off the " + player.getHead().getName().toUpperCase() +
                    " and put on the " + tmp.getName().toUpperCase() + "."
            );
        }
        if (tmp instanceof Torso) {
            gameworld.getUi().mainTextArea.setText("You take off the " + player.getTorso().getName().toUpperCase() +
                    " and put on the " + tmp.getName().toUpperCase() + "."
            );
        }
        if (tmp instanceof Arms) {
            gameworld.getUi().mainTextArea.setText("You take off the " + player.getArms().getName().toUpperCase() +
                    " and put on the " + tmp.getName().toUpperCase() + "."
            );
        }
        if (tmp instanceof Legs) {
            gameworld.getUi().mainTextArea.setText("You take off the " + player.getLegs().getName().toUpperCase() +
                    " and put on the " + tmp.getName().toUpperCase() + "."
            );
        }
        if (tmp instanceof Healing) {
            gameworld.getUi().mainTextArea.setText("You devour the " + tmp.getName().toUpperCase() + " and heal " +
                    Math.min(((Healing) tmp).getRestore(), player.getMaxhp()-player.getHp()) +
                    " HP."
            );
            gameworld.setNextPosition1("INVENTORY");
        }
        else {
            gameworld.setNextPosition1("INVENTORY_AFTER_EQUIP");}

        gameworld.getUi().choice1.setText(">");
        gameworld.getUi().choice2.setText("");
        gameworld.getUi().choice3.setText("");
        gameworld.getUi().choice4.setText("");


        gameworld.setNextPosition2("");
        gameworld.setNextPosition3("");
        gameworld.setNextPosition4("");

        if (tmp instanceof Weapon) player.replaceItemInInvWith(this.lastLooked, player.getWeapon());
        else if (tmp instanceof Head) player.replaceItemInInvWith(this.lastLooked, player.getHead());
        else if (tmp instanceof Torso) player.replaceItemInInvWith(this.lastLooked, player.getTorso());
        else if (tmp instanceof Arms) player.replaceItemInInvWith(this.lastLooked, player.getArms());
        else if (tmp instanceof Legs) player.replaceItemInInvWith(this.lastLooked, player.getLegs());

        this.player.useItem(tmp);


        if (tmp instanceof Healing) player.remove(this.lastLooked);
        gameworld.getVm().updateCurrentHPLabel(player.getHp());
    }

    public void yeet(){
        gameworld.getUi().mainTextArea.setText("You HURL the " + player.getItemFromInv(this.lastLooked).getName().toUpperCase() +
                " straight into the sun. SEE YOU SPACE COWBOY..."
        );

        player.yeetItemFromInv(this.lastLooked);

        gameworld.getUi().choice1.setText("");
        gameworld.getUi().choice2.setText("");
        gameworld.getUi().choice3.setText("");
        gameworld.getUi().choice4.setText(">");

        gameworld.setNextPosition1("");
        gameworld.setNextPosition2("");
        gameworld.setNextPosition3("");
        gameworld.setNextPosition4("INVENTORY");
    }

    public void lookNext(){
        this.lastLooked += 1;
        if (this.lastLooked==player.howManyItemsInInv()) this.lastLooked=0;
        lookItem(player.getItemFromInv(this.lastLooked));
    }

    public void lookPrev(){
        this.lastLooked -= 1;
        if (this.lastLooked==-1) this.lastLooked=player.howManyItemsInInv()-1;
        lookItem(player.getItemFromInv(this.lastLooked));
    }

    public void lookAfterSwapping(){
        lookItem(player.getItemFromInv(this.lastLooked));
    }

    public String getLastPosition() { return lastPosition;  }
    public void setLastPosition(String lastPosition) { this.lastPosition = lastPosition;  }

    //public int getLastLooked() { return lastLooked; }
    public void setLastLooked(int lastLooked) { this.lastLooked = lastLooked; }

}
