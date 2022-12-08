package game.scenarios;

import game.creature.Player;
import game.generators.HealingGenerator;
import game.generators.ItemGenerator;
import game.generators.TextGenerator;
import game.item.*;
import game.state.GameWorld;

import java.util.ArrayList;
import java.util.Random;

public class Shop {

    GameWorld gameworld;
    Player player = GameWorld.getPlayer();
    ArrayList<Item> shopStock;
    Random rand = new Random();

    public Shop(GameWorld gameworld) {
        this.gameworld = gameworld;
        this.shopStock = new ArrayList<>();
        restockShopInventory();
    }

    public void go() { // generator opisów DO ZAIMPLEMENTOWANIA

        gameworld.getVm().showChoices();
        gameworld.getVm().changeBackButtonToExit();
        String restock = "";
        if (player.getLastShopRestock() != player.getDayCount()) {
            restockShopInventory();
            restock = "He also says the he's got NEW STUFF you haven't seen yet.<br>";
            player.setLastShopRestock(player.getDayCount());
        }

        gameworld.getUi().mainTextArea.setText("You are in the <font color='red'>SHOP</font>. The SHOPKEEPER seems "+
                TextGenerator.emotion(player.killedPlainsBoss(),player.killedForestBoss()) +
                " when he sees you. He asks if you're interested in BUYING or SELLING.<br>" +
                restock +
                "<br>You have " + player.getMoney() + " GOLD COINS on you.<br>" +
                "<br>You say that you want to...<br>");

        gameworld.getUi().choice1.setText("BUY stuff");
        gameworld.getUi().choice2.setText("SELL stuff");
        gameworld.getUi().choice3.setText("GET OUT of here");
        gameworld.getUi().choice4.setText("");

        gameworld.setNextPosition1("BUY");
        gameworld.setNextPosition2("SELL");
        gameworld.setNextPosition3("TOWN");
        gameworld.setNextPosition4("");
    }
    public void buy(){ // generator opisów DO ZAIMPLEMENTOWANIA

        gameworld.getUi().shopTextArea.setText("You want to BUY SOMETHING. You start BROWSING AROUND." +
                "<br><br>Current worn items:" +
                "<br><br>Weapon ATT: " + player.getWeapon().getStat() +
                "<br>Head DEF: " + player.getHead().getStat() +
                "<br>Torso DEF: " + player.getTorso().getStat() +
                "<br>Arm DEF: " + player.getArms().getStat() +
                "<br>Leg DEF: " + player.getLegs().getStat() +
                "<br><br>You have " + player.getMoney() + " GOLD COINS on you.<br>" );

        updateBuyList();

        gameworld.getVm().showShopScreen();
        gameworld.getVm().changeExitButtonToGoBackFromShop();
    }

    public void sell(){ // generator opisów DO ZAIMPLEMENTOWANIA

        gameworld.getUi().shopTextArea.setText("You want to SELL SOMETHING. Now you just have to decide what, exactly, you want to GET RID OF." +
                "<br><br>Current worn items:" +
                "<br><br>Weapon ATT: " + player.getWeapon().getStat() +
                "<br>Head DEF: " + player.getHead().getStat() +
                "<br>Torso DEF: " + player.getTorso().getStat() +
                "<br>Arm DEF: " + player.getArms().getStat() +
                "<br>Leg DEF: " + player.getLegs().getStat() +
                "<br><br>You have " + player.getMoney() + " GOLD COINS on you.<br>" );

        updateSellList();

        gameworld.getVm().showShopScreen();
        gameworld.getVm().changeExitButtonToGoBackFromShop();

    }

    public void restockShopInventory() {
            this.shopStock.clear();
            int i = 0;
            int itemCount = rand.nextInt(4) + 4;
            int healCount = itemCount + rand.nextInt(3) + 3;
            while (i<itemCount) {this.shopStock.add(ItemGenerator.newItem()); i++;}
            while (i<healCount) {this.shopStock.add(HealingGenerator.newHealingNotPotion()); i++; }
    }

    public int howManyItemsInShop(){
        return this.shopStock.size();
    }

