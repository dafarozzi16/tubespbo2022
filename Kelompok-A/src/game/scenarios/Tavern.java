package game.scenarios;

import game.creature.Player;
import game.engine.Helper;
import game.generators.QuestGenerator;
import game.generators.TextGenerator;
import game.state.GameWorld;

import java.io.BufferedWriter;
import java.io.FileWriter;

public class Tavern {

    GameWorld gameworld;
    Player player;
    private int cost = 2;

    public Tavern(GameWorld gameworld) {
        this.gameworld = gameworld;
        this.player = GameWorld.getPlayer();
    }

    public void go() { // generator opisów DO ZAIMPLEMENTOWANIA

        gameworld.getUi().mainTextArea.setText("You manage to find the <font color='red'>TAVERN</font>. You see "+TextGenerator.randomPersonSlashGroup()
                +" sitting in the corner. The barmaid looks "+TextGenerator.emotion(player.killedPlainsBoss(), player.killedForestBoss()) +"." +
                "<br>It's time to...");

        if( gameworld.getTrueLastState().equals("DRINK") | gameworld.getTrueLastState().equals("TAVERN") |
                (gameworld.getInventory().lastPosition.equals("DRINK") & gameworld.getFromInventory()) |
                (gameworld.getInventory().lastPosition.equals("TAVERN") & gameworld.getFromInventory()) ) {
            gameworld.getUi().mainTextArea.setText("You don't have ENOUGH MONEY to buy this DRINK. <br>" +
                    "What are you gonna do now?");
        }

        gameworld.getUi().choice1.setText("Buy yourself a STIFF DRINK" + " {" + cost + " G}");
        gameworld.getUi().choice2.setText("Get a room and HIT THE HAY");
        gameworld.getUi().choice3.setText("Get OUT OF here");
        gameworld.getUi().choice4.setText("");

        gameworld.setNextPosition1("DRINK");
        gameworld.setNextPosition2("REST");
        gameworld.setNextPosition3("TOWN");
        gameworld.setNextPosition4("");

        if (player.getMoney() < cost){
            gameworld.setNextPosition1("TAVERN");
        }
    }

    public void drink() { //generator opisów DO ZAIMPLEMENTOWANIA
        String tmp = "a ";
        if (!gameworld.getFromInventory()){
            player.lowerMoney(cost);
            cost += 1;
        }
        if(gameworld.getTrueLastState().equals("DRINK")) {
            tmp = "another STIFF DRINK. It's a ";
        }

        String quest = player.getCurrentQuest();
        if (!gameworld.getFromInventory()){
            quest = QuestGenerator.newQuest(player);
        }

        String pre;
        if (Helper.startsWithVowel(quest)){ pre = " an "; }
        else { pre = " a "; }

        quest = "<br>You feel a strong desire to kill " + pre + quest.toUpperCase() + " today.<br>" +
                "Wait, actually, more like " + player.getMaxQuestCount() + " of those.<br>" +
                "It would make you EVEN MORE POWERFUL!";

        gameworld.getUi().mainTextArea.setText("You get yourself " + tmp + TextGenerator.drink()+". It tastes "+
                TextGenerator.taste()+". "+ quest);

        gameworld.getUi().choice1.setText("Buy yourself ANOTHER STIFF DRINK" + " {" + cost + " G}");
        gameworld.getUi().choice2.setText("Get a room and HIT THE HAY");
        gameworld.getUi().choice3.setText("Get OUT OF here");
        gameworld.getUi().choice4.setText("");

        gameworld.setNextPosition1("DRINK");
        gameworld.setNextPosition2("REST");
        gameworld.setNextPosition3("TOWN");
        gameworld.setNextPosition4("");

        if (player.getMoney() < cost){
            gameworld.setNextPosition1("TAVERN");
        }
    }

