package game.engine;

import javax.swing.*;
import java.awt.*;
import java.io.File;
import java.io.IOException;

public class UI {

    public JFrame window;
    public JPanel titleNamePanel, startButtonPanel, mainTextPanel, choiceButtonPanel, playerPanel, inputPanel, nameTextPanel,
                    inventoryPanel, goBackPanel, characterPanel, shopPanel, shopChoiceButtonsPanel;
    public JLabel titleNameLabel;
    public JLabel hpLabel;
    public JLabel hpNumberLabel;
    public JLabel nameTextLabel;
    Font titleFont = new Font("Monospaced", Font.PLAIN, 90);
    Font normalFont = new Font("Monospaced", Font.PLAIN, 19);
    Font smallFont = new Font("Monospaced", Font.PLAIN, 14);
    Font smallMediumFont = new Font("Monospaced", Font.PLAIN, 17);
    Font smallMediumPlusFont = new Font("Monospaced", Font.PLAIN, 18);
    Font pixelFont, pixelFontS, pixelFontSM, pixelFontL, pixelFontSMPlus, pixelEndFont;
    public JButton startButton, choice1, choice2, choice3, choice4, enterB, inventoryButton, characterButton, goBackButton, playerPaneMiddleButton;
    public JTextPane mainTextArea, characterStatsArea, characterEqArea, shopTextArea;
    public JTextField jtf;
    public JButton[] inventoryChoiceButtons, shopChoiceButtons;

