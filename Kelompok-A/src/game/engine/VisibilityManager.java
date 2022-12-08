package game.engine;

import java.awt.*;

public class VisibilityManager {

    UI ui;

    public VisibilityManager(UI userInterface) {
        this.ui = userInterface;
    }

    public  void showChoices(){

        ui.titleNamePanel.setVisible(false);
        ui.startButtonPanel.setVisible(false);

        ui.mainTextPanel.setVisible(true);
        ui.choiceButtonPanel.setVisible(true);
        ui.playerPanel.setVisible(true);

        ui.inputPanel.setVisible(false);
        ui.nameTextPanel.setVisible(false);

        ui.inventoryPanel.setVisible(false);
        ui.characterPanel.setVisible(false);
        ui.goBackPanel.setVisible(false);

        ui.shopPanel.setVisible(false);
        ui.shopChoiceButtonsPanel.setVisible(false);
    }

    public  void showChoicesWithoutPlayerPanel(){

        ui.titleNamePanel.setVisible(false);
        ui.startButtonPanel.setVisible(false);

        ui.mainTextPanel.setVisible(true);
        ui.choiceButtonPanel.setVisible(true);
        ui.playerPanel.setVisible(false);

        ui.inputPanel.setVisible(false);
        ui.nameTextPanel.setVisible(false);

        ui.inventoryPanel.setVisible(false);
        ui.characterPanel.setVisible(false);
        ui.goBackPanel.setVisible(false);

        ui.shopPanel.setVisible(false);
        ui.shopChoiceButtonsPanel.setVisible(false);
    }

    public  void showChoicesForLookingAtItem(){

        ui.titleNamePanel.setVisible(false);
        ui.startButtonPanel.setVisible(false);

        ui.mainTextPanel.setVisible(true);
        ui.choiceButtonPanel.setVisible(true);
        ui.playerPanel.setVisible(false);

        ui.inputPanel.setVisible(false);
        ui.nameTextPanel.setVisible(false);

        ui.inventoryPanel.setVisible(false);
        ui.characterPanel.setVisible(false);
        ui.goBackPanel.setVisible(true);

        ui.shopPanel.setVisible(false);
        ui.shopChoiceButtonsPanel.setVisible(false);
    }

    public void showTitleScreen(){

        ui.startButtonPanel.setVisible(true);
        ui.titleNamePanel.setVisible(true);

        ui.mainTextPanel.setVisible(false);
        ui.choiceButtonPanel.setVisible(false);
        ui.playerPanel.setVisible(false);

        ui.inputPanel.setVisible(false);
        ui.nameTextPanel.setVisible(false);

        ui.inventoryPanel.setVisible(false);
        ui.characterPanel.setVisible(false);
        ui.goBackPanel.setVisible(false);

        ui.shopPanel.setVisible(false);
        ui.shopChoiceButtonsPanel.setVisible(false);
    }

    public void toBegin(){

        ui.titleNamePanel.setVisible(false);
        ui.startButtonPanel.setVisible(false);

        ui.mainTextPanel.setVisible(false);
        ui.choiceButtonPanel.setVisible(false);
        ui.playerPanel.setVisible(false);

        ui.inputPanel.setVisible(true);
        ui.nameTextPanel.setVisible(true);

        ui.inventoryPanel.setVisible(false);
        ui.characterPanel.setVisible(false);
        ui.goBackPanel.setVisible(false);

        ui.shopPanel.setVisible(false);
        ui.shopChoiceButtonsPanel.setVisible(false);
    }

    public void showInventory(){

        ui.titleNamePanel.setVisible(false);
        ui.startButtonPanel.setVisible(false);

        ui.mainTextPanel.setVisible(false);
        ui.choiceButtonPanel.setVisible(false);
        ui.playerPanel.setVisible(false);

        ui.inputPanel.setVisible(false);
        ui.nameTextPanel.setVisible(false);

        ui.inventoryPanel.setVisible(true);
        ui.characterPanel.setVisible(false);
        ui.goBackPanel.setVisible(true);

        ui.shopPanel.setVisible(false);
        ui.shopChoiceButtonsPanel.setVisible(false);
    }

    public void showCharacterSheet(){

        ui.titleNamePanel.setVisible(false);
        ui.startButtonPanel.setVisible(false);

        ui.mainTextPanel.setVisible(false);
        ui.choiceButtonPanel.setVisible(false);
        ui.playerPanel.setVisible(false);

        ui.inputPanel.setVisible(false);
        ui.nameTextPanel.setVisible(false);

        ui.inventoryPanel.setVisible(false);
        ui.characterPanel.setVisible(true);
        ui.goBackPanel.setVisible(true);

        ui.shopPanel.setVisible(false);
        ui.shopChoiceButtonsPanel.setVisible(false);
    }

