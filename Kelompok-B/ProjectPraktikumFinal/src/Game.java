import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.sql.ResultSet;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

public class Game extends JPanel implements KeyListener {
	Window window;
	Database db;
	PlayMusic music1 = new PlayMusic("assets/musics/bgmMenu.wav");
	PlayMusic music2 = new PlayMusic("assets/musics/Click.wav");
	Rocket user = new Rocket(Settings.DEFAULT_POSITION, Settings.WINDOW_HEIGHT - Settings.ENTITY_HEIGHT);
	Asteroid[] asteroids = new Asteroid[Settings.TOTAL_TRAFFIC];
	Traffic traffic;
	boolean isCrashed;
	public int gameState;
	public int num = 1;
	public final int menuState = 0;
	public final int playState = 1;
	public final int scoreState = 2;
	public Game(Window window) {
		super();
		db = new Database();
		gameState = menuState;
		this.setPreferredSize(new Dimension(Settings.WINDOW_WIDTH, Settings.WINDOW_HEIGHT));
		this.window = window;
		addKeyListener(this);
		setFocusable(true);
		music1.PlayMusicMenu();
		for (int i = 0; i < asteroids.length; i++) {
			asteroids[i] = new Asteroid(Settings.DEFAULT_POSITION,
					-(Settings.ENTITY_HEIGHT + Settings.GAP_BETWEEN) * (i + 1));
			if (Math.random() < 0.5) {
				asteroids[i].moveLeft();
			} else {
				asteroids[i].moveRight();
			}
		}
		this.isCrashed = false;
		traffic = new Traffic(asteroids, user, this);
	}
	public void restartGame() {
		this.removeKeyListener(this);
		window.dispose();
		window = new Window();
	}
	@Override
	public void keyPressed(KeyEvent event) {
		if (gameState == playState) {
			if (isCrashed) {
				return;
			}
			if (event.getKeyCode() == event.VK_LEFT) {
				user.moveLeft();
			} else if (event.getKeyCode() == event.VK_RIGHT) {
				user.moveRight();
			}
		}
		if (gameState == menuState) {
			if (event.getKeyCode() == event.VK_UP) {
				if (num != 0) {
					num--;
					music2.PlayMusicKlik();
					paint(getGraphics());
				}
			} else if (event.getKeyCode() == event.VK_DOWN) {
				if (num != 2) {
					num++;
					music2.PlayMusicKlik();
					paint(getGraphics());
				}
			} else if (event.getKeyCode() == event.VK_ENTER) {
				music2.PlayMusicKlik();
				if (num == 0) {
					user.name = JOptionPane.showInputDialog("Enter Your Gamer-tag ! ");
					music2.PlayMusicKlik();
					music1.stopSound();

					traffic.start();
					gameState = playState;
				} else if (num == 1) {
					music2.PlayMusicKlik();
					gameState = scoreState;
					paint(getGraphics());
				} else if (num == 2) {
					music2.PlayMusicKlik();
					System.exit(0);
				}
			}
		}
		if (gameState == scoreState) {
			if (event.getKeyCode() == event.VK_BACK_SPACE) {
				music2.PlayMusicKlik();
				gameState = menuState;
				num = 1;
				paint(getGraphics());
			}

		}

	}
	@Override
	public void keyReleased(KeyEvent arg0) {
		// TODO Auto-generated method stub
	}
	@Override
	public void keyTyped(KeyEvent arg0) {
		// TODO Auto-generated method stub
	}
	public void paint(Graphics g) {
		super.paintComponent(g);
		if (gameState == playState) {
			ImageIcon background = new ImageIcon(Settings.BACKGROUN_IMAGE_PATH);
			g.drawImage(background.getImage(), 0, 0, null);
			user.draw(g);

			for (int i = 0; i < asteroids.length; i++) {
				asteroids[i].draw(g);
			}

			g.setFont(new Font("default", Font.BOLD, 16));
			g.setColor(Color.white);
			g.drawString("Score: " + traffic.getScore(), 105, 20);
		}
		if (gameState == menuState) {
			ImageIcon background = new ImageIcon(Settings.BACKGROUN_IMAGE_PATH2);
			Color notSelected = new Color(255, 255, 255);
			Color selected = Color.decode("#F7B432");
			g.drawImage(background.getImage(), 0, 0, null);

			g.setFont(new Font("default", Font.BOLD, 20));
			g.setColor(notSelected);

			if (num == 0) {
				g.setFont(new Font("default", Font.BOLD, 30));
				g.setColor(selected);
				g.drawString("Play", 105, 180);

				g.setFont(new Font("default", Font.BOLD, 20));
				g.setColor(notSelected);
				g.drawString("Score", 105, 210);
				g.drawString("Exit", 105, 240);
			}

			if (num == 1) {
				g.drawString("Play", 105, 180);

				g.setFont(new Font("default", Font.BOLD, 30));
				g.setColor(selected);
				g.drawString("Score", 105, 210);

				g.setColor(notSelected);
				g.setFont(new Font("default", Font.BOLD, 20));
				g.drawString("Exit", 105, 240);
			}

			if (num == 2) {
				g.drawString("Play", 105, 180);
				g.drawString("Score", 105, 210);

				g.setFont(new Font("default", Font.BOLD, 30));
				g.setColor(selected);
				g.drawString("Exit", 105, 240);
			}
		}
		if (gameState == scoreState) {
			ImageIcon background = new ImageIcon(Settings.BACKGROUN_IMAGE_PATH3);
			g.drawImage(background.getImage(), 0, 0, null);
			try {
				String sql = "SELECT * FROM player ORDER BY score DESC LIMIT 10";
				ResultSet res = db.stmt.executeQuery(sql);
				g.setColor(Color.decode("#F7B432"));
				g.drawString("SCOREBOARD", 90, 40);
				int y = 50;
				while (res.next()) {
					y += 20;
					g.drawString(res.getString("name"), 50, y);
					g.drawString(res.getString("score"), 200, y);
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
		}

	}
}