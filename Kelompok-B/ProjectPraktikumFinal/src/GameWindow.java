import javax.swing.*;

public class GameWindow extends JFrame {

	GameBoard gb;

	public GameWindow() {

		gb = new GameBoard(this);
		this.add(gb);

		this.setTitle(Settings.GAME_TITLE);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		/*
		 * this.setSize not working. We need to set preffered size for JPanel(GameBoard)
		 * and call this.pack() here.
		 */

		this.pack();
		// this.setSize(Settings.WINDOW_WIDTH, Settings.WINDOW_HEIGHT);

		this.setLocationRelativeTo(null);

		this.setVisible(true);
	}

}