    public void showShopScreen(){

        ui.titleNamePanel.setVisible(false);
        ui.startButtonPanel.setVisible(false);

        ui.mainTextPanel.setVisible(false);
        ui.choiceButtonPanel.setVisible(false);
        ui.playerPanel.setVisible(false);

        ui.inputPanel.setVisible(false);
        ui.nameTextPanel.setVisible(false);

        ui.inventoryPanel.setVisible(false);
        ui.characterPanel.setVisible(false);
        ui.goBackPanel.setVisible(true);

        ui.shopPanel.setVisible(true);
        ui.shopChoiceButtonsPanel.setVisible(true);
    }

    public void updateCurrentHPLabel(int currentHP) {
        ui.hpNumberLabel.setText(Integer.toString(currentHP));
    }
    public void changeBackButtonToExit(){
        ui.goBackButton.setActionCommand("exit");
        ui.goBackButton.setText("EXIT");
    }
    public void changeExitButtonToGoBackFromLooking(){
        ui.goBackButton.setActionCommand("goBackFromLooking");
        ui.goBackButton.setText("BACK");
    }

    public void changeExitButtonToGoBackFromShop(){
        ui.goBackButton.setActionCommand("goBackFromShop");
        ui.goBackButton.setText("DONE");
    }

    public void hideUselessChoiceButtons(){
        ui.choice1.setBorderPainted(true);
        ui.choice2.setBorderPainted(true);
        ui.choice3.setBorderPainted(true);
        ui.choice4.setBorderPainted(true);
        if (ui.choice1.getText().equals("")) ui.choice1.setBorderPainted(false);
        if (ui.choice2.getText().equals("")) ui.choice2.setBorderPainted(false);
        if (ui.choice3.getText().equals("")) ui.choice3.setBorderPainted(false);
        if (ui.choice4.getText().equals("")) ui.choice4.setBorderPainted(false);
    }

    public void setEverythingGray(){
        ui.titleNameLabel.setForeground(Color.gray);
        ui.hpLabel.setForeground(Color.gray);
        ui.hpNumberLabel.setForeground(Color.gray);
        ui.nameTextLabel.setForeground(Color.gray);

        ui.startButton.setForeground(Color.gray);

        ui.choice1.setForeground(Color.gray);
        ui.choice2.setForeground(Color.gray);
        ui.choice3.setForeground(Color.gray);
        ui.choice4.setForeground(Color.gray);

        ui.enterB.setForeground(Color.gray);
        ui.jtf.setForeground(Color.gray);

        ui.inventoryButton.setForeground(Color.gray);
        ui.characterButton.setForeground(Color.gray);
        ui.goBackButton.setForeground(Color.gray);
        ui.playerPaneMiddleButton.setForeground(Color.gray);

        ui.mainTextArea.setForeground(Color.gray);

        ui.characterStatsArea.setForeground(Color.gray);
        ui.characterEqArea.setForeground(Color.gray);
        ui.shopTextArea.setForeground(Color.gray);
        int i = 0;
        while(i<12) {
            ui.inventoryChoiceButtons[i].setForeground(Color.gray);
            ui.shopChoiceButtons[i].setForeground(Color.gray);
            i++;
        }
    }

    public void setEverythingWhite() {
        ui.titleNameLabel.setForeground(Color.white);
        ui.hpLabel.setForeground(Color.white);
        ui.hpNumberLabel.setForeground(Color.white);
        ui.nameTextLabel.setForeground(Color.white);

        ui.startButton.setForeground(Color.white);

        ui.choice1.setForeground(Color.white);
        ui.choice2.setForeground(Color.white);
        ui.choice3.setForeground(Color.white);
        ui.choice4.setForeground(Color.white);

        ui.enterB.setForeground(Color.white);
        ui.jtf.setForeground(Color.white);

        ui.inventoryButton.setForeground(Color.white);
        ui.characterButton.setForeground(Color.white);
        ui.goBackButton.setForeground(Color.white);
        ui.playerPaneMiddleButton.setForeground(Color.white);

        ui.mainTextArea.setForeground(Color.white);

        ui.characterStatsArea.setForeground(Color.white);
        ui.characterEqArea.setForeground(Color.white);
        ui.shopTextArea.setForeground(Color.white);
        int i = 0;
        while (i < 12) {
            ui.inventoryChoiceButtons[i].setForeground(Color.white);
            ui.shopChoiceButtons[i].setForeground(Color.white);
            i++;
        }
    }

    public void showEndButton(){
        ui.playerPaneMiddleButton.setVisible(true);
    }


}
