import javax.swing.*;

public class Window extends JFrame {
	Game gb;
	public Window() {
		gb = new Game(this);
		this.add(gb);
		this.setTitle(Settings.GAME_TITLE);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.pack();
		this.setLocationRelativeTo(null);
		this.setResizable(false);
		this.setVisible(true);
	}

}
