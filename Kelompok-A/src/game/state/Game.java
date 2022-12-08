package game.state;

import game.engine.ChoiceHandler;
import game.engine.UI;
import game.engine.VisibilityManager;

public class Game {

    UI ui = new UI();
    VisibilityManager vm = new VisibilityManager(ui);
    GameWorld gameworld = new GameWorld(this, ui,vm);
    ChoiceHandler cHandler = new ChoiceHandler(gameworld);

    public static void main (String[]args){

        new Game();
    }

    public Game(){

        ui.createUI(cHandler);
        vm.showTitleScreen();

    }
}
