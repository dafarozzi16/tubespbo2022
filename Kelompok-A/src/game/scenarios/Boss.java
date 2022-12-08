package game.scenarios;

import game.generators.EnemyGenerator;
import game.state.Game;
import game.state.GameWorld;

public class Boss {
    GameWorld gameworld;

    public Boss(GameWorld gameworld) {
        this.gameworld = gameworld;
    }

    public void plainsBoss1() {

        gameworld.getUi().mainTextArea.setText("The air smells of <font color='red'>BLOOD</font>. You feel a CHILL DOWN YOUR SPINE. The earth starts TREMBLING. " +
                "<br><font color='red'>Something's coming</font>.");

        gameworld.getUi().choice1.setText(">");
        gameworld.getUi().choice2.setText("");
        gameworld.getUi().choice3.setText("");
        gameworld.getUi().choice4.setText("");

        gameworld.setNextPosition1("PLAINS_BOSS_2");
        gameworld.setNextPosition2("");
        gameworld.setNextPosition3("");
        gameworld.setNextPosition4("");
    }

    public void plainsBoss2() {

        gameworld.getUi().mainTextArea.setText("You look around but there's ABSOLUTELY NOTHING IN SIGHT. You start hearing a WEIRD SOUND. " +
                "It seems that it's coming from the ground?" +
                "<br><font color='red'>Something's DEFINITELY coming</font>.");

        gameworld.getUi().choice1.setText(">");
        gameworld.getUi().choice2.setText("");
        gameworld.getUi().choice3.setText("");
        gameworld.getUi().choice4.setText("");

        gameworld.setNextPosition1("PLAINS_BOSS_3");
        gameworld.setNextPosition2("");
        gameworld.setNextPosition3("");
        gameworld.setNextPosition4("");
    }

    public void plainsBoss3() {

        gameworld.getUi().mainTextArea.setText("Suddenly, <font color='red'>SOMETHING</font> BURSTS FROM THE GROUND. " +
                "Well, that's one mystery that nobody thought was a mystery and didn't really need solving but DAMN if it didn't just get solved. " +
                "<br> There's a <font color='red'>GIGANTIC GODDAMN FANGED WORM</font> staring RIGHT AT YOUR FACE. ");

        gameworld.getUi().choice1.setText("Gosh darn");
        gameworld.getUi().choice2.setText("");
        gameworld.getUi().choice3.setText("");
        gameworld.getUi().choice4.setText("");

        gameworld.setNextPosition1("PLAINS_BOSS_FIGHT");
        gameworld.setNextPosition2("");
        gameworld.setNextPosition3("");
        gameworld.setNextPosition4("");
    }

    public void plainsBossFight() {
        GameWorld.setCurrentEnemy(EnemyGenerator.areaBoss("PLAINS"));
        gameworld.getPlains().drop = EnemyGenerator.areaBoss("PLAINS").getRandomDrop();
        gameworld.getPlains().fight();
    }

    public void plainsBossKilled() {
        gameworld.getUi().mainTextArea.setText("You are now in the PLAINS. The entire place looks PRETTY DEVASTATED." +
                "<br>The air smells like <font color='red'>BLOOD</font> and <font color='red'>ROT</font>." +
                "<br>It is also <font color='red'>SILENT</font> LIKE A GRAVE." +
                "<br><br><font color='red'>Nice.</font>");

        gameworld.getUi().choice1.setText("<html><font color='red'>...</font></html>");
        gameworld.getUi().choice2.setText("");
        gameworld.getUi().choice3.setText("");
        gameworld.getUi().choice4.setText("");

        gameworld.setNextPosition1("FIGHT_CHOOSE");
        gameworld.setNextPosition2("");
        gameworld.setNextPosition3("");
        gameworld.setNextPosition4("");
    }

    public void forestBoss1() {

        gameworld.getUi().mainTextArea.setText("The air smells of <font color='red'>BLOOD</font>. " +
                "You feel LIKE SOMEBODY'S WALKING OVER YOUR GRAVE. The wind starts HOWLING. " +
                "<br><font color='red'>Something's coming</font>.");

        gameworld.getUi().choice1.setText(">");
        gameworld.getUi().choice2.setText("");
        gameworld.getUi().choice3.setText("");
        gameworld.getUi().choice4.setText("");

        gameworld.setNextPosition1("FOREST_BOSS_2");
        gameworld.setNextPosition2("");
        gameworld.setNextPosition3("");
        gameworld.setNextPosition4("");
    }

    public void forestBoss2() {

        gameworld.getUi().mainTextArea.setText("You look around but there's ABSOLUTELY NOTHING IN SIGHT. Well, except trees of course. " +
                "Which somehow start looking kinda sinister all of a sudden." +
                "<br><font color='red'>Something's DEFINITELY coming</font>.");

        gameworld.getUi().choice1.setText(">");
        gameworld.getUi().choice2.setText("");
        gameworld.getUi().choice3.setText("");
        gameworld.getUi().choice4.setText("");

        gameworld.setNextPosition1("FOREST_BOSS_3");
        gameworld.setNextPosition2("");
        gameworld.setNextPosition3("");
        gameworld.setNextPosition4("");
    }

    public void forestBoss3() {

        gameworld.getUi().mainTextArea.setText("Suddenly, A MURDER OF CROWS BURSTS THROUGH THE CANOPY. " +
                "The crows start cricling overhead while cawing at you incessantly. The amount of birds just keeps growing until " +
                "the only thing you can see are BLACK WINGS and BEADY EYES. And then, just as suddenly, they're gone." +
                "<br>And there's an <font color='red'>ANGRY FOREST GUARDIAN</font> staring RIGHT AT YOUR FACE. ");

        gameworld.getUi().choice1.setText("Huh");
        gameworld.getUi().choice2.setText("");
        gameworld.getUi().choice3.setText("");
        gameworld.getUi().choice4.setText("");

        gameworld.setNextPosition1("FOREST_BOSS_FIGHT");
        gameworld.setNextPosition2("");
        gameworld.setNextPosition3("");
        gameworld.setNextPosition4("");
    }

