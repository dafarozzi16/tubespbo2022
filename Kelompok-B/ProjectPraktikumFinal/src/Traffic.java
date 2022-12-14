import java.sql.SQLException;

import javax.swing.JOptionPane;

public class Traffic extends Thread {
	Asteroid[] asteroids;
	Rocket user;
	GameBoard board;
	PlayMusic music1 = new PlayMusic("assets/musics/bgmPlay.wav");
	PlayMusic music2 = new PlayMusic("assets/musics/GameOver.wav");
	int points = 0;

	public Traffic(Asteroid[] asteroids, Rocket user, GameBoard board) {
		this.asteroids = asteroids;
		this.user = user;
		this.board = board;
	}

	@Override
	public void run() {
		music1.PlayMusicStart();
		while (true) {
			for (int i = 0; i < asteroids.length; i++) {
				if (asteroids[i].getPosY() > Settings.WINDOW_HEIGHT) {
					points++;

					int y = asteroids[i].getPosY();

					y = y - Settings.TOTAL_TRAFFIC * (Settings.ENTITY_HEIGHT + Settings.GAP_BETWEEN);

					asteroids[i].setPosY(y);

					if (Math.random() <= 0.5) {
						asteroids[i].moveLeft();
					} else {
						asteroids[i].moveRight();
					}
				} else {
					asteroids[i].setPosY(asteroids[i].getPosY() + 1);
				}
			}

			board.repaint();

			if (checkCollision()) {
				music1.stopSound();
				music2.PlayMusicGameOver();
				try {
					if (user.name != null) {
						String sql = "INSERT INTO player (name, score) VALUE('%s', '%s')";
						sql = String.format(sql, user.name, points);
						board.db.stmt.execute(sql);
					}
				} catch (SQLException e) {
					e.printStackTrace();
				}
				board.isCrashed = true;
				JOptionPane.showMessageDialog(null, "Game Over. Your Score : " + points);
				board.restartGame();
				break;
			}

			//level speed is increasing based on player points
			try {
				int sleepTime = 6 - points / 10;
				if (sleepTime <= 0) {
					sleepTime = 1;
				}
				Thread.sleep(sleepTime);
				// Thread.sleep(2);
			} catch (Exception ex) {

			}
		}
	}

	public int getScore() {
		return this.points;
	}

	public int getExtraSpaceNeeded() {
		int speedLevel = this.points / 10;

		if (speedLevel >= 5) {
			speedLevel = 6;
		}

		return speedLevel * 10;
	}

	public boolean checkCollision() {

		for (int i = 0; i < asteroids.length; i++) {
			Asteroid asteroid = asteroids[i];

			if (asteroid.getPosX() == user.getPosX()) {
				if (asteroid.getPosY() > user.getPosY()) {
					int d = asteroid.getPosY() - user.getPosY();

					if (d < (Settings.ENTITY_HEIGHT - 20)) {
						return true;
					}
				} else {

					int d = user.getPosY() - asteroid.getPosY();

					if (d < (Settings.ENTITY_HEIGHT - 25)) {
						return true;
					}
				}
			}
		}

		return false;

	}

}