    public void rest(){ // save + generator opisów DO ZAIMPLEMENTOWANIA

        gameworld.getUi().mainTextArea.setText("You rent a room and decide to TAKE A BREATHER for the rest of the day." +
                "<br>You lie down and MAKE AN ENTRY in your JOURNAL.<br>" + "Your bed is "+TextGenerator.bedOrPillowDescription()+".<br>" +
                "You hear "+ TextGenerator.sound() +" in the background.<br>" + "The pillows are "+TextGenerator.bedOrPillowDescription()+".<br>" +
                "...<br>" + "Rise and shine! It's a NEW DAY. The SUN is UP and SO ARE YOU. You get up and GET OUT.<br>");

        player.setHp(player.getMaxhp());    // HEALOWANIE I UPDATE HP
        player.resetQuestCount();   // reset dziennego questa
        player.setCurrentQuest("");
        player.setMaxQuestCount(0);
        resetCost();   //reset ceny drinka
        gameworld.getVm().updateCurrentHPLabel(player.getHp());

        player.addOneDay(); //+1 do licznika dni i reset dailyKillCount
        player.resetDailyKillCount();

        try{
            BufferedWriter bw = new BufferedWriter(new FileWriter(player.getSaveName() + ".txt"));
            bw.write(""+player.getEnded()); bw.newLine();
            bw.write(""+player.getHp()); bw.newLine();
            bw.write(""+player.getArmor()); bw.newLine();
            bw.write(""+player.getAttack()); bw.newLine();
            bw.write(""+player.getMoney()); bw.newLine();
            bw.write(""+player.getExp()); bw.newLine();
            bw.write(player.getCurrentQuest()); bw.newLine();
            bw.write(""+player.getQuestCount()); bw.newLine();
            bw.write(""+player.getMaxQuestCount()); bw.newLine();
            bw.write(""+player.killedPlainsBoss()); bw.newLine();
            bw.write(""+player.killedForestBoss()); bw.newLine();
            bw.write(""+player.killedMountainsBoss()); bw.newLine();
            bw.write(""+player.triggeredMountainBoss()); bw.newLine();
            bw.write(player.getTrait1()); bw.newLine();
            bw.write(player.getTrait2()); bw.newLine();
            bw.write(player.getAge()); bw.newLine();
            bw.write(player.getGender()); bw.newLine();
            bw.write(player.getHobby1()); bw.newLine();
            bw.write(player.getHobby2()); bw.newLine();
            bw.write(player.getJob()); bw.newLine();
            bw.write(""+player.howManyItemsInInv()); bw.newLine();
            for (int i = 0; i < player.howManyItemsInInv(); i++){
                String p = String.valueOf(player.getItemFromInv(i).getClass().getSimpleName());
                bw.write(p); bw.newLine();
                bw.write(player.getItemFromInv(i).getName()); bw.newLine();
                bw.write(""+player.getItemFromInv(i).getStat()); bw.newLine();
                bw.write(""+player.getItemFromInv(i).getPrice()); bw.newLine();
            }
            // equipped weapon
            bw.write(player.getWeapon().getName()); bw.newLine();
            bw.write(""+player.getWeapon().getStat()); bw.newLine();
            bw.write(""+player.getWeapon().getPrice()); bw.newLine();
            // equipped head
            bw.write(player.getHead().getName()); bw.newLine();
            bw.write(""+player.getHead().getStat()); bw.newLine();
            bw.write(""+player.getHead().getPrice()); bw.newLine();
            // equipped arms
            bw.write(player.getArms().getName()); bw.newLine();
            bw.write(""+player.getArms().getStat()); bw.newLine();
            bw.write(""+player.getArms().getPrice()); bw.newLine();
            // equipped torso
            bw.write(player.getTorso().getName()); bw.newLine();
            bw.write(""+player.getTorso().getStat()); bw.newLine();
            bw.write(""+player.getTorso().getPrice()); bw.newLine();
            // equipped legs
            bw.write(player.getLegs().getName()); bw.newLine();
            bw.write(""+player.getLegs().getStat()); bw.newLine();
            bw.write(""+player.getLegs().getPrice()); bw.newLine();

            bw.close();
        }
        catch (Exception e){
            System.err.format("Exception: %s%n", e);
        }

        gameworld.getUi().choice1.setText("Start a NEW DAY");
        gameworld.getUi().choice2.setText("");
        gameworld.getUi().choice3.setText("");
        gameworld.getUi().choice4.setText("");

        gameworld.setNextPosition1("TOWN");
        gameworld.setNextPosition2("");
        gameworld.setNextPosition3("");
        gameworld.setNextPosition4("");
    }

    public void resetCost(){
        this.cost = 2;
    }
}