    public void buyAThing(int numberOfThing){
        if (player.howManyItemsInInv()==12){
            gameworld.getUi().shopTextArea.setText("You sigh wistfully. You really wanna BUY THIS THING but you CAN'T because there's NO SPACE left in your BAG!" +
                    "<br><br>Current worn items:" +
                    "<br><br>Weapon ATT: " + player.getWeapon().getStat() +
                    "<br>Head DEF: " + player.getHead().getStat() +
                    "<br>Torso DEF: " + player.getTorso().getStat() +
                    "<br>Arm DEF: " + player.getArms().getStat() +
                    "<br>Leg DEF: " + player.getLegs().getStat() +
                    "<br><br>You have " + player.getMoney() + " GOLD COINS on you.<br>" ); //update text
        }
        else if (player.getMoney()<this.shopStock.get(numberOfThing).getPrice()){
            gameworld.getUi().shopTextArea.setText("You sigh wistfully. You really wanna BUY THIS THING but you CAN'T because you're TOO BROKE!" +
                    "<br><br>Current worn items:" +
                    "<br><br>Weapon ATT: " + player.getWeapon().getStat() +
                    "<br>Head DEF: " + player.getHead().getStat() +
                    "<br>Torso DEF: " + player.getTorso().getStat() +
                    "<br>Arm DEF: " + player.getArms().getStat() +
                    "<br>Leg DEF: " + player.getLegs().getStat() +
                    "<br><br>You have " + player.getMoney() + " GOLD COINS on you.<br>" ); //update text
        }
        else{
            player.lowerMoney(shopStock.get(numberOfThing).getPrice());
            player.addItemToInv(shopStock.get(numberOfThing));
            shopStock.remove(numberOfThing);
            gameworld.getUi().shopTextArea.setText("Wonder of wonders, you had enough GOLD COINS so THE THING is now YOURS. Nice!" +
                    "<br><br>Weapon ATT: " + player.getWeapon().getStat() +
                    "<br>Head DEF: " + player.getHead().getStat() +
                    "<br>Torso DEF: " + player.getTorso().getStat() +
                    "<br>Arm DEF: " + player.getArms().getStat() +
                    "<br>Leg DEF: " + player.getLegs().getStat() +
                    "<br><br>You have " + player.getMoney() + " GOLD COINS on you.<br>" ); //update text
            updateBuyList();
        }
    }

    public void sellAThing(int numberOfThing){
        player.addMoney( player.getItemFromInv(numberOfThing).getPrice() );
        this.shopStock.add( player.getItemFromInv(numberOfThing) );
        player.removeItemFromInv(numberOfThing);

        gameworld.getUi().shopTextArea.setText("GOOD RIDDANCE. Anything else?" +
                "<br><br>Current worn items:" +
                "<br><br>Weapon ATT: " + player.getWeapon().getStat() +
                "<br>Head DEF: " + player.getHead().getStat() +
                "<br>Torso DEF: " + player.getTorso().getStat() +
                "<br>Arm DEF: " + player.getArms().getStat() +
                "<br>Leg DEF: " + player.getLegs().getStat() +
                "<br><br>You have " + player.getMoney() + " GOLD COINS on you.<br>" ); //update text

        updateSellList();
    }

    public void updateBuyList(){
        int i = 0;
        while (i < howManyItemsInShop() && i < 12 ) {
            gameworld.getUi().shopChoiceButtons[i].setText("<html>" +
                    this.shopStock.get(i).getName().toUpperCase() +
                    " [+" + this.shopStock.get(i).getStat() + "] {" +
                    this.shopStock.get(i).getPrice() + " G}" + "</html>"
            );
            gameworld.getUi().shopChoiceButtons[i].setActionCommand("B" + i);
            gameworld.getUi().shopChoiceButtons[i].setBorderPainted(true);
            i++;
        }
        while (i < 12 ) {
            gameworld.getUi().shopChoiceButtons[i].setText("");
            gameworld.getUi().shopChoiceButtons[i].setActionCommand("");
            gameworld.getUi().shopChoiceButtons[i].setBorderPainted(false);
            i++;
        }
    }

    public void updateSellList(){
        int i = 0;
        while (i < player.howManyItemsInInv() ) {
            gameworld.getUi().shopChoiceButtons[i].setText("<html>" +
                    player.getItemFromInv(i).getName().toUpperCase() +
                    " [+" + player.getItemFromInv(i).getStat() + "] {" +
                    player.getItemFromInv(i).getPrice() + " G}" + "</html>"
            );
            gameworld.getUi().shopChoiceButtons[i].setActionCommand("S" + i);
            gameworld.getUi().shopChoiceButtons[i].setBorderPainted(true);
            i++;
        }
        while (i < 12 ) {
            gameworld.getUi().shopChoiceButtons[i].setText("");
            gameworld.getUi().shopChoiceButtons[i].setActionCommand("");
            gameworld.getUi().shopChoiceButtons[i].setBorderPainted(false);
            i++;
        }
    }

}
