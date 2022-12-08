package game.engine;

import game.creature.Player;
import game.state.GameWorld;

import java.awt.event.ActionEvent;

import java.awt.event.ActionListener;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;


public class ChoiceHandler implements ActionListener{

    GameWorld gameworld;
    int bullshitCount = 0;

    public ChoiceHandler(GameWorld gameworld) {
        this.gameworld = gameworld;
    }

    Player player = GameWorld.getPlayer();

    public void actionPerformed(ActionEvent event){

        String choice = event.getActionCommand();

        switch(choice) {

            case "input":
                gameworld.setFromInventory(false);
                String text = gameworld.getUi().jtf.getText();
                gameworld.getUi().nameTextLabel.setText("Hi there. What's your NAME?");

                if (text.equals("") || text.equals(" ") || text.equals("  ") || text.equals("   ") || text.equals("    ")) {
                    gameworld.getUi().nameTextLabel.setText("...Could use a little more CREATIVITY.");
                    bullshitCount++;
                    if (bullshitCount>=2) {
                        gameworld.getUi().nameTextLabel.setText("C'mon, I'm not asking for much here.");}
                    if (bullshitCount>=3) {
                        gameworld.getUi().nameTextLabel.setText("Really now?");}
                    if (bullshitCount>=4) {
                        gameworld.getUi().nameTextLabel.setText("So what's it gonne be, FARTMASTER?");
                        player.setSaveName("FARTMASTER");
                        try {
                            gameworld.selectPosition("DESCRIPTION");
                        } catch (IOException e) {
                            e.printStackTrace();
                        }
                    }
                    player.fartmasterCount = bullshitCount;
                    break; }
                player.setSaveName(text);
                player.fartmasterCount = bullshitCount;
                try {
                    gameworld.selectPosition("DESCRIPTION");
                } catch (IOException e) {
                    e.printStackTrace();
                }
                break;

            case "start":
                gameworld.setFromInventory(false);
                try {
                    gameworld.selectPosition("BEGIN");
                } catch (IOException e) {
                    e.printStackTrace();
                }
                break;

            case "c1":
                gameworld.setFromInventory(false);
                try {
                    gameworld.selectPosition(gameworld.getNextPosition1());
                } catch (IOException e) {
                    e.printStackTrace();
                }
                break;

            case "c2":
                gameworld.setFromInventory(false);
                try {
                    gameworld.selectPosition(gameworld.getNextPosition2());
                } catch (IOException e) {
                    e.printStackTrace();
                }
                break;

            case "c3":
                gameworld.setFromInventory(false);
                try {
                    gameworld.selectPosition(gameworld.getNextPosition3());
                } catch (IOException e) {
                    e.printStackTrace();
                }
                break;

            case "c4":
                gameworld.setFromInventory(false);
                try {
                    gameworld.selectPosition(gameworld.getNextPosition4());
                } catch (IOException e) {
                    e.printStackTrace();
                }
                break;

            case "goBackFromLooking":
                gameworld.getVm().changeBackButtonToExit();

            case "inventory":
                gameworld.setFromInventory(true);
                try {
                    gameworld.selectPosition("INVENTORY");
                } catch (IOException e) {
                    e.printStackTrace();
                }
                break;

            case "characterSheet":
                gameworld.setFromInventory(true);
                try {
                    gameworld.selectPosition("CHARACTER_SHEET");
                } catch (IOException e) {
                    e.printStackTrace();
                }
                break;

            case "exit":
                gameworld.setFromInventory(true);
                gameworld.getVm().showChoices();
                try {
                    gameworld.selectPosition(gameworld.getInventory().getLastPosition());
                } catch (IOException e) {
                    e.printStackTrace();
                }
                break;

            case "goBackFromShop":
                gameworld.setFromInventory(false);
                try {
                    gameworld.selectPosition("SHOP");
                } catch (IOException e) {
                    e.printStackTrace();
                }
                break;
            case "end_this":
                GameWorld.getPlayer().setEnded(true);
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
                System.exit(0);
                break;

        }

        if (choice.startsWith("I")) {
            int i = Integer.parseInt(choice.substring(1));
            gameworld.getInventory().lookItem(player.getItemFromInv(i));
            gameworld.getInventory().setLastLooked(i);
        }

        if (choice.startsWith("S")) {
            int i = Integer.parseInt(choice.substring(1));
            gameworld.getShop().sellAThing(i);
        }

        if (choice.startsWith("B")) {
            int i = Integer.parseInt(choice.substring(1));
            gameworld.getShop().buyAThing(i);
        }

    }

}