    public void forestBossFight() {
        GameWorld.setCurrentEnemy(EnemyGenerator.areaBoss("FOREST"));
        gameworld.getForest().drop = EnemyGenerator.areaBoss("FOREST").getRandomDrop();
        gameworld.getForest().fight();
    }

    public void forestBossKilled() {
        gameworld.getUi().mainTextArea.setText("You are now in the FOREST. The entire place looks DEAD." +
                "<br>The air smells like <font color='red'>BLOOD</font> and <font color='red'>DECAY</font>." +
                "<br>The trees are <font color='red'>SILENT</font>." +
                "<br><br><font color='red'>Nice.</font>");

        gameworld.getUi().choice1.setText("<html><font color='red'>...</font></html>");
        gameworld.getUi().choice2.setText("");
        gameworld.getUi().choice3.setText("");
        gameworld.getUi().choice4.setText("");

        gameworld.setNextPosition1("FIGHT_CHOOSE");
        gameworld.setNextPosition2("");
        gameworld.setNextPosition3("");
        gameworld.setNextPosition4("");
    }

    public void mountainsBoss1() {

        gameworld.getUi().mainTextArea.setText("The air smells of <font color='red'>BLOOD</font>. " +
                "You feel YOUR SINS CRAWLING DOWN YOUR BACK. It's quiet. " +
                "<br><font color='red'>You can feel it coming</font>.");

        gameworld.getUi().choice1.setText(">");
        gameworld.getUi().choice2.setText("");
        gameworld.getUi().choice3.setText("");
        gameworld.getUi().choice4.setText("");

        gameworld.setNextPosition1("MOUNTAINS_BOSS_2");
        gameworld.setNextPosition2("");
        gameworld.setNextPosition3("");
        gameworld.setNextPosition4("");
    }

    public void mountainsBoss2() {

        gameworld.getUi().mainTextArea.setText("You look around but there's ABSOLUTELY NOTHING IN SIGHT. " +
                        "You hear a quiet voice but cannot locate the source." +
                "<br><center><font color ='gray'>Why?</font></center>" +
                "<br><br><font color='red'>It's here</font>.");

        gameworld.getUi().choice1.setText(">");
        gameworld.getUi().choice2.setText("");
        gameworld.getUi().choice3.setText("");
        gameworld.getUi().choice4.setText("");

        gameworld.setNextPosition1("MOUNTAINS_BOSS_3");
        gameworld.setNextPosition2("");
        gameworld.setNextPosition3("");
        gameworld.setNextPosition4("");
    }

    public void mountainsBoss3() {

        gameworld.getUi().mainTextArea.setText("<center><font color ='gray'>Traveller, I wish I could say that there is still time to stop this. " +
                "I wish I could say it and mean it, but it is too late now. Far too late. You killed everything there was to kill. " +
                "This land is barren. The people dead or gone. The settlements abandoned. Was it hate or ambition that drove you to this, "
                + GameWorld.getPlayer().getSaveName() +"? Or maybe just plain boredom?</font></center>");

        gameworld.getUi().choice1.setText("<html><font color='red'>...</font></html>");
        gameworld.getUi().choice2.setText("");
        gameworld.getUi().choice3.setText("");
        gameworld.getUi().choice4.setText("");

        gameworld.setNextPosition1("MOUNTAINS_BOSS_4");
        gameworld.setNextPosition2("");
        gameworld.setNextPosition3("");
        gameworld.setNextPosition4("");
    }

    public void mountainsBoss4() {

        gameworld.getUi().mainTextArea.setText("<center><font color ='gray'>...It matters not, I suppose. </font></center>" +
                "<br><br>Hey! <font color='red'>The GODLY ANTLER-HEADED WET BLANKET</font> finally appears in front of you. About damn time! Looks kinda underwhelming, to be honest.");

        gameworld.getUi().choice1.setText("<html><font color='red'>Let's get this bread.</font></html>");
        gameworld.getUi().choice2.setText("");
        gameworld.getUi().choice3.setText("");
        gameworld.getUi().choice4.setText("");

        gameworld.setNextPosition1("MOUNTAINS_BOSS_FIGHT");
        gameworld.setNextPosition2("");
        gameworld.setNextPosition3("");
        gameworld.setNextPosition4("");
    }

    public void mountainsBossFight() {
        GameWorld.setCurrentEnemy(EnemyGenerator.areaBoss("MOUNTAINS"));
        gameworld.getMountains().drop = EnemyGenerator.areaBoss("MOUNTAINS").getRandomDrop();
        GameWorld.getPlayer().setTriggeredMountainBoss(true);
        gameworld.getMountains().fight();
    }

    public void mountainsBossKilled() {
        gameworld.getUi().mainTextArea.setText("You are now in the MOUNTAINS." +
                "<br>The air smells like <font color='red'>BLOOD</font> and <font color='red'>DEATH</font>." +
                "<br><br><font color='red'>It's peaceful.</font>");

        gameworld.getVm().showEndButton();
        gameworld.getUi().choice1.setText("<html><font color='red'>...</font></html>");
        gameworld.getUi().choice2.setText("");
        gameworld.getUi().choice3.setText("");
        gameworld.getUi().choice4.setText("");

        gameworld.setNextPosition1("FIGHT_CHOOSE");
        gameworld.setNextPosition2("");
        gameworld.setNextPosition3("");
        gameworld.setNextPosition4("");
    }

}