    public void createUI(ChoiceHandler cHandler) {

        try {
            pixelFont = Font.createFont(Font.TRUETYPE_FONT, new File("PixelMplus10-Regular.ttf")).deriveFont(22f);
            pixelFontS = Font.createFont(Font.TRUETYPE_FONT, new File("PixelMplus10-Regular.ttf")).deriveFont(16f);
            pixelFontSM = Font.createFont(Font.TRUETYPE_FONT, new File("PixelMplus10-Regular.ttf")).deriveFont(20f);
            pixelFontL = Font.createFont(Font.TRUETYPE_FONT, new File("PixelMplus10-Regular.ttf")).deriveFont(110f);
            pixelFontSMPlus = Font.createFont(Font.TRUETYPE_FONT, new File("PixelMplus10-Regular.ttf")).deriveFont(21f);
            pixelEndFont = Font.createFont(Font.TRUETYPE_FONT, new File("PixelMplus10-Regular.ttf")).deriveFont(18f);
            GraphicsEnvironment ge = GraphicsEnvironment.getLocalGraphicsEnvironment();
            ge.registerFont(Font.createFont(Font.TRUETYPE_FONT, new File("PixelMplus10-Regular.ttf")));
        }
        catch (IOException | FontFormatException ignored){
        }

        //PIXEL FONT
        normalFont = pixelFont;
        smallFont = pixelFontS;
        titleFont = pixelFontL;
        smallMediumFont = pixelFontSM;
        smallMediumPlusFont = pixelFontSMPlus;


        // WINDOW
        window = new JFrame();
        window.setSize(800, 600);
        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        window.getContentPane().setBackground(Color.black);
        window.setLayout(null);
        window.setResizable(false);


        // TITLE SCREEN
        titleNamePanel = new JPanel();
        titleNamePanel.setBounds(100, 100, 600, 150);
        titleNamePanel.setBackground(Color.black);
        titleNameLabel = new JLabel("<html><font color='red'>GOD</font>QUEST</html>");
        titleNameLabel.setFont(titleFont);
        titleNameLabel.setForeground(Color.white);
        titleNamePanel.add(titleNameLabel);

        startButtonPanel = new JPanel();
        startButtonPanel.setBounds(300, 400, 200, 100);
        startButtonPanel.setBackground(Color.black);
        startButton = new JButton("START");
        startButton.setBackground(Color.black);
        startButton.setForeground(Color.white);
        startButton.setFont(normalFont);
        startButton.setFocusPainted(false);
        startButton.addActionListener(cHandler);
        startButton.setActionCommand("start");
        startButtonPanel.add(startButton);

        titleNamePanel.setVisible(false);
        startButtonPanel.setVisible(false);

        window.add(titleNamePanel);
        window.add(startButtonPanel);

        // GAME SCREEN
        mainTextPanel = new JPanel();
        mainTextPanel.setBounds(100, 100, 600, 250);
        mainTextPanel.setBackground(Color.black);

        mainTextArea = new JTextPane();
        mainTextArea.setBounds(100, 100, 600, 250);
        mainTextArea.setBackground(Color.black);
        mainTextArea.setForeground(Color.white);
        mainTextArea.setFont(normalFont);
        mainTextArea.setEditable(false);
        mainTextArea.setContentType("text/html");
        mainTextArea.setPreferredSize(new Dimension(600, 250));
        mainTextArea.putClientProperty(JEditorPane.HONOR_DISPLAY_PROPERTIES, Boolean.TRUE);
        mainTextPanel.add(mainTextArea);

        mainTextPanel.setVisible(false);
        window.add(mainTextPanel);

        // CHOICES
        choiceButtonPanel = new JPanel();
        choiceButtonPanel.setBounds(100, 380, 600, 150);
        choiceButtonPanel.setBackground(Color.black);
        choiceButtonPanel.setLayout(new GridLayout(4,1,7,7));

        choice1 = new JButton("Choice 1");
        choice1.setBackground(Color.black);
        choice1.setForeground(Color.white);
        choice1.setFont(smallMediumFont);
        choice1.setFocusPainted(false);
        choice1.setOpaque(false);
        choice1.addActionListener(cHandler);
        choice1.setActionCommand("c1");
        choiceButtonPanel.add(choice1);

        choice2 = new JButton("Choice 2");
        choice2.setBackground(Color.black);
        choice2.setForeground(Color.white);
        choice2.setFont(smallMediumFont);
        choice2.setFocusPainted(false);
        choice2.setOpaque(false);
        choice2.addActionListener(cHandler);
        choice2.setActionCommand("c2");
        choiceButtonPanel.add(choice2);

        choice3 = new JButton("Choice 3");
        choice3.setBackground(Color.black);
        choice3.setForeground(Color.white);
        choice3.setFont(smallMediumFont);
        choice3.setFocusPainted(false);
        choice3.setOpaque(false);
        choice3.addActionListener(cHandler);
        choice3.setActionCommand("c3");
        choiceButtonPanel.add(choice3);

        choice4 = new JButton("Choice 4");
        choice4.setBackground(Color.black);
        choice4.setForeground(Color.white);
        choice4.setFont(smallMediumFont);
        choice4.setFocusPainted(false);
        choice4.setOpaque(false);
        choice4.addActionListener(cHandler);
        choice4.setActionCommand("c4");
        choiceButtonPanel.add(choice4);

        choice1.setBorderPainted(true);
        choice2.setBorderPainted(true);
        choice3.setBorderPainted(true);
        choice4.setBorderPainted(true);

        choiceButtonPanel.setVisible(false);
        window.add(choiceButtonPanel);

        // PLAYER PANEL
        playerPanel = new JPanel();
        playerPanel.setBounds(100, 15, 600, 40);
        playerPanel.setBackground(Color.black);
        playerPanel.setLayout(new GridLayout(1,5,5,0));

        hpLabel = new JLabel("HP:");
        hpLabel.setFont(normalFont);
        hpLabel.setForeground(Color.white);
        playerPanel.add(hpLabel);

        hpNumberLabel = new JLabel();
        hpNumberLabel.setFont(normalFont);
        hpNumberLabel.setForeground(Color.white);
        playerPanel.add(hpNumberLabel);

        playerPaneMiddleButton = new JButton("<html><font color='red'>END THIS</font></html>");
        playerPaneMiddleButton.setBackground(Color.black);
        playerPaneMiddleButton.setForeground(Color.red);
        playerPaneMiddleButton.setFont(pixelEndFont);
        playerPaneMiddleButton.setFocusPainted(false);
        playerPaneMiddleButton.setOpaque(false);
        playerPaneMiddleButton.addActionListener(cHandler);
        playerPaneMiddleButton.setActionCommand("end_this");
        playerPanel.add(playerPaneMiddleButton);
        playerPaneMiddleButton.setVisible(false);

        inventoryButton = new JButton("Inventory");
        inventoryButton.setBackground(Color.black);
        inventoryButton.setForeground(Color.white);
        inventoryButton.setFont(smallFont);
        inventoryButton.setFocusPainted(false);
        inventoryButton.setOpaque(false);
        inventoryButton.addActionListener(cHandler);
        inventoryButton.setActionCommand("inventory");


        characterButton = new JButton("Journal");
        characterButton.setBackground(Color.black);
        characterButton.setForeground(Color.white);
        characterButton.setFont(smallFont);
        characterButton.setFocusPainted(false);
        characterButton.setOpaque(false);
        characterButton.addActionListener(cHandler);
        characterButton.setActionCommand("characterSheet");

        playerPanel.add(characterButton);
        playerPanel.add(inventoryButton);

        playerPanel.setVisible(false);
        window.add(playerPanel);

        // INPUT PANEL
        nameTextPanel = new JPanel();
        nameTextPanel.setBounds(150,200,500,100);
        nameTextPanel.setBackground(Color.black);
        nameTextLabel = new JLabel("Hi there. What's your NAME?");
        nameTextLabel.setForeground(Color.white);
        nameTextLabel.setFont(normalFont);
        nameTextPanel.add(nameTextLabel);

        inputPanel = new JPanel();
        inputPanel.setBounds(150,450,500,50);
        inputPanel.setBackground(Color.black);
        inputPanel.setLayout(new GridLayout(1,2));

        jtf = new JTextField();
        jtf.setFont(normalFont);
        jtf.setBackground(Color.black);
        jtf.setForeground(Color.white);
        jtf.setHorizontalAlignment(JTextField.CENTER);
        inputPanel.add(jtf);

        enterB = new JButton("ENTER");
        enterB.setActionCommand("input");
        enterB.setForeground(Color.white);
        enterB.setBackground(Color.black);
        enterB.addActionListener(cHandler);
        enterB.setFont(smallFont);
        inputPanel.add(enterB);

        nameTextPanel.setVisible(false);
        inputPanel.setVisible(false);

        window.add(nameTextPanel);
        window.add(inputPanel);

        window.setVisible(true);

        // INVENTORY SCREEN
        inventoryPanel = new JPanel();
        inventoryPanel.setBounds(100, 90, 600, 420);
        inventoryPanel.setBackground(Color.black);
        inventoryPanel.setLayout(new GridLayout(6,2, 10,6));

        inventoryChoiceButtons = new JButton[12];
        for (int i = 0; i < inventoryChoiceButtons.length; i++) {
            inventoryChoiceButtons[i] = new JButton("Inventory Inventory Inventory " + i);
            inventoryChoiceButtons[i].setOpaque(true);
            inventoryChoiceButtons[i].setFocusPainted(false);
            inventoryChoiceButtons[i].setBackground(Color.black);
            inventoryChoiceButtons[i].setForeground(Color.white);
            inventoryChoiceButtons[i].setFont(smallFont);
            inventoryChoiceButtons[i].addActionListener(cHandler);
            inventoryChoiceButtons[i].setActionCommand("I" + i);

            inventoryPanel.add(inventoryChoiceButtons[i]);
        }

        goBackPanel = new JPanel();
        goBackPanel.setBounds(320, 25, 160, 40);
        goBackPanel.setBackground(Color.black);
        goBackPanel.setLayout(new GridLayout(1,1));

        goBackButton = new JButton("EXIT");
        goBackButton.setBackground(Color.black);
        goBackButton.setForeground(Color.white);
        goBackButton.setFont(smallFont);
        goBackButton.setFocusPainted(false);
        goBackButton.setOpaque(false);
        goBackButton.addActionListener(cHandler);
        goBackButton.setActionCommand("exit");

        goBackPanel.add(goBackButton);

        goBackPanel.setVisible(false);
        inventoryPanel.setVisible(false);

        window.add(goBackPanel);
        window.add(inventoryPanel);

        // CHARACTER SCREEN
        characterPanel = new JPanel();
        characterPanel.setBounds(80, 90, 640, 500);
        characterPanel.setBackground(Color.black);
        characterPanel.setLayout(new GridLayout(1,2));

        characterStatsArea = new JTextPane();
        characterStatsArea.setBackground(Color.black);
        characterStatsArea.setForeground(Color.white);
        characterStatsArea.setFont(smallMediumPlusFont);
        characterStatsArea.setEditable(false);
        characterStatsArea.setContentType("text/html");
        characterStatsArea.setPreferredSize(new Dimension(320, 510));
        characterStatsArea.putClientProperty(JEditorPane.HONOR_DISPLAY_PROPERTIES, Boolean.TRUE);

        characterEqArea = new JTextPane();
        characterEqArea.setBackground(Color.black);
        characterEqArea.setForeground(Color.white);
        characterEqArea.setFont(smallMediumPlusFont);
        characterEqArea.setEditable(false);
        characterEqArea.setContentType("text/html");
        characterEqArea.setPreferredSize(new Dimension(320, 510));
        characterEqArea.putClientProperty(JEditorPane.HONOR_DISPLAY_PROPERTIES, Boolean.TRUE);


        characterPanel.add(characterStatsArea);
        characterPanel.add(characterEqArea);

        characterPanel.setVisible(false);
        window.add(characterPanel);

        //SHOP SCREEN
        //shopPanel = new JPanel();
        //shopPanel.setBounds(80, 90, 640, 420);
        //shopPanel.setBackground(Color.black);
        //shopPanel.setLayout(new GridLayout(1,2, 10, 0));

        shopPanel = new JPanel();
        shopPanel.setBounds(80,100,220,420);
        shopPanel.setBackground(Color.black);
        shopPanel.setLayout(new GridLayout(1,1));

        shopTextArea = new JTextPane();
        shopTextArea.setBackground(Color.black);
        shopTextArea.setForeground(Color.white);
        shopTextArea.setFont(smallMediumFont);
        shopTextArea.setEditable(false);
        shopTextArea.setContentType("text/html");
        shopTextArea.setPreferredSize(new Dimension(220, 510));
        shopTextArea.putClientProperty(JEditorPane.HONOR_DISPLAY_PROPERTIES, Boolean.TRUE);
        shopTextArea.setText("shop shop shop ");
        shopPanel.add(shopTextArea);

        shopChoiceButtonsPanel = new JPanel();
        shopChoiceButtonsPanel.setBounds(320, 100, 420, 420);
        shopChoiceButtonsPanel.setBackground(Color.black);
        shopChoiceButtonsPanel.setLayout(new GridLayout(12,1,0,5));

        shopChoiceButtons = new JButton[12];
        for (int i = 0; i < inventoryChoiceButtons.length; i++) {
            shopChoiceButtons[i] = new JButton("AMAZING POOP ON A STICK [+690](G4200) " + i);
            shopChoiceButtons[i].setOpaque(true);
            shopChoiceButtons[i].setFocusPainted(false);
            shopChoiceButtons[i].setBackground(Color.black);
            shopChoiceButtons[i].setForeground(Color.white);
            shopChoiceButtons[i].setFont(smallFont);
            shopChoiceButtons[i].addActionListener(cHandler);
            shopChoiceButtons[i].setActionCommand("S" + i);

            shopChoiceButtonsPanel.add(shopChoiceButtons[i]);
        }

        shopPanel.setVisible(false);
        shopChoiceButtonsPanel.setVisible(false);

        window.add(shopPanel);
        window.add(shopChoiceButtonsPanel);

    }

}