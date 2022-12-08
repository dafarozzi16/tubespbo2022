package game.scenarios;

import game.generators.TextGenerator;
import game.state.GameWorld;

public class Town {

    GameWorld gameworld;

    public Town(GameWorld gameworld) {
        this.gameworld = gameworld;
    }

    public void go() { // generator opisów DO ZAIMPLEMENTOWANIA

        gameworld.getVm().showChoices();

        gameworld.getUi().mainTextArea.setText("You are currently in <font color='red'>TOWN</font>. It is "+ TextGenerator.weather() +". " +
                "The poeple around seem "+ TextGenerator.emotion(GameWorld.getPlayer().killedPlainsBoss(), GameWorld.getPlayer().killedForestBoss()) +".");

        gameworld.getUi().choice1.setText("Find the TAVERN");
        gameworld.getUi().choice2.setText("Go to the SHOP");
        gameworld.getUi().choice3.setText("CONTEMPLATE your life choices");
        gameworld.getUi().choice4.setText("Get OUT OF here");

        gameworld.setNextPosition1("TAVERN");
        gameworld.setNextPosition2("SHOP");
        gameworld.setNextPosition3("CONTEMPLATE");
        gameworld.setNextPosition4("FIGHT_CHOOSE");
    }

    public void contemplate() {

        gameworld.getUi().mainTextArea.setText("Your NAME is "+GameWorld.getPlayer().getSaveName()+". It is currently "+ TextGenerator.weather() +
                ". You are a "+ GameWorld.getPlayer().getTrait1()+", "+GameWorld.getPlayer().getTrait2()+" "+
                GameWorld.getPlayer().getAge()+" " + GameWorld.getPlayer().getGender()+".<br>"+
                "You have a fondness for "+ GameWorld.getPlayer().getHobby1() +" and are an ASPIRING "+
                GameWorld.getPlayer().getJob()+". You like "+GameWorld.getPlayer().getHobby2()+" but are NOT VERY GOOD AT IT.<br>" +
                "You also enjoy KILLING THINGS sometimes.");

        gameworld.getUi().choice1.setText("Get me THE HELL OUT OF HERE");
        gameworld.getUi().choice2.setText("");
        gameworld.getUi().choice3.setText("");
        gameworld.getUi().choice4.setText("");

        gameworld.setNextPosition1("TOWN");
        gameworld.setNextPosition2("");
        gameworld.setNextPosition3("");
        gameworld.setNextPosition4("");
    }
}
